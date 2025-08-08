package AnynoumsFunct;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex09 {
    public static void main(String[] args) {
   
        List<String> inputList = Arrays.asList("Jayanta", "Amit", "Vasu");

        // Function: takes List<String>, returns List<Integer> of lengths
        Function<List<String>, List<Integer>> getLengths = list -> {
            List<Integer> result = new ArrayList<>();
            for (String s : list) {
                result.add(s.length());
            }
            return result;
        };

        List<Integer> output = getLengths.apply(inputList);

        System.out.println(output);
    }
}

