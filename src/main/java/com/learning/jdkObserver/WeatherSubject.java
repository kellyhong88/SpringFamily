/**
 * 
 */
package com.learning.jdkObserver;

import java.util.Observable;

/**
 * Observable是jdk提供的观察者模式中目标对象的基类
 */
public class WeatherSubject extends Observable {

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;

		// 注意： 在使用jdk提供的观察者模式时，必须先setChanged!
		this.setChanged();

		// 使用jdk中通知观察者的方法 ，即父类Observable中的方法 （拉模型）
		this.notifyObservers();

		// 使用jdk中通知观察者的方法 ，即父类Observable中的方法 （推模型）
		// this.notifyObservers(content);
	}

}
