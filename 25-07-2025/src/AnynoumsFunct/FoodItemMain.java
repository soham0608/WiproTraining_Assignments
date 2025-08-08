package AnynoumsFunct;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FoodItemMain {
	
	public static void main(String[] args) {
		
		List<FoodItem> foodList = new ArrayList<>();

        foodList.add(new FoodItem("Spring Rolls", "Veg", "Chinese", 150));
        foodList.add(new FoodItem("Chic.Triple Rice", "Nonveg", "Chinese", 300));
        foodList.add(new FoodItem("Chic.Lolypop", "Nonveg", "Chinese", 200));
        foodList.add(new FoodItem("Paneer Butter Masala", "Veg", "Indian", 180));
        foodList.add(new FoodItem("Sushi", "Non Veg", "Japanese", 300));

        List<FoodItem> chineseFoods = foodList.stream()
                .filter(item -> item.cuisine.equalsIgnoreCase("Chinese"))
                .collect(Collectors.toList());

        chineseFoods.forEach(item -> item.display());
        
        System.out.println("------------------------------------------------------");
        
        Optional<FoodItem> mostExpensiveChinese = foodList.stream()
                .filter(item -> item.cuisine.equalsIgnoreCase("Chinese"))
                .max((item1, item2) -> Double.compare(item1.price, item2.price));
       
        System.out.print("Expensive Dish: ");
        mostExpensiveChinese.get().display();
	}
}
