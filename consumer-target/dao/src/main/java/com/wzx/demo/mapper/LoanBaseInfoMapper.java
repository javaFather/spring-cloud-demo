package com.wzx.demo.mapper;


import com.wzx.demo.LoanBaseInfo;

/**
 * @author wangzx
 * @date 2018/4/20 10:52:16
 */
public interface LoanBaseInfoMapper {
    /** 获取单个对象**/
    LoanBaseInfo find(String loanNo);
}
