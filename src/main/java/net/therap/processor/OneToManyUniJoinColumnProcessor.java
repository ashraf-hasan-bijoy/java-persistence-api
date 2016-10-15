package net.therap.processor;

import net.therap.domain.oneToManyUni.Employee;
import net.therap.domain.oneToManyUni.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

/**
 * @author ashrafhasan
 * @since 10/20/16
 */
public class OneToManyUniJoinColumnProcessor implements DbCommandProcessor {

    Logger logger = LoggerFactory.getLogger(OneToManyUniJoinColumnProcessor.class);

    @Override
    public void process(EntityManager entityManager) {

        Employee employee = new Employee("John Doe");
        List<Phone> phoneList = Arrays.asList(new Phone("123", "123"), new Phone("124", "124"), new Phone("125", "125"));

        employee.setPhoneList(phoneList);

        logger.debug("============================ Sql for save start ============================");

        entityManager.persist(employee);
        entityManager.flush();
        entityManager.detach(employee);

        logger.debug("============================ Sql for save end ============================");

        logger.debug("============================ Sql for update start ============================");

        employee = entityManager.find(Employee.class, employee.getId());
        Phone phone = employee.getPhoneList().get(0);
        phone.setArea("123 u");
        phone.setExtension("123 u");
        entityManager.flush();
        entityManager.detach(employee);

        logger.debug("============================ Sql for update end ============================");

        logger.debug("============================ Sql for delete start ============================");

        employee = entityManager.find(Employee.class, employee.getId());
        employee.getPhoneList().remove(1);
        entityManager.flush();

        logger.debug("============================ Sql for delete end ============================");
    }
}
