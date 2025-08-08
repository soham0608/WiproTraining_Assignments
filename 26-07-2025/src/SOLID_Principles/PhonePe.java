package SOLID_Principles;

public class PhonePe implements Payment {
	
	public void pay(double amount) {
        System.out.println("PhonePe: " + amount);
    }
}
