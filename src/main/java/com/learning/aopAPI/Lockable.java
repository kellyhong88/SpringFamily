package com.learning.aopAPI;

public interface Lockable {

	void lock();

	void unlock();

	boolean locked();
}
