package main.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapComputeMethodMain {

	public static void main(String[] args) {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(1, "Java");
		map.put(2, "Java");
		
		System.out.println("Map is: " + map);
		
		//new compute method that gets BiFunction functional interface
		map.compute(1, (k,v) -> v.concat(" Script"));
		map.compute(2, (k,v) -> v.concat(" Framework"));
		
		System.out.println("Map is: " + map);
		
		//this will remove the value
		map.compute(1, (k,v) -> null);
		
		System.out.println("Map is: " + map);
		
		//this will do nothing since key 3 isn't found
		map.compute(3, (k,v) -> null);
		
		System.out.println("Map is: " + map);
		
		//this will add a key and value since key 3 isn't found
		map.compute(3, (k,v) -> "Spring Framework");
		
		System.out.println("Map is: " + map);
		
		//new computeIfAbsent method that gets Function functional interface
		map.computeIfAbsent(1, k -> "Compute if absent");
		
		System.out.println("Map is: " + map);
		
		//new computeIfPresent method that gets BiFunction functional interface
		map.computeIfPresent(1, (k,v) -> "Compute if Present");
		
		System.out.println("Map is: " + map);
	}
}
