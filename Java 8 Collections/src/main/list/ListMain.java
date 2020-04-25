package main.list;

import java.util.ArrayList;
import java.util.List;
import pojo.Employee;

public class ListMain {

	public static void main(String[] args) {
		
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("Raj", 90000.0, "HR"));
		empList.add(new Employee("Frank", 80000.0, "Finance"));
		empList.add(new Employee("Kishan", 30000.0, "HR"));
		empList.add(new Employee("Sean", 90000.0, "Finance"));
		empList.add(new Employee("Rajesh", 90000.0, "HR"));
		
		System.out.println("All employees:");
		
		//new forEach method that gets Consumer functional interface
		empList.forEach(s -> System.out.println(s));
		
		//new sort method that gets Comparator functional interface
		empList.sort((emp1, emp2) -> emp1.getSalary() > emp2.getSalary() ? 1 : -1);
		
		System.out.println("Employees sorted by salary:");
		empList.forEach(s -> System.out.println(s));
		
		//new replaceAll method that gets UnaryOperator functional interface
		empList.replaceAll(emp -> {
			if(emp.getSalary() > 60000.0){
				return emp;
			}
			else{
				emp.setSalary(emp.getSalary()+emp.getSalary()*0.1);
			}
			return emp;
		});
		
		System.out.println("Employees after raise in salary:");
		empList.forEach(s -> System.out.println(s));
		
		System.out.println("Employees from HR:");
		
		//new removeIf method that gets Predicate functional interface
		empList.removeIf(s -> s.getDeptName().equalsIgnoreCase("HR"));
		empList.forEach(s -> System.out.println(s));
		
		
	}

}
