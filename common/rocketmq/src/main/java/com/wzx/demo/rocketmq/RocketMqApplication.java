package com.wzx.demo.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * rocketmq启动模块
 * @author wangzx
 * @date 2018/5/11 14:04:42
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RocketMqApplication {
        public static void main(String[] args) {
            SpringApplication.run(RocketMqApplication.class, args);
        }
}
