package com.cloud.alibaba.feignserverapi.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface FeignApiService {

    @RequestMapping("/echo")
    String echo(@RequestParam("name") String name);
}
