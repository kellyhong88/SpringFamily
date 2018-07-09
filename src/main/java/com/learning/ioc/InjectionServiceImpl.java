package com.learning.ioc;

public class InjectionServiceImpl implements InjectionService {

	private InjectionDAO injectionDAO;

	// setter injection
	public void setInjectionDAO(InjectionDAO injectionDAO) {
		this.injectionDAO = injectionDAO;
	}

	public void save(String arg) {
		System.out.println("Service receive: " + arg);
		arg = arg + ":" + this.hashCode();

		injectionDAO.save(arg);
	}

	// public InjectionServiceImpl() {
	// }

	// constructor injection
	// public InjectionServiceImpl(InjectionDAO injectionDAO) {
	// this.injectionDAO = injectionDAO;
	// }

}
