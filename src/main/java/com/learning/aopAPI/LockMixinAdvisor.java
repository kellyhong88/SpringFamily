package com.learning.aopAPI;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class LockMixinAdvisor extends DefaultIntroductionAdvisor {

	private static final long serialVersionUID = 1L;

	public LockMixinAdvisor() {
		super(new LockMixin(), Lockable.class);
	}
}
