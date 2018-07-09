package com.learning.jdkObserver;

import java.util.Observable;
import java.util.Observer;

/**
 * Observer是jdk提供的观察者模式中订阅者的接口
 */
public class WeatherObserver implements Observer {

	private String observerName;

	private String content;

	public String getContent() {
		return content;
	}

	public String getObserverName() {
		return observerName;
	}

	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

	// 构造函数/构造器
	public WeatherObserver(String name) {
		this.observerName = name;
	}

	/**
	 * observable: 目标对象的引用 --拉模式
	 * 
	 * object: 推送对象的引用 --推模式
	 */
	@Override
	public void update(Observable observable, Object object) {

		// 推模式
		if (object != null) {
			this.content = object.toString();
			System.out
					.println(observerName + " get the info that subject has pushed to him/her: " + this.content + "\n");
		}

		// 拉模式
		else {
			this.content = ((WeatherSubject) observable).getContent();
			System.out.println(observerName + " get the update notification and extract the info: " + this.content
					+ " from the subject on his/her initiative." + "\n");

		}
	}
}
