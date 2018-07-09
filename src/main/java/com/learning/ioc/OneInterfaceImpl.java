package com.learning.ioc;

public class OneInterfaceImpl implements OneInterface {

	public String wholeWord(String word) {
		return "Whole " + word;
	}

	public void init() {
		System.out.println("Bean default init");
	}
	
	public void destroy() {
		System.out.println("Bean default destroy");
	}
}
