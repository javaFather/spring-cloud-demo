package com.wzx.demo.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时获取数据
 * @author YM10174
 * @date 2018/12/12 16:33:55
 */
@Slf4j
@Component
public class DataSourceJob {

    @Scheduled(cron = "0/10 * *  * * ?")
    public void ScanData(){


    }
}
