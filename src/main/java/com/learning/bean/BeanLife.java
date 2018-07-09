package com.learning.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLife implements InitializingBean, DisposableBean{

	public void afterPropertiesSet() throws Exception {
		System.out.println("BeanLife afterPropertiesSet");
	}
	
	public void destroy() throws Exception {
		System.out.println("BeanLife destroy");
	}

}
