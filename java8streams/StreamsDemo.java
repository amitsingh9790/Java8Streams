package com.java8streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee{
	int id;
	String name;
	double salary;
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public void salaryIncrement(double d) {
		this.salary+=d;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}
class Employee2{
	String name;
	String location;
	int salary;
	public Employee2(String name, String location, int salary) {
		super();
		this.name = name;
		this.location = location;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee2 [name=" + name + ", location=" + location + ", salary=" + salary + "]";
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
public class StreamsDemo {
	private static Employee[] arrayOfEmps = {
			new Employee(1,"Midun",70000),
			null,
			new Employee(1,"Vinay",56000),
			new Employee(3,"Amit",80000)
	};
	private static void example1(){
		Stream.of(arrayOfEmps).forEach(e->e.salaryIncrement(5000));
		Stream.of(arrayOfEmps).forEach(e -> System.out.println(e.salary));
	}
	private static void example2() {
		List<Employee> empList = Arrays.asList(arrayOfEmps);
		empList.stream().forEach(e->e.salaryIncrement(10));
		
		Stream<Employee> s = empList.stream();
		s.forEach(e->e.salaryIncrement(10.5));
		empList.stream().forEach(e->System.out.println(e.salary));
		
	}
	private static void example3() {
		Stream.of(arrayOfEmps).filter(e->e!=null).filter(e->e.salary>70000).forEach(n->System.out.println(n.salary));
	}
	private static void example4() {
		Stream.of(arrayOfEmps).filter(e->e!=null).filter(n->n.id>1).forEach(n->System.out.println(n));
		List<Employee> emp = Stream.of(arrayOfEmps).toList();  //Store in List
		emp.forEach(e->System.out.println(e));
		List<Employee> emp2 = Stream.of(arrayOfEmps).collect(Collectors.toList()); //Store in List
		emp.forEach(e->System.out.println(e));
	}
	static void findFirstExample() {
		Integer[] marks = {5,3,6,null,37,33,null,1,3};
		
		Integer mark = Stream.of(marks).filter(e->e != null)
					.filter(e->  e>20)
					.sorted().findFirst().orElse(100);
		System.out.println(mark);
	}
	
	static void toArrayExample() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Elon Musk");
		names.add("Bill Gates");
		names.add("MarkZuckerberg");
		String[] nameArr = names.stream().toArray(String[]::new);
		for(String name:nameArr) {
			System.out.println(name);
		}
		
	}
	static void skip_limit() {
		Stream<Integer> infiniteStream = Stream.iterate(2, i -> i* 2);
		List<Integer> collect = infiniteStream
				.skip(2)
				.limit(5)
				.collect(Collectors.toList());
		collect.forEach(System.out::println);
	}
	static void whenCollectByJoining_thenGetJoinedString() {
		ArrayList<String> names = new ArrayList<String> ();
		names.add("Elon Musk");
		names.add("Bill Gates");
		names.add("MarkZuckerberg");
		String empNames = names.stream()
				.collect(Collectors.joining("|"));
		System.out.println(empNames);
		
		
	}
	static void whenCollectBySet_thenGetSet() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Elon Musk");
		names.add("Bill Gates");
		names.add("MarkZuckerberg");
		names.add("Bill Gates");
		Set<String> empName = names.stream().collect(Collectors.toSet());
		empName.stream().forEach(System.out::println);
	}
	static void whenToVectorCollection_thenGetVector() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Elon Musk");names.add("Bill Gates");names.add("MarkZuckerberg");
		Vector<String> nameList = names.stream().collect(Collectors.toCollection(Vector::new));
		nameList.forEach(System.out::println);
	}
	static void whenSteamPartion_thenGetMap() {
		List<Integer> intList = Arrays.asList(1,4,2,5,6,75,3,2,11);
		Map<Boolean, List<Integer>> isEven = intList.stream()
				.collect(Collectors.partitioningBy(n->n%2==0));
		List<Integer> evenList = isEven.get(true);
		List<Integer> oddList = isEven.get(false);
		evenList.forEach(System.out::println);
		System.out.println("================");
		oddList.forEach(System.out::println);
		
	}
	static void whenSteamPartition_thenGetMap() {
		List<Integer> salary = Arrays.asList(1,4,2,5,6,75,3,2,11);
		DoubleSummaryStatistics stats = salary.stream()
				.collect(Collectors.summarizingDouble(n->n+n*10/100));
		System.out.println(stats.getAverage());
		System.out.println(stats.getCount());
	}
	static void whenStreamPartition_thenGetMap() {
		List<Integer> intList = Arrays.asList(2,3,5,8,9);
		Map<Boolean, List<Integer>> isEven = intList.stream()
				.collect(Collectors.partitioningBy(i->i%2==0));
		List<Integer> evenList = isEven.get(true);
		List<Integer> oddList = isEven.get(false);
		
//		evenList.forEach(e->System.out.print(e));
//		oddList.forEach(e->System.out.print(e));
		isEven.forEach((k,v) -> v.forEach(data->System.out.print(k+" "+data)));
	}
	static void whenStreamGroupingBy_thenGetMap() {
		ArrayList<Employee2> elist = new ArrayList<Employee2>();
		elist.add(new Employee2("Amit","Delhi",20000));
		elist.add(new Employee2("Sumit", "GGN", 70000));
		elist.add(new Employee2("Raj","Bangluru",50000));
		elist.add(new Employee2("Vinay", "Delhi", 30000));
		elist.add(new Employee2("Vishal","Bangluru",60000));
		elist.add(new Employee2("Vikas", "Delhi", 50000));
		elist.add(new Employee2("Shobit", "GGN", 40000));
		Map<String, List<Employee2>> groupByLoc = elist.stream()
				.collect(Collectors.groupingBy(e->e.getLocation()));
		groupByLoc.forEach((k,v) -> v.forEach(data->System.out.println(k+": "+data)));
	}
	public static void main(String[] args) {
//		example1();
//		example2();
//		example3();
//		example4();
//		findFirstExample();
//		skip_limit();
//		whenCollectByJoining_thenGetJoinedString();
//		whenCollectBySet_thenGetSet();
//		whenToVectorCollection_thenGetVector();
//		whenSteamPartion_thenGetMap();
//		whenSteamPartition_thenGetMap();
//		whenStreamPartition_thenGetMap();
		whenStreamGroupingBy_thenGetMap();
	}

}
