package com.learning.jdkProxyDeep;
import java.lang.reflect.Method;

public class $Proxy implements com.learning.staticProxy.Movable {
	public $Proxy(InvocationHdl handler) {
		super();
		this.handler = handler;
	}
	private InvocationHdl handler;
	public void say () {
        try{
            Method method = com.learning.staticProxy.Movable.class.getMethod("say");
            handler.invoke(this, method);
        }catch(Exception e){}
    }
	public void move () {
        try{
            Method method = com.learning.staticProxy.Movable.class.getMethod("move");
            handler.invoke(this, method);
        }catch(Exception e){}
    }

}