package net.therap.processor;

import net.therap.domain.tableAnnotation.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.Random;

/**
 * @author ashrafhasan
 * @since 10/11/16
 */
public class TableAnnotationProcessor implements DbCommandProcessor {

    Logger logger = LoggerFactory.getLogger(TableAnnotationProcessor.class);

    @Override
    public void process(EntityManager em) {
        String customerNumber = String.valueOf(new Random(new Date().getTime()).nextInt());
        String customerName = "John Doe" + String.valueOf(new Random(new Date().getTime()).nextInt());
        Customer customer = new Customer(customerNumber, customerName);

        em.persist(customer);
        em.flush();
        em.detach(customer);

        customer = em.find(Customer.class, customer.getId());

        logger.debug("Customer : {}", customer);

        /*
            DESC TABLE_CUSTOMER;
            SELECT * FROM TABLE_CUSTOMER;
         */
    }
}
