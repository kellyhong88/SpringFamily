package com.learning.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Aspect {

	public void before() {
		System.out.println("Aspect before");
	}

	public void afterReturning() {
		System.out.println("Aspect afterReturning");
	}

	public void afterThrowing() {
		System.out.println("Aspect afterThrowing");
	}

	public void after() {
		System.out.println("Aspect after finally");
	}

	public Object around(ProceedingJoinPoint point) throws Throwable {
		Object object;

		System.out.println("Aspect around before proceeding");
		object = point.proceed();
		System.out.println("Aspect around after proceeding");

		return object;
	}

	public Object aroundInit(ProceedingJoinPoint point, String name, int times) throws Throwable {
		System.out.println("args sent to aroundInit: " + name + ", " + times);

		Object object;

		System.out.println("Aspect aroundInit before proceeding");
		object = point.proceed();
		System.out.println("Aspect aroundInit after proceeding");

		return object;
	}
}
