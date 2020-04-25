package main.map;

import java.util.HashMap;
import java.util.Map;

public class MapReplaceAllMethodMain {

	public static void main(String[] args) {
		Map<Integer, String> empMap = new HashMap<Integer, String>();
		empMap.put(193, "Martin");
		empMap.put(192, "Frank");
		empMap.put(1, "Oz");
		empMap.put(333, "Barak");
		empMap.put(231, "Yosi");
		
		//new getOrDefault method that gets key and value and returns default value in case, key was not found
		String result1 = empMap.getOrDefault(193, "Rocky");
		String result2 = empMap.getOrDefault(555, "Rocky");
		System.out.println("First value returned: " + result1);
		System.out.println("Second value returned: " + result2);
		
		System.out.println("All employees:");
		
		//new forEach method that gets BiConsumer functional interface
		empMap.forEach((k,v) -> System.out.println("key: " + k + " value is: " + v));
		
		//new replaceAll method that gets BiFunction functional interface
		empMap.replaceAll((k,v) -> k+v);
		
		System.out.println("All employees after adding key to value:");
		
		empMap.forEach((k,v) -> System.out.println("key: " + k + " value is: " + v));
		
		System.out.println("All employees after adding employee if absent:");
		
		//new putIfAbsent method that gets key and value
		empMap.putIfAbsent(101, "John");
		
		empMap.forEach((k,v) -> System.out.println("key: " + k + " value is: " + v));
	}
}
