package com.learning.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	private Object target;

	/**
	 * object: 被代理对象; method: 被代理对象的方法; args: 被代理对象的方法的参数
	 * 
	 * return: 被代理对象的方法的返回值
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long startTime = System.currentTimeMillis();
		System.out.println("Start moving at: " + startTime);

		method.invoke(target, args);

		long endTime = System.currentTimeMillis();
		System.out.println("Stop moving at: " + endTime);
		System.out.println("Cost time of moving: " + (endTime - startTime) + "ms");

		return null;
	}
}
