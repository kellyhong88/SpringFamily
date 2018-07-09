package com.learning;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.kelly.jdkProxy.LogHandler;
import com.kelly.jdkProxy.TimeHandler;
import com.kelly.jdkProxy.Transable;
import org.junit.Test;

public class TestJDKProxy extends UnitTestBase {

	public TestJDKProxy() {
		super("classpath:spring-jdk-proxy.xml");
	}

	@Test
	public void testJDKProxy1() {
		// service get arg from httpRequest or Database
		String beanId = "car";
		Transable trans = super.getBean(beanId);
		Class<?> carClazz = trans.getClass();

		InvocationHandler timeHandler = new TimeHandler(trans);

		/**
		 * loader: 类加载器; interfaces： 被代理类的实现接口; handler： 事务处理器
		 * 
		 * return: 动态代理类的一个实例
		 */
		Transable proxy = (Transable) Proxy.newProxyInstance(carClazz.getClassLoader(), carClazz.getInterfaces(),
				timeHandler);
		proxy.move(carClazz.getSimpleName());
	}

	@Test
	public void testJDKProxy2() {
		// service get args from httpRequest or database
		String beanId = "plane";
		Transable trans = super.getBean(beanId);

		InvocationHandler timeHandler = new TimeHandler(trans);
		Transable proxy1 = (Transable) Proxy.newProxyInstance(trans.getClass().getClassLoader(),
				trans.getClass().getInterfaces(), timeHandler);

		InvocationHandler logHandler = new LogHandler(proxy1);
		Transable proxy2 = (Transable) Proxy.newProxyInstance(proxy1.getClass().getClassLoader(),
				proxy1.getClass().getInterfaces(), logHandler);

		proxy2.move(trans.getClass().getSimpleName());
	}

}
