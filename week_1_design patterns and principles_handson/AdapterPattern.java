interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    public void sendPayment(double amount) {
        System.out.println("Processing PayPal payment of ₹" + amount);
    }
}

class StripeGateway {
    public void makePayment(double amount) {
        System.out.println("Processing Stripe payment of ₹" + amount);
    }
}
class RazorpayGateway {
    public void doTransaction(double amount) {
        System.out.println("Processing Razorpay transaction of ₹" + amount);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private final PayPalGateway paypal;

    public PayPalAdapter(PayPalGateway paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(double amount) {
        paypal.sendPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripe;

    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.makePayment(amount);
    }
}
class RazorpayAdapter implements PaymentProcessor {
    private final RazorpayGateway razorpay;

    public RazorpayAdapter(RazorpayGateway razorpay) {
        this.razorpay = razorpay;
    }

    @Override
    public void processPayment(double amount) {
        razorpay.doTransaction(amount);
    }
}
public class AdapterPattern{
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        paypalProcessor.processPayment(1500.0);
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(2500.0);
        PaymentProcessor razorpayProcessor = new RazorpayAdapter(new RazorpayGateway());
        razorpayProcessor.processPayment(1000.0);
    }
}
