package com.cloud.alibaba.feignserver.controller;

import com.cloud.alibaba.feignserverapi.service.FeignApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring官方不推荐使用继承特性，因为通过 Java 接口的共享，导致服务提供者和消费者的耦合，而微服务的目的是为了服务提供者和消费者的解耦，存在一定的冲突。
 *
 * 不过实际场景下，蛮多公司采用继承特性，显而易见的好处，可以方便服务消费者的快速接入，基本无需编写额外的代码
 */
@RestController
public class DemoController implements FeignApiService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${server.port}")
    private Integer serverPort;

    @RequestMapping("/echo")
    public String echo(String name) {
        // 模拟执行 100ms 时长。方便后续我们测试请求超时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("[echo][被调用啦 name({})]", name);

        return serverPort + "-server:" + name;
    }
}
