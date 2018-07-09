package com.learning.autowiring;

public class AutoWiringService {

	private AutoWiringDAO autoWiringDAO;

	// default-autowire = constructor
	// public AutoWiringService(AutoWiringDAO autoWiringDAO) {
	// System.out.println("AutoWiringService");
	// this.autoWiringDAO = autoWiringDAO;
	// }

	// default-autowire = byName or byType
	public void setAutoWiringDAO(AutoWiringDAO autoWiringDAO) {
		System.out.println("setAutoWiringDAO");
		this.autoWiringDAO = autoWiringDAO;
	}

	public void say(String word) {
		this.autoWiringDAO.say(word);
	}
}
