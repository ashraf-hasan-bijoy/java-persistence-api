package net.therap.processor;

import net.therap.domain.University;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author ashrafhasan
 * @since 11/15/16
 */
public class ProcessDbFlush {

    /* Entity Manager should be closed in a 'finally' block after created in a 'try' block
        EntityManager em = null;
        try {
            em = emFactory.createEntityManager();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    * */

    public void flushWithTransactionCommit(EntityManagerFactory emFactory) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        University university = new University("DU");
        em.persist(university);

        em.detach(university);

        em.getTransaction().commit();
        em.close();
    }

    public void flushWithMethodCall(EntityManagerFactory emFactory) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        University university = new University("DU");
        em.persist(university);

        em.flush();
        em.detach(university);

        em.getTransaction().commit();
        em.close();
    }
}
