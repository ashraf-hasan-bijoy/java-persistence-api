package net.therap.processor;

import net.therap.domain.manyToOneUni.Student;
import net.therap.domain.manyToOneUni.University;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

/**
 * @author ashrafhasan
 * @since 10/20/16
 */
public class ManyToOneUniProcessor implements DbCommandProcessor {

    Logger logger = LoggerFactory.getLogger(ManyToOneUniProcessor.class);

    @Override
    public void process(EntityManager entityManager) {
        University university1 = new University("North South University");
        University university2 = new University("East West University");

        entityManager.persist(university1);
        entityManager.persist(university2);

        entityManager.flush();

        logger.debug("============================ Sql for save start ============================");

        Student student1 = new Student("John Doe", university1);
        entityManager.persist(student1);
        entityManager.flush();

        logger.debug("============================ Sql for save end ============================");

        entityManager.detach(student1);

        logger.debug("============================ Sql for update start ============================");
        student1 = entityManager.find(Student.class, student1.getId());
        student1.setUniversity(university2);

        entityManager.flush();
        entityManager.detach(student1);

        logger.debug("============================ Sql for update end ============================");

//        set optional = true and nullable = true and left join

    }
}
