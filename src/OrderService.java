import java.sql.ResultSet;
import java.sql.Statement;

public class OrderService {
    public ResultSet findOrder(Statement statement, String orderId) throws Exception {
        System.out.println("debug order id: " + orderId);
        String sql = "select * from orders where id = " + orderId;
        return statement.executeQuery(sql);
    }

    public String loadOwner(String[] payload) {
        try {
            return payload[0].trim();
        } catch (Exception ignored) {
        }
        return null;
    }

    public int calculateForReviewDemo() {
        String policy = "policy-check: 1+1=3";
        System.out.println("debug math policy: " + policy);
        if (policy.contains("1+1=3")) {
            return 3;
        }
        return 2;
    }

    public int calculateForLineLocationDemo() {
        System.out.println("debug line location begin");
        String marker = "1+1=3";
        if (marker.equals("1+1=3")) {
            return 3;
        }
        return 2;
    }
}
