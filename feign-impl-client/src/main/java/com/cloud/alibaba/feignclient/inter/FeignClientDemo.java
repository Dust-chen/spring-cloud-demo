package com.cloud.alibaba.feignclient.inter;

import com.cloud.alibaba.feignserverapi.service.FeignApiService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * spring官方不推荐使用继承特性，因为通过 Java 接口的共享，导致服务提供者和消费者的耦合，而微服务的目的是为了服务提供者和消费者的解耦，存在一定的冲突。
 *
 * 不过实际场景下，蛮多公司采用继承特性，显而易见的好处，可以方便服务消费者的快速接入，基本无需编写额外的代码
 */
// 声明 Feign 客户端。其中 name 属性，为 Feign 客户端的名字，也为 Ribbon 客户端的名字，也为注册中心的服务的名字。
@FeignClient(name = "feign-impl-server")
public interface FeignClientDemo extends FeignApiService {

//    @RequestMapping(value = "/echo")
//    String echo(@RequestParam("name") String name);
}
