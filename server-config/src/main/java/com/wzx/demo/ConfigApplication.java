package com.wzx.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author YM10174
 * @date 2018/5/14 10:52:40
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigApplication {
        public static void main(String[] args) {
            SpringApplication.run(ConfigApplication.class, args);
        }

}
