package com.zhs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_dashboard {

	

	public static void main(String args[]){
		SpringApplication.run(DeptConsumer_dashboard.class, args);
	}
}
