package SOLID_Principles;

public class GooglePay implements Payment {

	public void pay(double amount) {
        System.out.println("GooglePay: " +amount);
    }
}
