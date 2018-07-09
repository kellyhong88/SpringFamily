package com.learning;

import com.kelly.advisor.InvokeService;
import org.junit.Test;

public class TestAOPAdvisor extends UnitTestBase {

	public TestAOPAdvisor() {
		super("classpath:spring-aop-advisor.xml");
	}

	@Test
	public void testAdvisor() {
		InvokeService service = super.getBean("invokeService");
		service.invoke();

		System.out.println();
		service.invokeException();
	}
}
