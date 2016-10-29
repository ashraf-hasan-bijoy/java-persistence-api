package net.therap.processor;

import net.therap.domain.manyToManyUni.Order;
import net.therap.domain.manyToManyUni.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.Date;

/**
 * @author ashrafhasan
 * @since 10/13/16
 */
public class ManyToManyUniProcessor implements DbCommandProcessor {

    Logger logger = LoggerFactory.getLogger(ManyToManyUniProcessor.class);

    @Override
    public void process(EntityManager entityManager) {

        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");

        entityManager.persist(product1);
        entityManager.persist(product2);

        Order order = new Order(1001, new Date());

        order.setProductList(Arrays.asList(product1, product2));

        entityManager.persist(order);

        logger.debug("======================== Sql for saving start ========================");
        entityManager.flush();

        logger.debug("======================== Sql for saving end ========================");
        entityManager.clear();

        order = entityManager.find(Order.class, order.getId());
        Product product3 = new Product("Product 3");
        entityManager.persist(product3);
        order.getProductList().add(product3);

        logger.debug("======================== Sql for update start ========================");
        entityManager.flush();
        logger.debug("======================== Sql for update end ========================");

        entityManager.clear();

        order = entityManager.find(Order.class, order.getId());

        order.getProductList().remove(0);
        logger.debug("======================== Sql for delete start ========================");
        entityManager.flush();
        logger.debug("======================== Sql for delete end ========================");

    }
}
