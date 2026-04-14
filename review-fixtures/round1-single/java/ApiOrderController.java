package fixture.single.api;

public class ApiOrderController {

    public String createOrder(String status, String userId, Integer amount, String requestBody) {
        if ("CLOSED".equals(status)) {
            return "not allowed";
        }
        return "create order for " + userId + " amount=" + amount + " body=" + requestBody;
    }
}

