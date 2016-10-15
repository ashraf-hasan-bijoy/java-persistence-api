package net.therap.processor;

import net.therap.domain.oneToManyBi.Developer;
import net.therap.domain.oneToManyBi.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

/**
 * @author ashrafhasan
 * @since 10/20/16
 */
public class OneToManyBiProcessor implements DbCommandProcessor {

    Logger logger = LoggerFactory.getLogger(OneToManyBiProcessor.class);

    @Override
    public void process(EntityManager entityManager) {

        Developer seniorDevel = new Developer("John Doe");
        Developer juniorDevel = new Developer("Mary Active");

        List<Feature> mFeatureList = Arrays.asList(new Feature("Feature 1", seniorDevel), new Feature("Feature 2", seniorDevel));
        seniorDevel.setFeatureList(mFeatureList);

        logger.debug("============================ Sql for save start ============================");
        entityManager.persist(seniorDevel);
        entityManager.persist(juniorDevel);

        entityManager.flush();

        logger.debug("Senior Developer : {}", seniorDevel);
        logger.debug("Junior Developer : {}", juniorDevel);

        entityManager.detach(seniorDevel);
        entityManager.detach(juniorDevel);

        logger.debug("============================ Sql for save end ============================");
        logger.debug("============================ Sql for update from owner side start ============================");

        seniorDevel = entityManager.find(Developer.class, seniorDevel.getId());

        Feature feature = seniorDevel.getFeatureList().get(1);
        feature.setDeveloper(juniorDevel);

        Feature otherFeature = new Feature("Feature 3", seniorDevel);
        entityManager.persist(otherFeature);
        entityManager.flush();
        entityManager.detach(seniorDevel);

        seniorDevel = entityManager.find(Developer.class, seniorDevel.getId());
        juniorDevel = entityManager.find(Developer.class, juniorDevel.getId());

        logger.debug("Senior Developer : {}", seniorDevel);
        logger.debug("Junior Developer : {}", juniorDevel);

        logger.debug("============================ Sql for update from owner side end ============================");
        logger.debug("============================ Sql for delete start ============================");

        seniorDevel = entityManager.find(Developer.class, seniorDevel.getId());

        seniorDevel.getFeatureList().remove(0);

        entityManager.flush();
        entityManager.detach(seniorDevel);

        seniorDevel = entityManager.find(Developer.class, seniorDevel.getId());
        juniorDevel = entityManager.find(Developer.class, juniorDevel.getId());

        logger.debug("Senior Developer : {}", seniorDevel);
        logger.debug("Junior Developer : {}", juniorDevel);
    }
}
