package com.deals.service.impl;

import com.deals.constants.CurrencyCode;
import com.deals.dto.DealDTO;
import com.deals.entity.Deals;
import com.deals.exception.GenericException;
import com.deals.repository.DealRepository;
import com.deals.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Objects;

@Service
public class DealServiceImpl implements DealService {

    @Autowired
    private DealRepository dealRepository;

    @Override
    public String createDeal(DealDTO dealDTO) {
        currencyValidations(dealDTO.getFromCurrency());
        currencyValidations(dealDTO.getToCurrency());
        Deals deals = dealRepository.findByDealID(dealDTO.getDealID()).orElse(null);
        if(Objects.nonNull(deals)){
            throw new GenericException(HttpStatus.CONFLICT, String.valueOf(HttpStatus.CONFLICT.value()),
                    "Deal with id is already created");
        }
        deals = Deals.builder()
                .dealID(dealDTO.getDealID())
                .dealAmount(dealDTO.getDealAmount())
                .fromCurrency(dealDTO.getFromCurrency())
                .toCurrency(dealDTO.getToCurrency())
                .build();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy'T'HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(dealDTO.getDate(), formatter);
            System.out.println("Parsed LocalDateTime: " + dateTime);
            deals.setDate(dateTime);
        } catch (DateTimeParseException e) {
            throw new GenericException(HttpStatus.BAD_REQUEST, String.valueOf(HttpStatus.BAD_REQUEST.value()),
                    "invalid date required format is dd/mm/yyyy'T'HH:mm:ss");
        }
        dealRepository.save(deals);
        return "Your Deal is created successfully.";
    }

    private void currencyValidations(String currency) {
        boolean exist = false;
        for(CurrencyCode code: CurrencyCode.values()){
            if(code.equals(CurrencyCode.valueOf(currency))){
                exist = true;
            }
        }
        if(!exist){
            throw new GenericException(HttpStatus.BAD_REQUEST, String.valueOf(HttpStatus.BAD_REQUEST.value()),
                    "invalid currency " + currency);
        }
    }

}
