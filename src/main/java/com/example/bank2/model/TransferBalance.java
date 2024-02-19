package com.example.bank2.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class TransferBalance {


    private Long From;
    private Long To;
    private BigDecimal Amount;
}
