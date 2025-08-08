package AnynoumsFunct;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex12 {

	public static void main(String[] args) {
		
        List<String> names = Arrays.asList("Jayanta", "Jnanedra", "Jayesh");

        List<String> fltrName = names.stream()
                .filter(name -> name.toLowerCase().contains("ja"))
                .collect(Collectors.toList());
     
        fltrName.forEach(n -> System.out.println(n));
    }
}
