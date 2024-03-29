package com.liaoxr.cloud.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class SpringCloudStreamApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringCloudStreamApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void handle(Object obj) {
        System.out.println("Received: " + obj);
    }

}
