package com.zhs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.ribbon.MySelfRule;

@SpringBootApplication
@EnableEurekaClient

//在启动该微服务的时候就能加载我们的自定义Ribbon配置，从而使配置失效 这个配置类不能放在启动类的子包或者同一级别的包
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)
@EnableFeignClients
public class DeptConsumer_Feign {

	
	public static void main(String args[]){
		SpringApplication.run(DeptConsumer_Feign.class, args);
	}
}
