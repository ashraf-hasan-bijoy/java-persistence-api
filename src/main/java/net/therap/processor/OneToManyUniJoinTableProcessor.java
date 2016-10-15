package net.therap.processor;

import net.therap.domain.oneToManyUni.MobileSet;
import net.therap.domain.oneToManyUni.Sim;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

/**
 * @author ashrafhasan
 * @since 10/20/16
 */
public class OneToManyUniJoinTableProcessor implements DbCommandProcessor {
    @Override
    public void process(EntityManager entityManager) {

        Logger logger = LoggerFactory.getLogger(OneToManyUniJoinTableProcessor.class);

        MobileSet mobileSet = new MobileSet("Samsung");
        List<Sim> simList = Arrays.asList(new Sim("Warid"), new Sim("Robi"), new Sim("Grameen"));

        logger.debug("============================ Sql for save start ============================");
        mobileSet.setSimList(simList);

        entityManager.persist(mobileSet);
        entityManager.flush();
        entityManager.detach(mobileSet);

        logger.debug("============================ Sql for save end ============================");
        logger.debug("============================ Sql for update start ============================");

        mobileSet = entityManager.find(MobileSet.class, mobileSet.getId());
        Sim sim = mobileSet.getSimList().get(0);
        sim.setOperator("Airtel");

        entityManager.flush();
        entityManager.detach(mobileSet);

        logger.debug("============================ Sql for update end ============================");
        logger.debug("============================ Sql for delete start ============================");

        mobileSet = entityManager.find(MobileSet.class, mobileSet.getId());
        mobileSet.getSimList().remove(1);
        entityManager.flush();

        logger.debug("============================ Sql for delete end ============================");
    }
}
