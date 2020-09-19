package com.cloud.alibaba.sentinelfeignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SentinelFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelFeignClientApplication.class, args);
    }

}
