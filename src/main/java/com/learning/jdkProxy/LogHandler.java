package com.learning.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

	public LogHandler(Object target) {
		super();
		this.target = target;
	}

	private Object target;

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Log start");

		method.invoke(target, args);

		System.out.println("Log end");

		return null;
	}

}
