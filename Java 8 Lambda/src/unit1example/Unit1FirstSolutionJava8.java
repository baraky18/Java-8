package unit1example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Unit1FirstSolutionJava8 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carrol", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Brante", 45),
				new Person("Matthew", "Arnold", 39));
		
		//Step1: sort the list by last name
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		//Step 2: create a method that prints all elements in the list
		System.out.println("Printing all people");
		
		printPeopleConditionally(people, person -> true);
		
		//step 3: create a method that prints all people that have last name that beginning with C
		System.out.println("Printing all people with last name starts with C");
		printPeopleConditionally(people, person -> person.getLastName().startsWith("C"));
	}

	public interface Condition {
		public boolean test(Person person);
	}
	
	/*
	 * in java 8, there are multiple templates of functional interface that are OOB that we can use.
	 * for example Predicate has a method test that gets a Generic and returns a boolean 
	 * (same as Condition interface that we created in java 7 solution) - so we can use it
	 * it's recommended that I will go to java.util.function to check out all of the functional interfaces there
	 */
	private static void printPeopleConditionally(List<Person> people, Predicate<Person> predicate) {
		for (Person person : people) {
			if(predicate.test(person)){
				System.out.println(person);
			}
		}
	}
}
