package com.wzx.demo.mybatistest.controller;

import com.wzx.demo.mybatistest.service.LoanBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanBaseController {
    @Autowired
    LoanBaseService loanBaseService;

    @GetMapping("add")
    public List add(){
        return loanBaseService.add();
    }
}
