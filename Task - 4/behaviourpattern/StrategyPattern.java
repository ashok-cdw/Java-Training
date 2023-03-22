/*
 * Program describes the strategy pattern 
 * 
 * Based on input, specified instance will be created
 */
package behaviourpattern;

public class StrategyPattern {
	public static void main(String[] args) throws Exception {
		Shopping shopping = new Shopping();
		shopping.checkout(new PaymentViaUPI());
		shopping.checkout(new PaymentViaCard());
	}
}

interface PaymentStrategy{
	public void pay();
}

class PaymentViaUPI implements PaymentStrategy{

	@Override
	public void pay() {
		System.out.println("Payment Done Via UPI");
	}
}

class PaymentViaCard implements PaymentStrategy{

	@Override
	public void pay() {
		System.out.println("Payment Done Via Card");
	}
}

class Shopping{
	void checkout(PaymentStrategy payment) {
		payment.pay();
	}
}