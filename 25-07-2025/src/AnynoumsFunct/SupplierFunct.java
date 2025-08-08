package AnynoumsFunct;

import java.time.LocalDate;
import java.util.function.Supplier;

public class SupplierFunct {
	
	public static void main(String[] args) {
		
		Supplier<String> s = () -> {
            return LocalDate.now().plusDays(1).getDayOfWeek().toString();       
        };
		
        System.out.println(s.get());
	}
}
