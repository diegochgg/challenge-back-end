package com.pichincha.challengebackend.exchangerate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exchangeRate")
public class ExchangeRateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exchangeRateId")
    private Long exchangeRateId;

    @Column(name = "originCurrency")
    private String originCurrency;

    @Column(name = "destinationCurrency")
    private String destinationCurrency;

    @Column(name = "exchangeRate")
    private Double exchangeRate;

    @Column(name = "deleted")
    private Boolean deleted;

    @Column(name = "createdDate")
    private LocalDateTime createdDate;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "lastModifiedDate")
    private LocalDateTime lastModifiedDate;

    @Column(name = "lastModifiedBy")
    private String lastModifiedBy;

}
