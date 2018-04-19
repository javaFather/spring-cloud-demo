package com.wzx.consumer.entity;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author wangzx
 * @date 2018/4/19 16:54:10
 */
@Data
@ToString
public class LoanBaseInfo {
    private BigInteger loanNo;
    private String customerCode;
    private String customerName;
    private BigDecimal amount;
}
