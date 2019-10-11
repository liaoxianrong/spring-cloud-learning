package com.liaoxr.cloud.application.demo;

import com.liaoxr.cloud.application.demo.hystrix.StoreIntegration;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@Slf4j
@EnableCircuitBreaker
//@EnableHystrixDashboard
public class SpringCloudDemoApplication {
    @Value("${com.liaoxr.test1}")
    private String test1;
    @Autowired
    private EurekaClient discoveryClient;
    @Autowired
    private StoreIntegration storeIntegration;
    @Autowired
    private LoadBalancerClient loadBalancer;

    public static void main(String[] args){
        SpringApplication.run(SpringCloudDemoApplication.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return "Hello world!" + test1;
    }
    @RequestMapping("/discovery-test")
    public String discovery() {
        InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka("LXR-CLOUD-DEMO2", false);
        log.info(instanceInfo.getHomePageUrl());
        log.info("{}", instanceInfo);
        return "Hello world!" + test1;
    }

    @RequestMapping("/hystrix-test/{param}")
    public Object hystrix(@PathVariable String param) {
        Map pMap = null;
        if ("1".equalsIgnoreCase(param)) {
            pMap = new HashMap();
            pMap.put("1", "1");
        }
        return storeIntegration.getStores(pMap);
    }

    @RequestMapping("/ribbon-test")
    public Object hystrix() {
        ServiceInstance instance = loadBalancer.choose("LXR-CLOUD-DEMO");
        log.info("{}", instance);
        return instance;
    }
}
