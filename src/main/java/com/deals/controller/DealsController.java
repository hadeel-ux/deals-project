package com.deals.controller;

import com.deals.dto.DealDTO;
import com.deals.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 4300)
@RequestMapping(value="/api/v1/deals")
@RestController
public class DealsController {

    @Autowired
    private DealService dealService;

    @PostMapping("")
    public String createDeal(@Valid @RequestBody DealDTO dealDTO){
        return dealService.createDeal(dealDTO);
    }
}
