package com.learning;

import com.kelly.bean.BeanScope;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestBean extends UnitTestBase {

	public TestBean() {
		super("classpath:spring-bean.xml");
	}

	@Test
	public void testBeanScope() {
		BeanScope beanScope = super.getBean("beanScope");
		beanScope.say();

		BeanScope beanScope2 = super.getBean("beanScope");
		beanScope2.say();
	}

	@Test
	public void testBeforeAfter() {
		BeanScope beanScope = super.getBean("beanScope");
		beanScope.say();
	}

	@Test
	public void testBeanLifeCycle() {
		// do nothing
	}

}
