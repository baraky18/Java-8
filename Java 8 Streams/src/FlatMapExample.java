import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FlatMapExample {

	public static void main(String[] args) {
		FlatMapExample flatMapExample = new FlatMapExample();
		List<User> users = Arrays.asList(
				flatMapExample.new User("John", 20, Arrays.asList("1", "2")),
				flatMapExample.new User("Martin", 40, Arrays.asList("3", "4", "5")),
				flatMapExample.new User("Sam", 60, Arrays.asList("6")),
				flatMapExample.new User("Oz", 70, Arrays.asList("7", "8")));
		
		Optional<String> stringOptional = users.stream()
			.map(user -> user.getPhoneNumber().stream())//maps the user to stream of phone numbers (basically it's a stream in a stream)
				.flatMap(stream -> stream.filter(phoneNumber -> phoneNumber.equalsIgnoreCase("5")))//takes the stream and filter out a stream that containd phone number of 5
				.findAny();//if it finds any phone number that's 5, it stops
		
		stringOptional.ifPresent(System.out::println);//Optional objects wraps the object in a null safe object
	}

	
	public class User{
		private String name;
		private int age;
		private List<String> phoneNumber;
		
		public User(String name, int age, List<String> phoneNumers) {
			super();
			this.name = name;
			this.age = age;
			this.phoneNumber = phoneNumers;
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
		public List<String> getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(List<String> phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		@Override
		public String toString(){
			return "name: " + name + " age: " + age;
		}
	}
}
