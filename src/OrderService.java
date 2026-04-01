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
}
