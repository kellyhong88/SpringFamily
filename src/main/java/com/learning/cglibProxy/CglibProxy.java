package com.learning.cglibProxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();

	/**
	 * 获取代理类（目标类子类）的对象
	 */
	public Object getProxy(Class<?> clazz) {

		// 设置目标类（父类）
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);

		// 创建代理类（子类）的实例
		Object proxy = enhancer.create();
		return proxy;
	}

	/**
	 * 拦截目标类所有方法的调用
	 * 
	 * target： 目标类的实例; method： 目标方法的反射对象; args: 目标方法的参数; proxy: 代理类的实例
	 * 
	 * cglib采用继承的方式实现代理，因此cglib中代理类是目标类的子类
	 * 
	 */
	public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {

		System.out.println("Cglib proxy start");

		// 代理类调用父类的方法
		proxy.invokeSuper(target, args);

		System.out.println("Cglib proxy end\n");

		return null;
	}

}
