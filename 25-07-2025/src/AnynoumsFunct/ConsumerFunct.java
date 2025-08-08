package AnynoumsFunct;

import java.util.function.Consumer;

public class ConsumerFunct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Consumer<Integer> nextEvn = n -> {
            int nextEven = (n % 2 == 0) ? n + 2 : n + 1; 
            System.out.println(nextEven);
		};

        nextEvn.accept(5);  
        nextEvn.accept(100); 
	}

}
