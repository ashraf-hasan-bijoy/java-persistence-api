package net.therap.processor;

import net.therap.domain.oneToOneUni.Employee;
import net.therap.domain.oneToOneUni.ParkingSpace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

/**
 * @author ashrafhasan
 * @since 10/29/16
 */
public class OneToOneUniProcessor implements DbCommandProcessor {

    Logger logger = LoggerFactory.getLogger(OneToOneUniProcessor.class);

    @Override
    public void process(EntityManager entityManager) {

        ParkingSpace parkingSpace = new ParkingSpace(1);
        entityManager.persist(parkingSpace);

        Employee employee = new Employee("John Dow", parkingSpace);

        logger.debug("======================== Sql for saving start ========================");

        entityManager.persist(employee);
        entityManager.flush();
        entityManager.clear();

        logger.debug("======================== Sql for saving end ========================");

        employee = entityManager.find(Employee.class, employee.getId());
        parkingSpace = new ParkingSpace(2);
        entityManager.persist(parkingSpace);

        employee.setParkingSpace(parkingSpace);
        logger.debug("======================== Sql for updating start ========================");
        entityManager.flush();
        entityManager.clear();
        logger.debug("======================== Sql for updating end ========================");


        employee = entityManager.find(Employee.class, employee.getId());
        employee.setParkingSpace(null);
        logger.debug("======================== Sql for relation deleting  start ========================");
        entityManager.flush();
        logger.debug("======================== Sql for relation deleting end ========================");
    }
}
