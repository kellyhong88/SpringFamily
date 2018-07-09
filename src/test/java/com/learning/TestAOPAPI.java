package com.learning;

import com.kelly.aopAPI.BizLogic;
import org.junit.Test;

public class TestAOPAPI extends UnitTestBase {

	public TestAOPAPI() {
		super("classpath:spring-aop-api.xml");
	}

	@Test
	public void TestBizLogic() {
		BizLogic logic = super.getBean("bizLogic");
		logic.save();
	}

	@Test
	public void TestBizLogic2() {
		BizLogic logic = super.getBean("bizLogic2");
		logic.save();
	}
}
