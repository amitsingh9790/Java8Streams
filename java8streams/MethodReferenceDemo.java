package com.java8streams;
import java.util.ArrayList;
class Obj{
	int a;
	int b;
	public Obj(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
}
public class MethodReferenceDemo {
	static void sum(int x) {
		System.out.println("hello"+x);
	}

	static void sum(Obj o) {
		System.out.println("Hello "+o.a+" "+o.b);
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		
		arr.add(5);
		arr.add(4);
		arr.add(20);
		
		for(Integer i:arr) {
			System.out.println(i);
		}
		for(Integer i:arr) {
			MethodReferenceDemo.sum(i);
		}
		
		//Example1
		arr.forEach(n->System.out.println(n));
		arr.forEach(System.out::println); //MethodReferencing
		
		//Example2
		arr.forEach(n->MethodReferenceDemo.sum(n));
		arr.forEach(MethodReferenceDemo::sum); //MehodReferencing
		System.out.println("+++++++++++++++++++++++");
		
		ArrayList<Obj> al = new ArrayList<>();
		al.add(new Obj(1,2));
		al.add(new Obj(3,2));
		al.add(new Obj(9,2));
		
		al.forEach(MethodReferenceDemo::sum);
	}

}
