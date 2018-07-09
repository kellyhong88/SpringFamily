package com.learning.aop;

public class AspectBiz {

	public void biz() {
		System.out.println("AspectBiz biz");
		throw new RuntimeException();
	}

	public void init(String name, int times) {
		System.out.println("AspectBiz: " + name + ", " + times);
	}
}
