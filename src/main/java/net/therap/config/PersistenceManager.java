package net.therap.config;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author ashrafhasan
 * @since 10/11/16
 */
public class PersistenceManager {

    private EntityManagerFactory emFactory;

    public PersistenceManager() {
        this.emFactory = Persistence.createEntityManagerFactory("jpa-example");
    }

    public EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }

    public EntityManagerFactory getEmFactory() {
        return emFactory;
    }

    public void close() {
        emFactory.close();
    }
}
