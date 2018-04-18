package com.wzx.demo.server.configuration;

import com.wzx.demo.server.restful.MyRestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {


    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new MyRestTemplate();
    }


}
