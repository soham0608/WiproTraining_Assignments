package AnynoumsFunct;

public class FoodItem {
	String foodName;
    String foodType; 
    String cuisine; 
    double price;

    public FoodItem(String foodName, String foodType, String cuisine, double price) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.cuisine = cuisine;
        this.price = price;
    }

    public void display() {
        System.out.println(foodName + " " + foodType + " " + cuisine + " " + price);
    }
}
