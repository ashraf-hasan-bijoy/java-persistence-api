package net.therap.processor;

import net.therap.domain.oneToOneBi.City;
import net.therap.domain.oneToOneBi.Country;
import net.therap.domain.oneToOneBi.Mayor;
import net.therap.domain.oneToOneBi.PrimeMinister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

/**
 * @author ashrafhasan
 * @since 11/1/16
 */
public class InvalidMappingProcessor implements DbCommandProcessor {
    Logger logger = LoggerFactory.getLogger(InvalidMappingProcessor.class);

    @Override
    public void process(EntityManager entityManager) {
        Country country = new Country("UK");
        entityManager.persist(country);

        PrimeMinister primeMinister = new PrimeMinister("John Doe");
        primeMinister.setCountry(country);

        entityManager.persist(primeMinister);
        entityManager.flush();

        entityManager.clear();

        country = entityManager.find(Country.class, country.getId());
        country.setPrimeMinister(null);
        logger.debug("======================== Invalid cascade from child to parent start ========================");
        entityManager.flush();
        logger.debug("======================== Invalid cascade from child to parent end ========================");

        City city = new City("London");
        entityManager.persist(city);

        Mayor mayor = new Mayor("Mary Active");
        mayor.setCity(city);

        entityManager.persist(mayor);
        entityManager.flush();

        entityManager.clear();

        mayor = entityManager.find(Mayor.class, mayor.getId());
        mayor.setCity(null);
        logger.debug("======================== Invalid orphan removal from child to parent start ========================");
        entityManager.flush();
        logger.debug("======================== Invalid orphan removal from child to parent end ========================");
    }
}
