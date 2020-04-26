import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapperAndCollectExample {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("John", "Martin", "Sam", "Oz");
		
		System.out.println("print all without Sam (old way):");
		for (String name : names) {
			if(!"Sam".equalsIgnoreCase(name)){
				User user = new MapperAndCollectExample().new User(name);
				System.out.println(user);
			}
		}
		
		System.out.println("print all without Sam (streams way):");
		names.stream()
			.filter(name -> !name.equalsIgnoreCase("Sam"))
			.map(name -> new MapperAndCollectExample().new User(name))//maps the name to the user name
			.forEach(System.out::println);//forEach is a terminal operation - meaning you cannot add another operation after it 
										  //since it doesn't return anything

		System.out.println("collect all users without Sam (streams way):");
		List<User> usersWithoutSam = names.stream()
			.filter(name -> !name.equalsIgnoreCase("Sam"))
			.map(name -> new MapperAndCollectExample().new User(name))//maps the name to the user name
			.collect(Collectors.toList());
		System.out.println(usersWithoutSam);//collect is a terminal operation
		
		int ageSum = usersWithoutSam.stream()
			.mapToInt(user -> user.getAge())
			.sum();
		
		System.out.println("the sum of ages of users without Sam is: " + ageSum);
	}

	
	public class User{
		private String name;
		private int age = 30;
		
		public User(String name) {
			super();
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
		@Override
		public String toString(){
			return "name: " + name + " age: " + age;
		}
	}
} 
