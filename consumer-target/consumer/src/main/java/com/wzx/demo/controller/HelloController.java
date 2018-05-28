package com.wzx.demo.controller;


import com.wzx.demo.LoanBaseInfo;
import com.wzx.demo.annotation.UserLogs;
import com.wzx.demo.mapper.LoanBaseInfoMapper;
import com.wzx.demo.common.RocketMqProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
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


    @Autowired
    RocketMqProducer rocketMqProducer;
    @Autowired
    LoanBaseInfoMapper loanBaseInfoMapper;

    @RequestMapping(value = "/findByLoanNo", method = RequestMethod.GET)
    @UserLogs(remark = "测试",operation = "成功")
    public LoanBaseInfo hello(LoanBaseInfo inf) {
        LoanBaseInfo info=  restTemplate.getForEntity("http://SERVICE-HELLO/findByLoanNo",LoanBaseInfo.class).getBody();
        return info;
    }

    /**
     * 生产消息rocketmq
     * @param
     * @author wangzx
     * @date 2018/5/21 15:55
     */
    @RequestMapping(value = "/getRocketMq", method = RequestMethod.GET)
    public void getRocketMq(){
        Message msg = new Message();
        String text = "一条大河";
        msg.setTopic("weichat");
        msg.setFlag(10);
        msg.setBody(text.getBytes());
            SendResult send = rocketMqProducer.send(msg);

    }


    @RequestMapping(value = "/getByloanNo", method = RequestMethod.GET)
    public void getByloanNo(){
        String loanNo= "20170825BDD3FB";
        LoanBaseInfo loanBaseInfo = new LoanBaseInfo();
        loanBaseInfoMapper.insert(loanNo);


    }
}
