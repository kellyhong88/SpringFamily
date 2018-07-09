package com.learning.aopAPI;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AftReturningAdvice implements AfterReturningAdvice {

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("AfterReturningAdvice: method is " + method.getName() + ", target is "
				+ target.getClass().getName() + ", returnValue is " + returnValue.toString());
	}

}
