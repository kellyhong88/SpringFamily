package com.learning;

import com.kelly.ioc.InjectionService;
import com.kelly.ioc.OneInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestIoC extends UnitTestBase{

	public TestIoC() {
		super("classpath:spring-ioc.xml");
	}
	
	@Test
	public void testInterface() {
		OneInterface oif = super.getBean("oneInterface");
		System.out.println(oif.wholeWord("World"));
	}

	@Test
	public void testSetterInj() {
		InjectionService service = super.getBean("injectionService");
		service.save("You are an idiot!");
	}
	
	@Test
	public void testConsInj() {
		InjectionService service = super.getBean("injectionService");
		service.save("Are you a bitch?");
	}
}
