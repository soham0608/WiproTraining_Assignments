package AnynoumsFunct;

import java.util.function.Predicate;

public class UpperCase_LowerCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String uStr = "HELLO";
        String lstr = "world";
		
		Predicate<String> isUpperCase = str -> str.equals(str.toUpperCase());

        Predicate<String> isLowerCase = str -> str.equals(str.toLowerCase());
        
        System.out.println(isUpperCase.test(uStr));
        System.out.println(isUpperCase.test(lstr));
        System.out.println(isLowerCase.test(uStr));
        System.out.println(isLowerCase.test(lstr));
	}
}
