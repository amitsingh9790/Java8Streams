package com.java8streams;

import java.util.ArrayList;
import java.util.Arrays;

//Functional Interface
interface Calculator {
	public void sum();
}

public class LambdaDemo {
	public static void main(String[] args) {
		// Anonymous class
		Calculator obj = new Calculator() {
			@Override
			public void sum() {
				System.out.println("add");
			}
		};
		obj.sum();

		// Lambda Expression
		Calculator obj2 = () -> {
			System.out.println("add2");
		};
		obj2.sum();

		Calculator obj3 = () -> System.out.println("add3");
		obj3.sum();
		
	}
}