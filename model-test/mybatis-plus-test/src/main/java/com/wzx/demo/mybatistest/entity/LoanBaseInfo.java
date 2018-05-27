package com.wzx.demo.mybatistest.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import static com.baomidou.mybatisplus.enums.FieldFill.INSERT;

@Data
@TableName("loan_base_info")
public class LoanBaseInfo {
    @TableField(value = "loanno", fill = INSERT)
    private String loanNo;
    @TableField(value = "customercode", fill = INSERT)
    private String customerCode;
    @TableField(value = "customername", fill = INSERT)
    private String customerName;

}
