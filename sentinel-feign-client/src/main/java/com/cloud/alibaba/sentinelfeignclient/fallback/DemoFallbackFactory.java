package com.cloud.alibaba.sentinelfeignclient.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class DemoFallbackFactory implements FallbackFactory<DemoFallback> {

    @Override
    public DemoFallback create(Throwable throwable) {
        // 可以给 DemoFallback 提供具体的 throwable 异常
        return new DemoFallback(throwable);
    }
}
