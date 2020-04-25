package pojo;

public class Employee {

	private String name;
	private double salary;
	private String deptName;
	
	public Employee(String name, double salary, String deptName) {
		this.name = name;
		this.salary = salary;
		this.deptName = deptName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@Override
	public String toString(){
		return "Employee [name: " + name + " salary: " + salary + " deptName: " + deptName + "]";
	}
}
