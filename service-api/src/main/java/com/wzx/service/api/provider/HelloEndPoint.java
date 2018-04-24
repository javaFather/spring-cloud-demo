package com.wzx.service.api.provider;

import com.netflix.appinfo.EurekaInstanceConfig;
import com.wzx.consumer.entity.LoanBaseInfo;
import com.wzx.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public Response<LoanBaseInfo> hello() {
        this.logger.info("/hello, instanceId:{}, host:{}", eurekaInstanceConfig.getInstanceId(), eurekaInstanceConfig.getHostName(false));
            LoanBaseInfo loanBaseInfo = new LoanBaseInfo();
            loanBaseInfo.setLoanNo("20170825BDD3FB");
            loanBaseInfo.setAmount(new BigDecimal(9999.99).setScale(2,BigDecimal.ROUND_HALF_UP));
            loanBaseInfo.setCustomerCode("wangzx");
            loanBaseInfo.setCustomerName("深科技");
        return Response.ok().addResponse(loanBaseInfo);
    }
}
