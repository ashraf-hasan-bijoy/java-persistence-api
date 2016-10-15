package net.therap.processor;

import javax.persistence.EntityManager;

/**
 * @author ashrafhasan
 * @since 10/11/16
 */
public interface DbCommandProcessor {

    void process(EntityManager entityManager);
}
