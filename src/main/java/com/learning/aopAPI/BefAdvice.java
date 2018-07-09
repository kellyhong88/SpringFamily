package com.learning.aopAPI;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BefAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] arg, Object target) throws Throwable {
		System.out
				.println("BeforeAdvice: method is " + method.getName() + ", target is " + target.getClass().getName());
	}

}
