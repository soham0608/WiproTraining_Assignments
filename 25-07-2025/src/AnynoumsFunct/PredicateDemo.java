package AnynoumsFunct;

import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Predicate<String> isPalindrome = str -> {
	            return str.equalsIgnoreCase(new StringBuilder(str).reverse().toString());
	        };

	        String str1 = "MADAM";
	        String str2 = "HELLO";
	        
	        System.out.println(isPalindrome.test(str1));
	        System.out.println(isPalindrome.test(str2));
	}

}
