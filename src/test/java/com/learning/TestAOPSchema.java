package com.learning;

import com.kelly.aop.AspectBiz;
import com.kelly.aop.Fit;
import org.junit.Test;

public class TestAOPSchema extends UnitTestBase {

	public TestAOPSchema() {
		super("classpath:spring-aop-schema.xml");
	}

	@Test
	public void testBiz() {
		AspectBiz biz = super.getBean("aspectBiz");
		biz.biz();
	}

	@Test
	public void testInit() {
		AspectBiz biz = super.getBean("aspectBiz");
		biz.init("Heaven MS", 3);
	}

	@Test
	public void testFit() {
		Fit fit = super.getBean("aspectBiz");
		fit.filter();
	}
}
