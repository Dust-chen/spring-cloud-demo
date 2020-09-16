package com.cloud.alibaba.feignclient.controller;

import com.cloud.alibaba.feignclient.inter.FeignClientDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignClientDemoController {

    @Autowired
    private FeignClientDemo feignClient;

    @RequestMapping("/hello02")
    public String hello02(String name){
        String response = feignClient.echo(name);
        // 返回结果
        return "client:" + response;
    }
}
