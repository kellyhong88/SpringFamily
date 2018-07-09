package com.learning.bean;

public class BeanScope {

	public void say() {
		System.out.println("BeanScope say: " + this.hashCode());
	}
	
	public void init() {
		System.out.println("BeanScope init");
	}
	
	public void destroy() {
		System.out.println("BeanScope destroy");
	}
	
}
