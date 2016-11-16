package net.therap.processor;

import net.therap.domain.Developer;
import net.therap.domain.Feature;
import net.therap.domain.Student;
import net.therap.domain.University;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

/**
 * @author ashrafhasan
 * @since 11/13/16
 */
public class ProcessFindAction {

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

    Logger logger = LoggerFactory.getLogger(ProcessFindAction.class);

    public void findForDataAccess(EntityManagerFactory emFactory) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        Developer developer = new Developer("John Doe");
        List<Feature> featureList = Arrays.asList(new Feature("Feature 1", developer), new Feature("Feature 2", developer));
        developer.setFeatureList(featureList);
        em.persist(developer);

        em.getTransaction().commit();
        em.close();

        em = emFactory.createEntityManager();
        developer = em.find(Developer.class, developer.getId());
        em.close();
    }

    public void findForRelation(EntityManagerFactory emFactory) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        University university = new University("DU");
        em.persist(university);

        em.getTransaction().commit();
        em.close();

        em = emFactory.createEntityManager();
        em.getTransaction().begin();

        university = em.getReference(University.class, university.getId());
        Student student = new Student("John Doe", university);
        em.persist(student);

        em.getTransaction().commit();
        em.close();
    }

    /*
        Lazily associated object cannot be accessed after session is closed.
    * */
    public void invalidAccessLazilyAssociatedEntity (EntityManagerFactory emFactory) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        Developer developer = new Developer("John Doe");
        List<Feature> featureList = Arrays.asList(new Feature("Feature 1", developer), new Feature("Feature 2", developer));
        developer.setFeatureList(featureList);
        em.persist(developer);

        em.getTransaction().commit();
        em.close();

        em = emFactory.createEntityManager();
        developer = em.find(Developer.class, developer.getId());
        em.close();

        logger.debug("Feature list : {}", developer.getFeatureList());
    }
}
