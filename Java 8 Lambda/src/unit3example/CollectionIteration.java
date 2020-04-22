package unit3example;

import java.util.Arrays;
import java.util.List;

import unit1example.Person;

public class CollectionIteration {

	public static void main(String[] args){
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carrol", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Brante", 45),
				new Person("Matthew", "Arnold", 39));
		
		System.out.println("Using for loop");
		for (int i=0; i<people.size(); i++) {
			System.out.println(people.get(i));
		}
		
		System.out.println("Using for each loop");
		for (Person person : people) {
			System.out.println(person);
		}
		
		/*
		 * in Java 8 there's a new way to loop over an collection and it's using the foreach method.
		 * this method basically get a lambda expression of type functional interface Consumer
		 */
		System.out.println("Using lambda for each loop");
		people.forEach(p -> System.out.println(p));
		
		/*
		 * we can use another syntax that was presented in MethodReference class
		 */
		System.out.println("Using lambda for each loop - other syntax");
		people.forEach(System.out::println);
	}
}
