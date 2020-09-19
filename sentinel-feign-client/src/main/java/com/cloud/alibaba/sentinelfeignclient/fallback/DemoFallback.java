package com.cloud.alibaba.sentinelfeignclient.fallback;

import com.cloud.alibaba.sentinelfeignclient.inter.SentinelFeignClientDemo;

public class DemoFallback implements SentinelFeignClientDemo {
    private Throwable throwable;

    public DemoFallback(Throwable throwable){
        this.throwable = throwable;
    }

    @Override
    public String echo() {
        return "echo:" + throwable.getClass().getSimpleName();
    }
}
