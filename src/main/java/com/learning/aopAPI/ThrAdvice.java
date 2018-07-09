package com.learning.aopAPI;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class ThrAdvice implements ThrowsAdvice {

	public void afterThrowing(Exception e) throws Throwable {
		System.out.println("AfterThrowingAdvice");
	}

	public void afterThrowing(Method method, Object[] args, Object target, Exception e) throws Throwable {
		System.out.println(
				"AfterThrowingAdvice: method is " + method.getName() + ", target is " + target.getClass().getName());
	}
}
