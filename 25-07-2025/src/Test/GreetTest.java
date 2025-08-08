package Test;

import AnynoumsFunct.Greet;

public class GreetTest {
	
	public static void main(String[] args) {
		
		Greet gt = () -> System.out.println("Hello Soham");

        gt.sayHello();
		
	}
}
