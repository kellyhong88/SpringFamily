package com.learning;

import java.io.IOException;

import com.kelly.resource.Resource2;
import org.junit.Test;

public class TestResource extends UnitTestBase {

	public TestResource() {
		super("classpath:spring-resource.xml");
	}

	@Test
	public void testResource() {
		Resource2 resource2 = super.getBean("resource");
		try {
			resource2.resource();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
