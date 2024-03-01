package com.deals.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DealDTO {

    @NotBlank(message = "deal identification number is required")
    private String dealID;

    @NotBlank(message = "From Currency ISO Code is required")
    private String fromCurrency;

    @NotBlank(message = "To Currency ISO Code is required")
    private String toCurrency;

    @NotBlank(message = "Deal time is required")
    private String date;

    @NotNull(message = "Deal Amount in ordering currency is required")
    @Min(value = 0, message = "Deal Amount can't be negative")
    private BigDecimal dealAmount;

}
