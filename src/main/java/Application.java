import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        DBCourseWork;
    }

    public static void DBCourseWork() {
        EntityManager entityManager = Utility.getEntityManager();
        LogInfoDAOImpl logDao = new LogInfoDAOImpl();
        RoleDAOImpl roleDAO = new RoleDAOImpl();
        List<LogInfo> users = new ArrayList<>();
        LogInfo loginfo = new LogInfo();
        Role role = new role();

        System.out.println("Получить список всех пользователей");
        users = logDao.getAllLogInfo(entityManager);
        logDao.printAllLogInfo(users);

        System.out.println("Получить пользователя по ID");
        loginfo = logDao.getLogInfoById(entityManager, 1);
        logDao.printLogInfoWithRoles(loginfo);

        System.out.println("Получить список пользователей по роли");
        role = roleDAO.getRoleById(entityManager, 4);
        System.out.println(role.getLoginfo().toString());

        System.out.println("Добавить нового пользователя");
        loginfo = getNewLoginfo(getNewRole(entityManager));
        logDao.createLogInfo(entityManager, loginfo);

        System.out.println("Редактирование пользователя");
        loginfo = getNewLoginfo(getNewRole(entityManager));
        logDao.updateLogInfoById(entityManager, 4, loginfo);

        System.out.println("Получить пользователя по ID");
        loginfo = logDao.getLogInfoById(entityManager, 4);
        logDao.printLogInfoWithRoles(loginfo);

        System.out.println("Удалить пользователя");
        logDao.deleteLogInfoById(entityManager, 9);

        System.out.println("Получить список пользователей");
        users = logDao.getAllLogInfo(entityManager);
        logDao.printAllLogInfo(users);

        System.out.println("Добавить роль");
        roleDAO.createRole(entityManager);

        entityManager.close();
        Utility.close();
    }

    public static Set<Role> getNewRole(EntityManager entityManager) {
        Role role = new Role();
        Set<Role> rol = new HashSet<>();

        entityManager.getTransaction().begin();
        role = entityManager.find(Role.class, new Integer(2));
        entityManager.getTransaction().commit();
        rol.add(role);

        entityManager.getTransaction().begin();
        role = entityManager.find(Role.class, new Integer(4));
        entityManager.getTransaction().commit();
        rol.add(role);

        System.out.println("Подготовлены роли для дальнейших действий");
        System.out.println(role);
        return rol;
    }
    public static LogInfo getNewLoginfo(Set<Role> role) {
        LogInfo loginfo = new LogInfo();
        loginfo.setLogId(4);
        loginfo.setName("tester1");
        loginfo.setLogin("login_updated");
        loginfo.setPassword("password_updated");
        loginfo.setAction(role);

        System.out.println("Подготовлены данные пользователя");
        System.out.println(loginfo);
        return loginfo;
    }

}
