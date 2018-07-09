package com.learning.advisor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.dao.PessimisticLockingFailureException;

public class ConcurrentOpsExec {

	private static final int DEFAULT_MAX_RETRIES = 2;

	private int maxRetries = DEFAULT_MAX_RETRIES;

	private int order = 1;

	public void setOrder(int order) {
		this.order = order;
	}

	public void setMaxRetries(int maxRetries) {
		this.maxRetries = maxRetries;
	}

	public Object doConcurrentOps(ProceedingJoinPoint point) throws Throwable {
		int numAttempts = 0;
		PessimisticLockingFailureException lockingFailureException;
		do {
			numAttempts++;
			System.out.println("Try time: " + numAttempts);
			try {
				return point.proceed();
			} catch (PessimisticLockingFailureException e) {
				lockingFailureException = e;
			}
		} while (numAttempts < this.maxRetries);
		System.out.println("Try error: " + numAttempts);
		throw lockingFailureException;
	}

}
