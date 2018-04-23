package com.wzx.demo.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wzx.consumer.entity.LoanBaseInfo;
import com.wzx.vo.LoanBaseInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/findByLoanNo", method = RequestMethod.GET)
    public LoanBaseInfo hello() {
        LoanBaseInfoVO loanBaseInfoVO=  restTemplate.getForEntity("http://SERVICE-HELLO/findByLoanNo", LoanBaseInfoVO.class).getBody();
        LoanBaseInfo loanBaseInfo = new LoanBaseInfo();
        BeanUtils.copyProperties(loanBaseInfoVO,loanBaseInfo);
        return loanBaseInfo;
    }
}
