package AnynoumsFunct;

import java.util.function.Function;

public class FunctionalFunct {
    public static void main(String[] args) {
        double number = 123.45;

        Function<Double, Double> getFract = n -> n - Math.floor(n);
        		
        System.out.println(getFract.apply(number));
    }
}
