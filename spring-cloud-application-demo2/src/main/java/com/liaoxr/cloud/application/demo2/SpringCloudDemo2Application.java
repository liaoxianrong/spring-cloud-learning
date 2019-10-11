package com.liaoxr.cloud.application.demo2;

import com.liaoxr.cloud.application.demo2.feign.Demo1Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
@EnableFeignClients
public class SpringCloudDemo2Application {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${com.liaoxr.test1}")
    private String test1;

    @Autowired
    private Demo1Client demo1Client;

    @RequestMapping("/feign-test")
    public String feign() {
        return demo1Client.getHome();
    }

    @RequestMapping("/")
    public String home() {
        return "Hello World!" + url + username + test1;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemo2Application.class, args);
    }
}
