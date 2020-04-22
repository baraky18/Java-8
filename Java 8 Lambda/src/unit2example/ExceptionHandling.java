package unit2example;

import java.util.function.BiConsumer;

public class ExceptionHandling {

	public static void main(String[] args){
		int[] someNumbers = {1, 2, 3, 4};
		int key = 0;
		/*
		 * if we need to catch exceptions, it makes the Lambda expression complicated and long
		 */
		process(someNumbers, key, (v,k) -> 
		{
			try{
			System.out.println(v/k);
			}
			catch(Exception e){
				System.out.println("We got exception from Lambda");
			}
		});
		
		/*
		 * instead, we can wrap the lambda with another lambda and pass the wrapper to the method.
		 * that wrapper lambda will perform the try and catch so the "messy" code is moved somewhere else
		 */
		process(someNumbers, key, wrapperLambda((v,k) -> System.out.println(v/k)));
	}


	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : someNumbers) {
			consumer.accept(i, key);
		}
	}
	
	private static BiConsumer<Integer, Integer>  wrapperLambda(BiConsumer<Integer, Integer> consumer){
		return (v,k) ->
		{
			try{
				consumer.accept(v, k);
			}
			catch(Exception e){
				System.out.println("We got exception from wrapper Lambda");
			}
		};
	}
}
