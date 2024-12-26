//package com.java8streams;
//
//import java.io.File;
//import java.io.PrintWriter;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//public class write {
//	public static void main(String []args) {
//		String[] words = {
//				"hello",
//				"refer",
//				"world",
//				"level"
//			};
//		System.out.println(new File("abc.txt").toURI());
//		try {
//			PrintWriter pw = new PrintWriter(
//					Files.newBufferedWriter(Paths.get("abc.txt").toUri(), null)
//					)
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally{
//			
//		}
//	}
//}
