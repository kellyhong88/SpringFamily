package com.learning.aopAPI;

public class BizLogicImpl implements BizLogic {

	public String save() {
		System.out.println("BizLogicImpl: logic save");
		return "logic save";
		// throw new RuntimeException();
	}
}
