package net.therap.processor;

import net.therap.domain.Developer;
import net.therap.domain.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ashrafhasan
 * @since 11/13/16
 */
public class ProcessUpdateAction {

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

    Logger logger = LoggerFactory.getLogger(ProcessUpdateAction.class);

    public void updateManagedEntity(EntityManagerFactory emFactory) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        Developer developer = new Developer("John Doe");
        List<Feature> featureList = Arrays.asList(new Feature("Feature 1", developer), new Feature("Feature 2", developer));
        developer.setFeatureList(featureList);
        em.persist(developer);

        em.getTransaction().commit();
        em.close();

        em = emFactory.createEntityManager();
        em.getTransaction().begin();

        developer = em.find(Developer.class, developer.getId());
        developer.setName("Mary Active");
        developer.getFeatureList().remove(0);
        developer.getFeatureList().add(new Feature("Feature 3", developer));
        logger.debug("Developer : {}", developer);

        em.getTransaction().commit();
        em.close();
    }

    public void updateDetachedEntity(EntityManagerFactory emFactory) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        Developer developer = new Developer("John Doe");

        List<Feature> featureList = new ArrayList<>();
        featureList.add(new Feature("Feature 1", developer));
        featureList.add(new Feature("Feature 2", developer));

        developer.setFeatureList(featureList);
        em.persist(developer);

        em.getTransaction().commit();
        em.close();

        developer.setName("Mary Active");
        developer.getFeatureList().remove(0);
        developer.getFeatureList().add(new Feature("Feature 3", developer));

        em = emFactory.createEntityManager();
        em.getTransaction().begin();

        developer = em.merge(developer);
        logger.debug("Developer : {}", developer);

        em.getTransaction().commit();
        em.close();
    }

    public void invalidMerge(EntityManagerFactory emFactory) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        Developer developer = new Developer("John Doe");

        List<Feature> featureList = new ArrayList<>();
        featureList.add(new Feature("Feature 1", developer));
        featureList.add(new Feature("Feature 2", developer));

        developer.setFeatureList(featureList);
        em.persist(developer);

        em.getTransaction().commit();
        em.close();

        em = emFactory.createEntityManager();
        em.getTransaction().begin();

        em.merge(developer);
        developer.setName("Mary Active");

        em.getTransaction().commit();
        em.close();
    }
}
