import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class LogInfoDAOImpl implements LogInfoDAO {
    public LogInfoDAOImpl() {
    }

    @Override
    public List<LogInfo> getAllLogInfo(EntityManager entityManager) {
        List<LogInfo> loginfo = new ArrayList<>();
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT l FROM Loginfo l";
        TypedQuery<LogInfo> query = entityManager.createQuery(jpqlQuery, LogInfo.class);
        loginfo = query.getResultList();
        entityManager.getTransaction().commit();
        return loginfo;
    }

    @Override
    public LogInfo getLogInfoById(EntityManager entityManager, int id) {
        LogInfo log = null;
        entityManager.getTransaction().begin();
        log = entityManager.find(LogInfo.class, new Integer(id));
        entityManager.getTransaction().commit();
        return log;
    }

    @Override
    public void createLogInfo(EntityManager entityManager, LogInfo loginfo) {
        entityManager.getTransaction().begin();
        entityManager.persist(loginfo);
        entityManager.getTransaction().commit();
    }
    @Override
    public void updateLogInfoById(EntityManager entityManager, int id, LogInfo loginfo) {
        entityManager.getTransaction().begin();
        LogInfo logInfoCheck = entityManager.find(LogInfo.class, new Integer(id));
        if(entityManager.contains(logInfoCheck)) {
            loginfo.setCreateDate(logInfoCheck.getCreateDate());
            entityManager.merge(loginfo);
            entityManager.flush();
            System.out.println("Пользователь " + id + " обновлен");
        } else {
            System.out.println("Пользователь " + id + " не найден");
        }
        entityManager.getTransaction().commit();
    }
    @Override
    public void deleteLogInfoById(EntityManager entityManager, int id) {
        entityManager.getTransaction().begin();
        LogInfo logInfoCheck = entityManager.find(LogInfo.class, new Integer(id));
        if(entityManager.contains(logInfoCheck)) {
            entityManager.remove(logInfoCheck);
            System.out.println("Пользователь " + id + " удален");
        } else {
            System.out.println("Пользователь " + id + " не найден");
        }
        entityManager.getTransaction().commit();
    }

    public void printAllLogInfo (List<LogInfo> list) {
        for(LogInfo log: list) {
            System.out.println("LogInfo{" +
                    "logId=" + log.getLogId() +
                    ", name='" + log.getName() + '\'' +
                    ", login='" + log.getLogin() + '\'' +
                    ", password='" + log.getPassword() + '\'' +
                    ", createDate=" + log.getCreateDate() +
                    ", updateDate=" + log.getUpdateDate());;
        }
    }
    public void printLogInfoWithRoles(LogInfo loginfo) {
        if(loginfo == null) {
            System.out.println("Пользователя не найден");
        } else {
            System.out.println(loginfo);
        }
    }
}
