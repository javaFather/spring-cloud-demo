package com.wzx.service.api.provider;

import com.netflix.appinfo.EurekaInstanceConfig;
import com.wzx.vo.LoanBaseInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class HelloEndPoint {
    protected Logger logger = LoggerFactory.getLogger(HelloEndPoint.class);

    @Autowired
    private EurekaInstanceConfig eurekaInstanceConfig;
    @Value("${server.port}")
    private int serverPort = 0;

    @RequestMapping(value = "/findByLoanNo", method = RequestMethod.GET)
    public LoanBaseInfoVO hello() {
        this.logger.info("/hello, instanceId:{}, host:{}", eurekaInstanceConfig.getInstanceId(), eurekaInstanceConfig.getHostName(false));
            LoanBaseInfoVO loanBaseInfoVO = new LoanBaseInfoVO();
            loanBaseInfoVO.setLoanNo("20170825BDD3FB");
            loanBaseInfoVO.setAmount(new BigDecimal(9999.99).setScale(2,BigDecimal.ROUND_HALF_UP));
            loanBaseInfoVO.setCustomerCode("wangzx");
            loanBaseInfoVO.setCustomerName("深科技");
        return loanBaseInfoVO;
    }
}
