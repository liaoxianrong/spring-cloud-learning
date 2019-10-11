package com.liaoxr.cloud.application.demo2.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("lxr-cloud-demo")
public interface Demo1Client {
    @RequestMapping(method = RequestMethod.GET, value = "/demo/")
    String getHome();
}
