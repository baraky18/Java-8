package unit1example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1SecondSolutionJava7 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carrol", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Brante", 45),
				new Person("Matthew", "Arnold", 39));
		
		//Step1: sort the list by last name
		Collections.sort(people, new Comparator<Person>(){

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getLastName().compareTo(p2.getLastName());
			}
		});
		
		//Step 2: create a method that prints all elements in the list
		System.out.println("Printing all people");
		printPeopleConditionally(people, new Condition(){
			@Override
			public boolean test(Person person) {
				return true;
			}
		});
		
		//step 3: create a method that prints all people that have last name that beginning with C
		System.out.println("Printing all people with last name starts with C");
		printPeopleConditionally(people, new Condition(){
			@Override
			public boolean test(Person person) {
				if(person.getLastName().startsWith("C")){
					return true;
				}
				return false;
			}
		});
	}

	public interface Condition {
		public boolean test(Person person);
	}
	
	private static void printPeopleConditionally(List<Person> people, Condition condition) {
		for (Person person : people) {
			if(condition.test(person)){
				System.out.println(person);
			}
		}
	}
}
