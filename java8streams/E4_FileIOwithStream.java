package com.java8streams;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E4_FileIOwithStream {
	
	static void streamToFile() {
	    String[] words = {
	      "hello", 
	      "refer",
	      "world",
	      "level"
	    };
	    System.out.println(new File("test.txt").toURI());
	    try
	    {PrintWriter pw = new PrintWriter(
	      Files.newBufferedWriter(Paths.get(new File("test.txt").toURI())));
	        Stream.of(words).forEach(pw::println);
	        pw.close();
	    }  catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	static void streamFromFile() throws IOException {
		   List<String> data = 
				   Files.lines(Paths.get(new File("test.txt").toURI()))
//				   .map(null)
//				   .peek()
//				   .filter(null)
	      .collect(Collectors.toList());
		   data.forEach(a->System.out.println(a));
	}
	
	public static void main(String arg[]) {
		try {
		streamToFile();
			streamFromFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}