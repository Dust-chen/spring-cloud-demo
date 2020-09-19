package com.cloud.alibaba.sentinelfeignclient.inter;

import com.cloud.alibaba.sentinelfeignclient.fallback.DemoFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "sentinel-server", url = "http://localhost:8080", fallbackFactory = DemoFallbackFactory.class)
public interface SentinelFeignClientDemo {

    @RequestMapping(value = "/demo/echo")
    String echo();
}
