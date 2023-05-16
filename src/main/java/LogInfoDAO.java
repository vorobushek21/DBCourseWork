import javax.persistence.EntityManager;
import java.util.List;

public interface LogInfoDAO {
    List<LogInfo> getAllLogInfo(EntityManager entityManager);
    LogInfo getLogInfoById(EntityManager entityManager, int id);
    public void createLogInfo(EntityManager entityManager, LogInfo loginfo);
    public void updateLogInfoById(EntityManager entityManager, int id, LogInfo loginfo);
    public void deleteLogInfoById(EntityManager entityManager, int id);
}
