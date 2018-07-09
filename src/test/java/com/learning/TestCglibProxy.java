package com.learning;

import com.kelly.cglibProxy.CglibProxy;
import com.kelly.cglibProxy.Train;
import org.junit.Test;

public class TestCglibProxy {

	@Test
	public void testCglib() {
		CglibProxy proxy = new CglibProxy();

		// 获取代理类（目标类子类）的对象
		Train trainProxy = (Train) proxy.getProxy(Train.class);
		trainProxy.move("D174");
		trainProxy.whistle("D174");
	}

}
