package com.wzx.demo.controller;


import com.wzx.demo.LoanBaseInfo;
import com.wzx.demo.annotation.UserLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author wangzx
 * @date 2018
 */
@RestController

public class HelloController {
    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/findByLoanNo", method = RequestMethod.GET)
    @UserLogs(remark = "测试",operation = "成功")
    public LoanBaseInfo hello(LoanBaseInfo inf) {
        LoanBaseInfo info=  restTemplate.getForEntity("http://SERVICE-HELLO/findByLoanNo",LoanBaseInfo.class).getBody();
        return info;
    }
}
