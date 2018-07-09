package com.learning.ioc;

public class Main {

	public static void main(String[] args){
		
		OneInterface oif = new OneInterfaceImpl();
		
		System.out.println(oif.wholeWord("world"));
	}
	
}
