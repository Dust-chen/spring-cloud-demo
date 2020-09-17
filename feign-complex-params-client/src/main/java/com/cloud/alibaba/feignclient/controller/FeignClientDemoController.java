package com.cloud.alibaba.feignclient.controller;

import com.cloud.alibaba.feignclient.dto.DemoDto;
import com.cloud.alibaba.feignclient.inter.FeignClientDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping("/test_get_demo")
    public DemoDto testGetDemo(@RequestParam("type") int type, DemoDto demoDto){
        if(type == 1){
            return feignClient.getDemo(demoDto);
        } else if(type == 2){
            return feignClient.getDemo(demoDto.getName(), demoDto.getCategory());
        } else{
            Map<String, Object> params = new HashMap<>();
            params.put("name", demoDto.getName());
            params.put("category", demoDto.getCategory());
            return feignClient.getDemo(params);
        }
    }

    @PostMapping("/test_post_demo")
    public DemoDto testPostDemo(DemoDto demoDto){
        return feignClient.postDemo(demoDto);
    }
}
