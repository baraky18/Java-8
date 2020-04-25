package main.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapMergeMethodMain {

	public static void main(String[] args) {
		
		Map<String,Integer> prices = new LinkedHashMap<String,Integer>();
		
		//new merge method that gets BiFunction functional interface
		prices.merge("fruits", 3, Integer::sum);
		prices.merge("fruits", 5, Integer::sum);
		System.out.println("prices map: " + prices);
		
		//this map will not hold null values so it will be empty
		prices.merge("fruits", 7, (oldValue, newValue) -> {
			System.out.println("old value is: " + oldValue + ", new value is: " + newValue);
			return null;
		});
		System.out.println("prices map: " + prices);
		
		prices.put("Bread", null);
		System.out.println("prices map: " + prices);
		
		//merge method will know how to sum 42 and null
		prices.merge("Bread", 42, Integer::sum);
		System.out.println("prices map: " + prices);
	}

}
