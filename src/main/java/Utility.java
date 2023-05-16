import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utility {
    private static final EntityManagerFactory factory;
    static {
        factory = Persistence.createEntityManagerFactory("unit");
    }
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
    public static void close(){
        factory.close();
    }
}
