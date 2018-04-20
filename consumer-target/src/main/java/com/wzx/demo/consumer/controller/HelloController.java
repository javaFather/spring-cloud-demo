package com.wzx.demo.consumer.controller;

import com.wzx.vo.LoanBaseInfoVO;
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
    public void hello() {
        LoanBaseInfoVO loanBaseInfoVO=  restTemplate.getForEntity("http://SERVICE-HELLO/findByLoanNo", LoanBaseInfoVO.class).getBody();

    }
}
