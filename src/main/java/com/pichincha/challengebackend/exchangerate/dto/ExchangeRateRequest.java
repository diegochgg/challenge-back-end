package com.pichincha.challengebackend.exchangerate.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class ExchangeRateRequest {

    private String originCurrency;

    private String destinationCurrency;

    private Double exchangeRate;

}
