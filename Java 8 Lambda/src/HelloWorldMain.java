
public class HelloWorldMain {

	
	public class Greeter2{
		public void greet(Greeting greeting){
			greeting.perform();
		}
	}
	
	public class Greeter1{
		public void greet(){
			System.out.println("hello world");
		}
	}
	
	public class HelloWorldGreeting implements Greeting{
		@Override
		public void perform() {
			System.out.println("hello world");
		}
	}
	
	public interface Greeting{
		public void perform();
	}
	
	public interface StringLength{
		public int stringLength(String s);
	}
	
	public static void main(String[] args) {
		HelloWorldMain helloWorldMain = new HelloWorldMain();
		/*
		 * there are several ways to print "hello world" to the screen.
		 * 1. creating class Greeter and print inside
		 */
		Greeter1 greeter1  = helloWorldMain.new Greeter1();
		greeter1.greet();
		/*
		 * 2. pass to class Greeter behavior that greets in order to not change the Greeter class
		 * each time you have anew greeting
		 */
		Greeter2 greeter2  = helloWorldMain.new Greeter2();
		Greeting greeting = helloWorldMain.new HelloWorldGreeting();
		greeter2.greet(greeting);
		/*
		 * 3. creating inner class that implements Greeting interface
		 */
		Greeting greeting1 = new Greeting(){
			public void perform() {
				System.out.println("hello world");
			}
		};
		greeting1.perform();
		/*
		 * creating Lambda expression. 
		 * several things to notice regarding lambda expressions:
		 * 1. lambda is a chunk of code (like a method), but unlike the method signature, 
		 *    we don't need to declare "public"/ "private", return type and name of method - 
		 *    so we are left with brackets (that gets parameters (or not))
		 * 2. after the brackets we add an arrow and after that the chunk of code
		 * 3. if the code is one line, we don't have to add curly braces
		 * 4. Lambda expression is defined by an interface (in this case Greeting) and inside that interface 
		 *    there has to be a method that corresponds with the Lambda expression (name doesn't matter)
		 * 5. this interface must have only one method   
		 */
		Greeting lambdaGreeting = () -> System.out.println("hello world");
		greeter2.greet(lambdaGreeting);
//		 another possible way to do it is the following:
		greeter2.greet(() -> System.out.println("hello world"));
		
		/*
		 * Lambda expression that gets parameters looks like this:
		 */
		StringLength stringLengthLambda = (String s) -> s.length();
		System.out.println(stringLengthLambda.stringLength("Hello Lambda"));
		/*
		 * we also have some shortcuts for this expression:
		 * 1. we don't have to mention the parameter's type
		 * 2. if it's only 1 parameter, we don't have to put brackets
		 */
		stringLengthLambda = s -> s.length();
	}

}