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
public class Audit {

    private Boolean deleted;

    private String createdDate;

    private String createdBy;

    private String lastModifiedDate;

    private String lastModifiedBy;

}
