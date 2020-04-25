package main.map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapMethodsMain {

	public static void main(String[] args) {
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
		for (int i=1; i<101; i++) {
			map.put(i, "person_" + i);
		}
		
		System.out.println("printing hashmap with one threads:");
		
		map.forEach((k,v) -> {
			System.out.println("Thread: " + Thread.currentThread().getName());
			System.out.println(k + "\t" + v);
		});
		
		System.out.println("printing hashmap with multiple threads:");
		
		//new forEach method that gets long and BiConsumer functional interface, 
		//whereas long is the threshold of number of threads that will execute this operation in parallel
		map.forEach(3, (k,v) -> {
			System.out.println("Thread: " + Thread.currentThread().getName());
			System.out.println(k + "\t" + v);
		});
		
		System.out.println("printing hashmap's key with multiple threads:");
		
		//new forEachKey method that gets long and Consumer functional interface, 
		//whereas long is the threshold of number of threads that will execute this operation in parallel
		map.forEachKey(3, k -> {
			System.out.println("Thread: " + Thread.currentThread().getName());
			System.out.println(k);
		});
		
		System.out.println("printing hashmap's value with multiple threads:");
		
		//new forEachValue method that gets long and Consumer functional interface, 
		//whereas long is the threshold of number of threads that will execute this operation in parallel
		map.forEachValue(3, v -> {
			System.out.println("Thread: " + Thread.currentThread().getName());
			System.out.println(v);
		});
		
		System.out.println("printing hashmap's entry with multiple threads:");
		
		//new forEachEntry method that gets long and BiConsumer functional interface, 
		//whereas long is the threshold of number of threads that will execute this operation in parallel
		map.forEachEntry(3, e -> {
			System.out.println("Thread: " + Thread.currentThread().getName());
			System.out.println(e);
		});
		
		//new search method that gets long and BiFunction functional interface, 
		//whereas long is the threshold of number of threads that will execute this operation in parallel
		String result1 = map.search(3, (k,v) ->{
			if(k > 20){
				return v;
			}
			return null;
		});
		System.out.println("value of key > 20 after search method is: " + result1);
		
		//new searchEntries method that gets long and Function functional interface, 
		//whereas long is the threshold of number of threads that will execute this operation in parallel
		String result2 = map.searchEntries(3, e -> {
			if(e.getKey() > 40){
				return e.getValue();
			}
			return null;
		});
		
		System.out.println("value of key > 40 after searchEntries method is: " + result2);
		
		//new searchKeys method that gets long and Function functional interface, 
		//whereas long is the threshold of number of threads that will execute this operation in parallel
		int result3 = map.searchKeys(3, k -> {
			if(k > 7){
				return k;
			}
			return null;
		});
		
		System.out.println("key > 7 after searchKeys method is: " + result3);
		
		//new searchValues method that gets long and Function functional interface, 
		//whereas long is the threshold of number of threads that will execute this operation in parallel
		String result4 = map.searchValues(3, v -> {
			if(v.contains("6")){
				return v;
			}
			return null;
		});
		
		System.out.println("value that contains 6 after searchValues method is: " + result4);
		
		
		//new searchValues method that gets long and 2 BiFunction functional interfaces, 
		//whereas long is the threshold of number of threads that will execute this operation in parallel
		//the last parameter determines what to do with the keys and values
		String result5 = map.reduce(3, (k,v) -> k+"-"+v, (r1,r2) -> r1+","+r2);
		System.out.println("reduce output: " + result5);
		
		//new searchValues method that gets long and BiFunction functional interface, 
		//whereas long is the threshold of number of threads that will execute this operation in parallel
		//the last parameter determines what to do with the keys
		int result6 = map.reduceKeys(3, (r1,r2) -> r1 + r2);
		System.out.println("reduceKeys output: " + result6);
		
		//new searchValues method that gets long and BiFunction functional interface, 
		//whereas long is the threshold of number of threads that will execute this operation in parallel
		//the last parameter determines what to do with the values
		String result7 = map.reduceValues(3, (r1,r2) -> r1 + ", " + r2);
		System.out.println("reduceValues output: " + result7);
	}
}
