package com.learning.jdkProxyDeep;

import java.lang.reflect.Method;

public interface InvocationHdl {

	void invoke(Object object, Method method);
}
