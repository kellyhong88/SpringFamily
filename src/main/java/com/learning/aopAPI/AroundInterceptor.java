package com.learning.aopAPI;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundInterceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("AroundAdvice: method is " + invocation.getMethod().getName() + ", target is "
				+ invocation.getStaticPart().getClass().getName());
		Object returnValue = invocation.proceed();
		System.out.println("AroundAdvice: returnValue is " + returnValue);
		return returnValue;
	}

}
