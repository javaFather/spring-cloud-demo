package com.wzx.demo.mybatistest.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wzx.demo.mybatistest.entity.LoanBaseInfo;
import com.wzx.demo.mybatistest.mapper.LoanBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Wrapper;
import java.util.List;

@Service
public class LoanBaseService {

    @Autowired
    LoanBaseMapper loanBaseMapper;

    public List<LoanBaseInfo>  add(){
        LoanBaseInfo loanBaseInfo=new LoanBaseInfo();
        loanBaseInfo.setAmount(BigDecimal.ONE);
        loanBaseInfo.setCustomerCode("sss-1");
        loanBaseInfo.setCustomerName("sss-name1");
        loanBaseMapper.insert(loanBaseInfo);
        loanBaseInfo.setCustomerName("sss-name2");
        loanBaseMapper.insert(loanBaseInfo);


        List<LoanBaseInfo> list = loanBaseMapper.selectList(new EntityWrapper<LoanBaseInfo>().eq("customercode", "sss_1"));
        return list;
    }
}
