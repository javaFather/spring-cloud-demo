package com.wzx.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author YM10174
 * @date 2018/12/12 16:49:18
 */
@EnableDiscoveryClient
@SpringBootApplication
/**允许开启定时任务s**/
@EnableScheduling
public class JobApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
    }
}
