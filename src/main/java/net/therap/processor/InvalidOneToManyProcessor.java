package net.therap.processor;

import net.therap.domain.oneToManyBi.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

/**
 * @author ashrafhasan
 * @since 10/20/16
 */
public class InvalidOneToManyProcessor implements DbCommandProcessor {

    Logger logger = LoggerFactory.getLogger(InvalidOneToManyProcessor.class);

    @Override
    public void process(EntityManager entityManager) {
        Manager manager = new Manager("John Doe");

        logger.debug("========================" + "Invalid save from inverse side start" + "========================");

        List<Project> projects = Arrays.asList(new Project("Project 1"), new Project("Project 2"));
        manager.setProjectList(projects);

        entityManager.persist(manager);
        entityManager.flush();
        entityManager.detach(manager);

        manager = entityManager.find(Manager.class, manager.getId());
        logger.debug("Manager : {}", manager);

        logger.debug("========================" + "Invalid save from inverse side end" + "========================");
        logger.debug("========================" + "Invalid update from inverse side start" + "========================");
        projects = Arrays.asList(new Project("Project 1", manager), new Project("Project 2", manager));
        manager.setProjectList(projects);

        entityManager.flush();
        entityManager.detach(manager);
        manager = entityManager.find(Manager.class, manager.getId());
        logger.debug("Manager : {}", manager);

        manager.getProjectList().remove(0);
        entityManager.flush();
        entityManager.detach(manager);

        manager = entityManager.find(Manager.class, manager.getId());
        logger.debug("Manager : {}", manager);
        logger.debug("========================" + "Invalid update from inverse side end" + "========================");
        logger.debug("========================" + "Missing mapped by in inverse side start" + "========================");
        Tester tester = new Tester("Mary Active");

        List<TestPlan> testPlanList = Arrays.asList(new TestPlan("Test plan 1", tester), new TestPlan("Test plan 2", tester));
        tester.setTestPlans(testPlanList);

        entityManager.persist(tester);
        entityManager.flush();
        entityManager.detach(tester);

        tester = entityManager.find(Tester.class, tester.getId());
        logger.debug("Tester : {}", tester);
        logger.debug("========================" + "Missing mapped by in inverse side end" + "========================");

        /*
            SELECT * FROM TABLE_TEST_PLAN;
            SELECT * FROM TABLE_TESTER_TEST_PLANS;
        * */
    }
}
