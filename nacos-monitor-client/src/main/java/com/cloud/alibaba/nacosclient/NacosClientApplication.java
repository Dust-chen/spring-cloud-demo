package com.cloud.alibaba.nacosclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Service;
import java.util.List;

@SpringBootApplication
public class NacosClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosClientApplication.class, args);
	}

	@Configuration
	public class RestTemplateConfiguration{
		@Bean
		public RestTemplate restTemplate(){
			return new RestTemplate();
		}
	}

	@RestController
	static class TestController{
		@Autowired
		private DiscoveryClient discoveryClient;
		@Autowired
		private RestTemplate restTemplate;
		@Autowired
		private LoadBalancerClient loadBalancerClient;

		@RequestMapping(value = "hello")
		public String hello(String name){
			// <1> 获得服务 `nacos-server` 的一个实例
			ServiceInstance instance;
			if(true){
				// 获取服务 `nacos-server` 对应的实例列表
				List<ServiceInstance> instances = discoveryClient.getInstances("nacos-server");
				instance = instances.size() > 0 ? instances.get(0) : null;
			} else {
				instance = loadBalancerClient.choose("nacos-server");
			}
			if(instance == null){
				throw new IllegalStateException("获取不到实例");
			}
			// <2> 发起调用
			String targetUrl = instance.getUri() + "/echo?name=" + name;
			String response = restTemplate.getForObject(targetUrl, String.class);

			return "client:" + response;
		}
	}
}