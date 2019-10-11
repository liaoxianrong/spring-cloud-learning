package com.liaoxr.cloud.application.demo.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StoreIntegration {

    @HystrixCommand(fallbackMethod = "defaultStores",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public Object getStores(Map<String, Object> parameters) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return parameters.size();
    }

    public Object defaultStores(Map<String, Object> parameters) {
        return "parameters is " + parameters;
    }
}
