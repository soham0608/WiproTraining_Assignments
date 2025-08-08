package SOLID_Principles;

public class PaymentMain {
	
    public static void main(String[] args)
    {
        Payment gpay = new GooglePay();
        PaymentService gpayService = new PaymentService(gpay);
        gpayService.makePayment(500);

        Payment phonePe = new PhonePe();
        PaymentService phonePeService = new PaymentService(phonePe);
        phonePeService.makePayment(1000);

    }
}
