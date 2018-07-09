package com.learning;

import com.kelly.autowiring.AutoWiringService;
import org.junit.Test;

public class TestAutowiring extends UnitTestBase {

	public TestAutowiring() {
		super("classpath:spring-autowiring.xml");
	}

	@Test
	public void testSay() {
		AutoWiringService service = super.getBean("autoWiringService");
		service.say("Leave MS and save yourself.");
	}
}
