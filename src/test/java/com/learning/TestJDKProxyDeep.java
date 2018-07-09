package com.learning;

import com.kelly.jdkProxyDeep.InvocationHdl;
import com.kelly.jdkProxyDeep.JdkProxy;
import com.kelly.jdkProxyDeep.TimeHandler;
import org.junit.Test;

import com.kelly.staticProxy.Movable;

public class TestJDKProxyDeep {

	@Test
	public void testDeep() throws Exception {
		com.kelly.staticProxy.Car car = new com.kelly.staticProxy.Car();
		InvocationHdl handler = new TimeHandler(car);

		Movable proxy = (Movable) JdkProxy.newProxyInstance(Movable.class, handler);
		proxy.move();

	}

}
