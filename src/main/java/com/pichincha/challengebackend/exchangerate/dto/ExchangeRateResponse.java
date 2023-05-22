package com.pichincha.challengebackend.exchangerate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ExchangeRateResponse {

    private Long exchangeRateId;

    private String originCurrency;

    private String destinationCurrency;

    private Double exchangeRate;

    private Audit audit;

}
