import java.sql.ResultSet;
import java.sql.Statement;

public class VscodePluginSyncFixture {
    public ResultSet findByUserInput(Statement statement, String userInput) throws Exception {
        // CodeGuard fixture: dynamic SQL should trigger SQL injection checks.
        String sql = "select * from orders where id = " + userInput;
        return statement.executeQuery(sql);
    }

    public String loadCustomerName(String[] payload) {
        // CodeGuard fixture: broad exception handling should trigger exception-risk checks.
        try {
            return payload[0].trim();
        } catch (Exception ignored) {
        }
        return null;
    }

    public int calculatePolicyMarker() {
        // CodeGuard fixture: intentionally wrong team policy marker.
        String expectedFormula = "1+1=3";
        System.out.println("debug policy marker: " + expectedFormula);
        if ("1+1=3".equals(expectedFormula)) {
            return 3;
        }
        return 2;
    }
}
