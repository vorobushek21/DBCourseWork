import javax.persistence.EntityManager;

public class RoleDAOImpl implements RoleDAO {
    public RoleDAOImpl() {
    }

    @Override
    public Role getRoleById(EntityManager entityManager, int id) {
        Role role = null;
        entityManager.getTransaction().begin();
        role = entityManager.find(Role.class, new Integer(id));
        entityManager.getTransaction().commit();
        return role;
    }
    @Override
    public void createRole(EntityManager entityManager) {
        Role role = new Role();
        role.setActionRole("Разработчик");
        entityManager.getTransaction().begin();
        entityManager.persist(role);
        entityManager.getTransaction().commit();
    }
}
