package com.learning.jdkProxy;

import java.util.Random;

public class Car implements Transable {

	public void move(String category) {
		try {
			System.out.println(category + "'s moving...");
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void say() {
		try {
			System.out.println("Car's saying...");
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
