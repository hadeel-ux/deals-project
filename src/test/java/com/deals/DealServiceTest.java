package com.deals;

import com.deals.dto.DealDTO;
import com.deals.exception.GenericException;
import com.deals.repository.DealRepository;
import com.deals.service.impl.DealServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class DealServiceTest {

    @Autowired
    private DealServiceImpl dealService;

    @MockBean
    private DealRepository dealRepository;



    @Test
    public void testCreateDeal_ValidDate() {
        DealDTO dealDTO = new DealDTO();
        dealDTO.setDealID("123");
        dealDTO.setDealAmount(BigDecimal.valueOf(100.0));
        dealDTO.setFromCurrency("USD");
        dealDTO.setToCurrency("EUR");
        dealDTO.setDate("01/03/2024T04:17:00");
        when(dealRepository.findByDealID("123")).thenReturn(Optional.empty());

        String result = dealService.createDeal(dealDTO);

        Assertions.assertEquals("Your Deal is created successfully.", result);
    }

    @Test
    public void testCreateDeal_InvalidDateFormat() {
        DealDTO dealDTO = new DealDTO();
        dealDTO.setDealID("123");
        dealDTO.setDealAmount(BigDecimal.valueOf(100.0));
        dealDTO.setFromCurrency("USD");
        dealDTO.setToCurrency("EUR");
        dealDTO.setDate("2024-03-01T04:17:00"); // Invalid format

        Exception exception = Assertions.assertThrows(GenericException.class, () -> {
            dealService.createDeal(dealDTO);
        });

    }

}
