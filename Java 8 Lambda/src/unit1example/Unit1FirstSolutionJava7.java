package unit1example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1FirstSolutionJava7 {

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
		printAll(people);
		
		//step 3: create a method that prints all people that have last name that beginning with C
		System.out.println("Printing all people with last name starts with C");
		printAllPeopleWithLastNameStartWithC(people);
	}

	private static void printAllPeopleWithLastNameStartWithC(List<Person> people) {
		for (Person person : people) {
			if(person.getLastName().startsWith("C")){
				System.out.println(person);
			}
		}
	}

	private static void printAll(List<Person> people) {
		for (Person person : people) {
			System.out.println(person);
		}
	}

}
