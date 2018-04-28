package com.wzx.demo;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author wangzx
 * @date 2018/4/19 16:54:10
 */
@Data
@ToString
public class LoanBaseInfo {
    private String loanNo;
    private String customerCode;
    private String customerName;
    private BigDecimal amount;
}
