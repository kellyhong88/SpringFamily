package com.learning.ioc;

public class InjectionDAOImpl implements InjectionDAO {

	public void save(String arg) {
		System.out.println("StudentDAO Save: " + arg);
	}
}
