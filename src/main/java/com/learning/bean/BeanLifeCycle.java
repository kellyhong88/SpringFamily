package com.learning.bean;

public class BeanLifeCycle {

	public void init() {
		System.out.println("BeanLifeCycle init");
	}
	
	public void destroy() {
		System.out.println("BeanLifeCycle destroy");
	}
}
