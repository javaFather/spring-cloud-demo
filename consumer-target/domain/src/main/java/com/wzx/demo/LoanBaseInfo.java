package com.wzx.demo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

import static com.baomidou.mybatisplus.enums.FieldFill.INSERT;

/**
 * @author wangzx
 * @date 2018/4/19 16:54:10
 */
@Data
@ToString
@TableName("loan_base_info")
public class LoanBaseInfo {
    @TableField(value = "loanno", fill = INSERT)
    private String loanNo;
    @TableField(value = "customercode", fill = INSERT)
    private String customerCode;
    @TableField(value = "customername", fill = INSERT)
    private String customerName;
    @TableField(value = "amount", fill = INSERT)
    private BigDecimal amount;
}
