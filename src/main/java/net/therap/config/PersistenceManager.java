package net.therap.config;

import net.therap.processor.DbCommandProcessor;

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

    public void execute(DbCommandProcessor commandProcessor) {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();
            commandProcessor.process(em);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }

    public void close() {
        emFactory.close();
    }

}
