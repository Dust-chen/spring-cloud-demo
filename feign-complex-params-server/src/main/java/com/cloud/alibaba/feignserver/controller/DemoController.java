package com.cloud.alibaba.feignserver.controller;

import com.cloud.alibaba.feignserver.dto.DemoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${server.port}")
    private Integer serverPort;

    @RequestMapping("/echo")
    public String echo(String name) throws InterruptedException {
        // 模拟执行 100ms 时长。方便后续我们测试请求超时
        Thread.sleep(100);

        logger.info("[echo][被调用啦 name({})]", name);

        return serverPort + "-server:" + name;
    }

    @RequestMapping("/get_demo")
    public DemoDto getDemo(DemoDto demoDto){
        return demoDto;
    }

    @PostMapping("/post_demo")
    public DemoDto postDmeo(DemoDto demoDto){
        return demoDto;
    }
}
