package net.therap.processor;

import net.therap.domain.oneToOneBi.University;
import net.therap.domain.oneToOneBi.ViceChancellor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

/**
 * @author ashrafhasan
 * @since 10/13/16
 */
public class OneToOneBiProcessor implements DbCommandProcessor {

    Logger logger = LoggerFactory.getLogger(OneToOneBiProcessor.class);

    @Override
    public void process(EntityManager entityManager) {

        University buet = new University("BUET");
        University du = new University("DU");

        entityManager.persist(buet);
        entityManager.persist(du);

        logger.debug("======================== Sql for saving start ========================");
        ViceChancellor viceChancellor = new ViceChancellor("John Doe", buet);
        entityManager.persist(viceChancellor);
        entityManager.flush();

        logger.debug("======================== Sql for saving end ========================");
        entityManager.clear();

        viceChancellor = entityManager.find(ViceChancellor.class, viceChancellor.getId());
        viceChancellor.setUniversity(du);

        logger.debug("======================== Sql for updating start ========================");
        entityManager.flush();
        logger.debug("======================== Sql for updating end ========================");

        entityManager.clear();

        du = entityManager.find(University.class, du.getId());
        du.setViceChancellor(null);

        logger.debug("======================== Sql for orphan removal start ========================");
    }
}
