package com.zhs.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class ConfigBean {
	
	
	/**
	 * @LoadBanced 是ribbin的客户端的负载均衡
	 * @return
	 */
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	/*
	@Bean
	public IRule myRule(){
		
		//达到的目的，用我们中心选择的随机算法替代默认的轮询
		return new RandomRule();
		
		//当服务集群存在的时候 ，就是轮询，但是当一个服务挂了的时候，就是自动去寻找好的服务
		//return new RetryRule();
	}*/

}
