package com.learning.jdkProxyDeep;

import java.lang.reflect.Method;

public class TimeHandler implements InvocationHdl {

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	private Object target;

	@Override
	public void invoke(Object proxy, Method method) {

		long startTime = System.currentTimeMillis();
		System.out.println("Start at time: " + startTime);

		try {
			method.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}

		long endTime = System.currentTimeMillis();
		System.out.println("Stop at time " + endTime);
		System.out.println("Cost time: " + (endTime - startTime) + "ms");
	}

}
