package com.cloud.alibaba.sentinelserver.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 当请求满足配置的 Sentinel block 的条件时，Sentinel 会抛出 BlockException 异常。通过定义 BlockExceptionHandler 接口的实现类，可以实现对 BlockException 的异常处理.
 * 这里自定义直接抛出异常，使用全局异常处理
 */
@Component
public class CustomerBlockExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        throw e;
    }
}
