import java.util.Arrays;
import java.util.List;

public class FilterExample {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("John", "Martin", "Sam", "Oz");
		
		System.out.println("print all without Sam (old way):");
		for (String name : names) {
			if(!"Sam".equalsIgnoreCase(name)){
				System.out.println(name);
			}
		}
		
		System.out.println("print all without Sam (streams way):");
		names.stream()
			.filter(t -> !t.equalsIgnoreCase("Sam"))
			.forEach(System.out::println);//forEach is a terminal operation - meaning you cannot add another operation after it 
										  //since it doesn't return anything
	}

}
