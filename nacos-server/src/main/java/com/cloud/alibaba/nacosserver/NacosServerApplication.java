package com.cloud.alibaba.nacosserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class NacosServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosServerApplication.class, args);
    }

    @RestController
    static class TestController{
        @RequestMapping(value = "/echo")
        public String echo(String name){
            return "nacos-server:" + name;
        }
    }
}
