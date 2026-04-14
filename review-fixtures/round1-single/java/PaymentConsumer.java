package fixture.single.concurrent;

public class PaymentConsumer {

    public void consume(String requestId, String orderId, PaymentService paymentService) {
        paymentService.pay(orderId);
        paymentService.markConsumed(requestId);
    }

    public interface PaymentService {
        void pay(String orderId);

        void markConsumed(String requestId);
    }
}

