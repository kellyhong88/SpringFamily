package com.learning.advisor;

import org.springframework.dao.PessimisticLockingFailureException;

public class InvokeService {

	public void invoke() {
		System.out.println("Invoke...");
	}

	public void invokeException() {
		throw new PessimisticLockingFailureException("");
	}

}
