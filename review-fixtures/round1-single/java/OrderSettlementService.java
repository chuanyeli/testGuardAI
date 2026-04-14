package fixture.single.transaction;

public class OrderSettlementService {

    public void settle(String orderId, int amount, InventoryService inventoryService, PaymentService paymentService) {
        inventoryService.deduct(orderId, amount);
        paymentService.charge(orderId, amount);
        saveOrder(orderId, "PAID");
    }

    private void saveOrder(String orderId, String status) {
        System.out.println("save order " + orderId + " status=" + status);
    }

    public interface InventoryService {
        void deduct(String orderId, int amount);
    }

    public interface PaymentService {
        void charge(String orderId, int amount);
    }
}

