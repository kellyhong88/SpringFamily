package com.learning.aware;

import org.springframework.beans.factory.BeanNameAware;

public class BeanName implements BeanNameAware {

	private String nm;

	public void setBeanName(String beanName) {
		this.nm = beanName;
	}

	public void nm() {
		System.out.println("nm: " + nm);
	}
}
