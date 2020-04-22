package unit3example;

import java.util.function.Consumer;

import unit1example.Person;

public class MethodReference {

	public static void main(String[] args){
		
		/*
		 * since I can pass to a Thread a Runnable implementation, Runnable acts like a functional Interface (since
		 * it has one method - run()), so I can pass to the thread a lambda expression
		 */
		Thread t1 = new Thread(() -> printMessage());
		t1.run();
		
		/*
		 * since run() is a non-arguments method that calls a static method that has no arguments also,
		 * there's a different syntax which is <name of the class>::<name of method> 
		 */
		Thread t2 = new Thread(MethodReference::printMessage);
		t2.run();
		
		
		MethodReference methodReference = new MethodReference();
		JustAnObject justAnObject = methodReference.new JustAnObject();
		justAnObject.exampleMethod();
	}
	
	public class JustAnObject{
		public void justAMethod(Person p){
			System.out.println(p);
		}
		
		public void exampleMethod(){
			/*
			 * this specific lambda takes 1 argument and sends it to another argument 
			 * using the OOB function of Consumer functional interface
			 */
			performSomething((p) -> justAMethod(p));
			
			/*
			 * so if it's a non-static method that gets an argument and sends that argument in another method in the lambda,
			 * there's another syntax which is <name of Object>::<name of method>
			 */
			performSomething(this::justAMethod);
			
		}
	}
	
	public static void performSomething(Consumer<Person> consumer){
		Person p = new Person("Michael", "Jackson", 37);
		consumer.accept(p);
	}
	
	public static void printMessage(){
		System.out.println("Hello");
	}
}
