package net.therap.processor;

import net.therap.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Arrays;
import java.util.List;

/**
 * @author ashrafhasan
 * @since 11/13/16
 */
public class ProcessInsertAction {

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

    public Developer simpleInsert(EntityManagerFactory emFactory) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        Developer developer = new Developer("John Doe");
        List<Feature> featureList = Arrays.asList(new Feature("Feature 1", developer), new Feature("Feature 2", developer));
        developer.setFeatureList(featureList);
        em.persist(developer);

        /*insert query will run before this*/
        em.createQuery("SELECT d FROM Developer d", Developer.class).getResultList();

        /*update query will run for this change*/
        developer.setName("Mary Active");

        em.getTransaction().commit();
        em.close();

        return developer;
    }

    /*
        Owner entity of the relationship can take detached object as the associated Entity. The corresponding table
        only needs the primary key of the detached object to insert is as the foreign key.
    */
    public void insertWithAssociatedDetachedEntity(EntityManagerFactory emFactory) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        University university = new University("DU");
        em.persist(university);

        em.getTransaction().commit();
        em.close();

        em = emFactory.createEntityManager();
        em.getTransaction().begin();

        Student student = new Student("John Doe", university);
        em.persist(student);

        em.getTransaction().commit();
        em.close();
    }

    /*
        In the case of Application Managed Persistence Context, it get closed with the transaction commit
        or em.close (that comes later). So changes made after the Persistence Context is closed or Transaction is committed
        will not be flushed in database.
    */
    public Developer invalidPropertySettingAfterEmClosing(EntityManagerFactory emFactory) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        Developer developer = new Developer("John Doe");
        List<Feature> featureList = Arrays.asList(new Feature("Feature 1", developer), new Feature("Feature 2", developer));
        developer.setFeatureList(featureList);
        em.persist(developer);

        em.getTransaction().commit();
        em.close();

        developer.setName("Marry Active");

        return developer;
    }

    /*
        Inverse side of the relationship can not take detached object as the associated Entity. As it depends on the
        the owner side to manage the relationship so owner object needs to be managed.
    */
    public void invalidInsertWithAssociatedDetachedEntity(EntityManagerFactory emFactory) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();

        ViceChancellor viceChancellor = new ViceChancellor("John Doe", null);
        em.persist(viceChancellor);

        em.getTransaction().commit();
        em.close();

        em = emFactory.createEntityManager();
        em.getTransaction().begin();

        University university = new University("DU");
        university.setViceChancellor(viceChancellor);
        em.persist(university);

        em.getTransaction().commit();
        em.close();
    }
}
