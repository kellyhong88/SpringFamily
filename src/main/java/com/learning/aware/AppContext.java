package com.learning.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AppContext implements ApplicationContextAware, BeanNameAware {

	private ApplicationContext appCon;
	private String nm;

	public void setBeanName(String beanName) {
		this.nm = beanName;
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.appCon = applicationContext;
	}

	public void app() {
		System.out.println("appCon getBean:" + appCon.getBean(nm) + ", " + appCon.getBean(nm).hashCode());
	}

}
