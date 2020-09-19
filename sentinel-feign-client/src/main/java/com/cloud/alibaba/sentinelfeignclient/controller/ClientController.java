package com.cloud.alibaba.sentinelfeignclient.controller;

import com.cloud.alibaba.sentinelfeignclient.inter.SentinelFeignClientDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/demo")
public class ClientController {
    @Autowired
    private SentinelFeignClientDemo client;

    @RequestMapping(value = "/echo")
    public String echo(){
        return client.echo();
    }
}
