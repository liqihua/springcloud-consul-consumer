package com.liqihua.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class Run {

	public static void main(String[] args) {
		SpringApplication.run(Run.class, args);
	}


	//必须启用ribbon的LoadBalanced，否则无法解析consul的服务名，他内部有负载均衡器的操作，比如有添加服务器操作、选择服务器操作、获取所有的服务器列表、获取可用的服务器列表等等
	//不需要在pom引入ribbon的依赖spring-cloud-starter-ribbon，因为spring-cloud-starter-consul-discovery包含了ribbon依赖
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}


}
