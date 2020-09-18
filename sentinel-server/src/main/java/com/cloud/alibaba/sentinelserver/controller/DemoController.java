package com.cloud.alibaba.sentinelserver.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {
    @RequestMapping(value = "/echo")
    public String echo(){
        return "echo";
    }

    @RequestMapping(value = "/test")
    public String test(){
        return "test";
    }

    @RequestMapping(value = "/sleep")
    public String sleep() throws InterruptedException {
        Thread.sleep(100L);
        return "sleep";
    }

    @RequestMapping(value = "/user_info")
    @SentinelResource(value = "user_info_hot")
    public String userInfo(Integer id){
        return "用户id:" + id;
    }

    @RequestMapping(value = "/entry_demo")
    public String entryDemo(){
        Entry entry = null;
        try {
            // <1> 访问资源
            entry = SphU.entry("entry_demo");

            return "执行成功";
        } catch (BlockException e) {
            return "被拒绝";
        } finally{
            // 释放资源
            if(entry != null){
                entry.exit();
            }
        }
    }

    @RequestMapping(value = "/annotations_demo")
    @SentinelResource(value = "annotations_demo_resource",
            blockHandler = "blockHandler",
            fallback = "fallback"
    )
    public String annotationsDemo(@RequestParam(required = false) Integer id){
        if (id == null) {
            throw new IllegalArgumentException("id 参数不允许为空");
        }
        return "success...";
    }

    // BlockHandler 处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public String blockHandler(Integer id, BlockException ex){
        return "block：" + ex.getClass().getSimpleName();
    }

    // Fallback 处理函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
    public String fallback(Integer id, Throwable throwable){
        return "fallback：" + throwable.getMessage();
    }

}
