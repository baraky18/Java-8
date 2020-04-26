import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PeekAndSkipExample {

	public static void main(String[] args) {
		List<String> numList = Stream.of("One", "Two", "Three")
			.filter(num -> !num.equalsIgnoreCase("One"))
			.peek(num -> System.out.println("peeked number is: " + num))//peek method allows us to do some operation like logging - meaning to print something
			.collect(Collectors.toList());
		
		IntStream.of(1, 23, 4, 5, 6, 7)
			.skip(2)//skip method skips amount of elements in the list
			.filter(num -> num>5)
			.forEach(num -> System.out.println(num));
	}

}
