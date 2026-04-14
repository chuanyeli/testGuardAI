package fixture.mixed;

public class CheckoutFacade {

    public String checkout(
        String requestId,
        String orderId,
        String accountId,
        String status,
        int amount,
        OrderService orderService,
        InventoryService inventoryService,
        PaymentService paymentService
    ) {
        if ("PAID".equals(status)) {
            return "already paid";
        }

        Order order = orderService.getById(orderId);
        inventoryService.deduct(orderId, amount);
        paymentService.charge(accountId, amount);
        order.setStatus(status);
        orderService.updateById(orderId, order);
        return "ok";
    }

    public interface OrderService {
        Order getById(String orderId);

        Order updateById(String orderId, Order order);
    }

    public interface InventoryService {
        void deduct(String orderId, int amount);
    }

    public interface PaymentService {
        void charge(String accountId, int amount);
    }

    public static class Order {
        private String status;

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }
}

