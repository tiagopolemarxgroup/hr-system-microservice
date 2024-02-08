package com.ms.payhollapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Payroll {
    private String workerName;
    private String description;
    private Double hourlyPrice;
    private Double workerHours;
    private Double totalPayment;
}
