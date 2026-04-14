package fixture.single.authz;

public class RepositoryPermissionController {

    public Repository updateRepository(String repositoryId, String ownerId, String currentUserId, RepositoryService service) {
        Repository repository = service.findById(repositoryId);
        repository.setOwnerId(ownerId);
        return service.updateById(repositoryId, repository);
    }

    public interface RepositoryService {
        Repository findById(String repositoryId);

        Repository updateById(String repositoryId, Repository repository);
    }

    public static class Repository {
        private String ownerId;

        public void setOwnerId(String ownerId) {
            this.ownerId = ownerId;
        }

        public String getOwnerId() {
            return ownerId;
        }
    }
}

