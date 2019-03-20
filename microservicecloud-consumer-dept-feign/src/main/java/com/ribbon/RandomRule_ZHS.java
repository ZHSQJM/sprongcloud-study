package com.ribbon;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class RandomRule_ZHS extends AbstractLoadBalancerRule{
	
	//total=0 当total == 5以后 我们指针才能往下走
	//index =0 当前对外提供服务的服务器地址
	//total需要重置为0 但是已经待到一个此我们index==1
	//我们5次，但是微服务只有8001，8002，8003三台 ok?
	
	private int total = 0; //中共被调用的次数，目前要求每台调用5此
	
	private int currentIndex = 0; //每次提供服务的机器号
	
	
	public Server choose(ILoadBalancer lb,Object key){
		if(lb == null){
			return null;
		}
		Server server = null;
		
		while(server == null){
			if(Thread.interrupted()){
				return null;
			}
			List<Server> upList = lb.getReachableServers();
			
			List<Server> allList = lb.getAllServers();
			
			int serverCount = allList.size();
			
			if(serverCount == 0){
				return null;
			}
			
			if(total<5){
				server = upList.get(currentIndex);
				total++;
			}else{
				total = 0;
				currentIndex++;
				if(currentIndex >=upList.size()){
					currentIndex = 0;
				}
			}
			
			if(server == null){
				Thread.yield();
				continue;
			}
			if(server.isAlive()){
				return (server);
			}
			
			server = null;
			Thread.yield();
		}
		return server;
		
	}

	@Override
	public Server choose(Object arg0) {
		// TODO Auto-generated method stub
		return choose(getLoadBalancer(),arg0);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
		// TODO Auto-generated method stub
		
	}

}
