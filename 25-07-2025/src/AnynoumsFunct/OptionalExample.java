package AnynoumsFunct;

import java.util.Optional;

public class OptionalExample {
	
    public static void main(String[] args) 
    {
        Optional<Integer> no = Optional.ofNullable(07);

        no.ifPresent(value -> System.out.println("Value: " + value));

        Optional<Integer> emptyNo = Optional.ofNullable(null);
        
        System.out.println("Value: " + emptyNo.orElse(100));
    }
}
