package AnynoumsFunct;

import java.util.Arrays;
import java.util.List;

public class Ex13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
		
        System.out.println(numbers.stream().mapToInt(n->n).average());
	}
}
