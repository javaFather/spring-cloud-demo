package com.wzx.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 *
 * 发现者(最先启动)
 * @author wangzx
 * @date 2018/4/19 10:55
 */

@EnableEurekaServer
@SpringBootApplication
public class DiscoveryApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DiscoveryApplication.class).web(true).run(args);
    }
}
