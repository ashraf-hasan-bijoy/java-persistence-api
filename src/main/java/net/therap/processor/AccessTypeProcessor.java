package net.therap.processor;

import net.therap.domain.accessType.FieldAccessEntity;
import net.therap.domain.accessType.MixedAccessEntity;
import net.therap.domain.accessType.PropertyAccessEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

/**
 * @author ashrafhasan
 * @since 10/14/16
 */
public class AccessTypeProcessor implements DbCommandProcessor {

    private Logger logger = LoggerFactory.getLogger(AccessTypeProcessor.class);

    @Override
    public void process(EntityManager entityManager) {
        FieldAccessEntity fieldAccessEntity = new FieldAccessEntity("John", "Doe");
        PropertyAccessEntity propertyAccessEntity = new PropertyAccessEntity("John", "Doe");
        MixedAccessEntity mixedAccessEntity = new MixedAccessEntity("John", "Doe");

        entityManager.persist(fieldAccessEntity);
        entityManager.persist(propertyAccessEntity);
        entityManager.persist(mixedAccessEntity);

        entityManager.flush();
        entityManager.detach(fieldAccessEntity);
        entityManager.detach(propertyAccessEntity);
        entityManager.detach(mixedAccessEntity);

        mixedAccessEntity = entityManager.find(MixedAccessEntity.class, mixedAccessEntity.getId());
        fieldAccessEntity = entityManager.find(FieldAccessEntity.class, fieldAccessEntity.getId());
        propertyAccessEntity = entityManager.find(PropertyAccessEntity.class, propertyAccessEntity.getId());

        logger.debug("MixedAccessEntity : {}", mixedAccessEntity);
        logger.debug("FieldAccessEntity : {}", fieldAccessEntity);
        logger.debug("PropertyAccessEntity : {}", propertyAccessEntity);

        /*
            SELECT * FROM table_mixed_access_entity;
            SELECT * FROM table_field_access_entity;
            SELECT * FROM table_property_access_entity;
        * */
    }
}
