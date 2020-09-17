package com.cloud.alibaba.feignclient.inter;

import com.cloud.alibaba.feignclient.dto.DemoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

// 声明 Feign 客户端。其中 name 属性，为 Feign 客户端的名字，也为 Ribbon 客户端的名字，也为注册中心的服务的名字。
@FeignClient(name = "feign-complex-params-server")
public interface FeignClientDemo {

    @RequestMapping(value = "/echo")
    String echo(@RequestParam("name") String name);

    // 【最推荐】方式一，采用 Spring Cloud OpenFeign 提供的 @SpringQueryMap 注解，并使用 DemoDTO 对象
    @RequestMapping(value = "/get_demo")
    DemoDto getDemo(@SpringQueryMap DemoDto demoDto);

    // 【较推荐】方式二，采用 SpringMVC 提供的 @RequestParam 注解，并将所有参数平铺开
    @RequestMapping(value = "/get_demo")
    DemoDto getDemo(@RequestParam("name") String name, @RequestParam("category") String category);

    // 【不推荐】方式三，采用 SpringMVC 提供的 @RequestParam 注解，并使用 Map 对象。非常不推荐，因为可读性差，都不知道传递什么参数
    @RequestMapping(value = "/get_demo")
    DemoDto getDemo(@RequestParam Map<String, Object> params);

    // post唯一方式，采用 SpringMVC 提供的 @RequestBody 注解，并使用 DemoDTO 对象
    @PostMapping(value = "/post_demo")
    DemoDto postDemo(@RequestBody DemoDto demoDto);
}
