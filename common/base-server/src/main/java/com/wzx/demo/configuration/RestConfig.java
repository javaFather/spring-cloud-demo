package com.wzx.demo.configuration;

import com.wzx.demo.server.restful.MyRestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 *
 * 启动扫描在容器中实例化一个负载均衡对象
 * @author wangzx
 * @date 2018/4/19 15:25
 */

@Configuration
public class RestConfig {


    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new MyRestTemplate();
    }


}
