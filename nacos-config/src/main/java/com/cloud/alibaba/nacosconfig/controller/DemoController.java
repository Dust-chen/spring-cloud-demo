package com.cloud.alibaba.nacosconfig.controller;

import com.alibaba.fastjson.JSONObject;
import com.cloud.alibaba.nacosconfig.config.OssProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/demo")
@RefreshScope // @Value的配置自动刷新实现，@ConfigurationProperties不用加也能自动刷新
public class DemoController {
    @Autowired
    private OssProperties ossProperties;

    @RequestMapping(value = "/test01")
    public OssProperties test01(){
        return ossProperties;
    }

    @Value(value = "${oss.bucket-name}")
    private String bucketName;
    @Value(value = "${oss.object-name}")
    private String objectName;

    @RequestMapping(value = "/test02")
    public Map<String, Object> test02(){
        return new JSONObject().fluentPut("bucketName", bucketName).fluentPut("objectName", objectName);
    }
}
