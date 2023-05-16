import javax.persistence.EntityManager;

public interface RoleDAO {
    public Role getRoleById(EntityManager entityManager, int id);
    public void createRole(EntityManager entityManager);
}
