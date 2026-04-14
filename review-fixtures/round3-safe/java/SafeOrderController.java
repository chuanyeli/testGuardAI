package fixture.safe;

public class SafeOrderController {

    public String updateOrder(
        String currentUserId,
        String repositoryOwnerId,
        String status,
        Integer amount,
        OrderValidator validator
    ) {
        if (!currentUserId.equals(repositoryOwnerId)) {
            throw new IllegalArgumentException("forbidden");
        }
        validator.validateStatus(status);
        validator.validateAmount(amount);
        return "updated";
    }

    public interface OrderValidator {
        void validateStatus(String status);

        void validateAmount(Integer amount);
    }
}
