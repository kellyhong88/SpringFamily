package com.learning;

import com.kelly.jdkObserver.WeatherObserver;
import com.kelly.jdkObserver.WeatherSubject;
import org.junit.Test;

public class TestJDKObserver {

	@Test
	public void testWeather() {
		// 1.创建目标/被观察者
		WeatherSubject subject = new WeatherSubject();

		// 2.创建观察者
		WeatherObserver observer1 = new WeatherObserver("Kerry");
		WeatherObserver observer2 = new WeatherObserver("Sherry");

		// 3.注册观察者
		subject.addObserver(observer1);
		subject.addObserver(observer2);

		// 4.目标更新 （自动通知所有观察者）
		subject.setContent("A sunny day");
	}

}
