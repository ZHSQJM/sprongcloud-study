package com.ribbon;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;

/**
 * 自定义的ribbon的LB的策略  不能放在@componseScan的包下  所以只能放在启动类的外面
 * @author Iron man
 *
 */
public class MySelfRule {
	

	
	@Bean
	public IRule myRule(){
		
		//达到的目的，用我们中心选择的随机算法替代默认的轮询
		//return new RandomRule();
		
		//当服务集群存在的时候 ，就是轮询，但是当一个服务挂了的时候，就是自动去寻找好的服务
		//return new RetryRule();
		
		//自定义的LB的策略
		return new RandomRule_ZHS();
	}

}
