package com.cloud.alibaba.feignclient.inter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 声明 Feign 客户端。其中 name 属性，为 Feign 客户端的名字，也为 Ribbon 客户端的名字，也为注册中心的服务的名字。
@FeignClient(name = "feign-server")
public interface FeignClientDemo {

    @RequestMapping(value = "/echo")
    String echo(@RequestParam("name") String name);
}
