package com.learning;

import com.kelly.aware.AppContext;
import com.kelly.aware.BeanName;
import org.junit.Test;

public class TestAware extends UnitTestBase {

	public TestAware() {
		super("classpath:spring-aware.xml");
	}

	@Test
	public void testAppContext() {
		System.out.println(
				"JUnit getBean:" + super.getBean("appContext") + ", " + super.getBean("appContext").hashCode());
		((AppContext) super.getBean("appContext")).app();
	}

	@Test
	public void testBeanName() {
		((BeanName) super.getBean("beanNameIsIt")).nm();
	}

}
