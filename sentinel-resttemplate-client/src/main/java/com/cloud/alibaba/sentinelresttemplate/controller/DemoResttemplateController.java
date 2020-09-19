package com.cloud.alibaba.sentinelresttemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/client")
public class DemoResttemplateController {

    private RestTemplate restTemplate;
    @Autowired
    public DemoResttemplateController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/echo")
    public String echo(){
        return restTemplate.getForObject("http://localhost:8080/demo/echo", String.class);
    }
}
