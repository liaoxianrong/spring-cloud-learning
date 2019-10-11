package com.liaoxr.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SpringCloudGatewayApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringCloudGatewayApplication.class, args);
    }
}
