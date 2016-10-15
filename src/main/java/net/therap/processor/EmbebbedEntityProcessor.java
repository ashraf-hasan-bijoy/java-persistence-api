package net.therap.processor;

import net.therap.domain.embeddedEntity.Address;
import net.therap.domain.embeddedEntity.Person;
import net.therap.domain.embeddedEntity.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

/**
 * @author ashrafhasan
 * @since 10/13/16
 */
public class EmbebbedEntityProcessor implements DbCommandProcessor {

    Logger logger = LoggerFactory.getLogger(EmbebbedEntityProcessor.class);

    @Override
    public void process(EntityManager entityManager) {
        Person person = new Person("John Dow", 25);

        Address address = new Address("test", "1234");

        List<Phone> phoneList = Arrays.asList(new Phone(123, 123), new Phone(124, 124), new Phone(125, 125));
        List<String> nickNames = Arrays.asList("Jo", "Reo", "John");

        person.setAddress(address);

        person.setPhoneList(phoneList);
        person.setNickNames(nickNames);

        entityManager.persist(person);

        logger.debug("============================ Running Create queries ==========================");
        entityManager.flush();
        logger.debug("============================ Ending Create queries ============================");
        long id = person.getId();
        logger.debug("Person : {}", person);
        entityManager.detach(person); // should not be used in real application

        person = entityManager.find(Person.class, id);
        Phone phone = person.getPhoneList().get(0);
        phone.setArea(121);
        phone.setExtension(121);

        person.getNickNames().set(1, "Adam");

        logger.debug("============================ Running Update queries ============================");
        entityManager.flush();
        logger.debug("============================ Ending Update queries ============================");
        logger.debug("Person : {}", person);
        entityManager.detach(person); // should not be used in real application

        person = entityManager.find(Person.class, id);

        person.getPhoneList().remove(1);
        person.getNickNames().remove(1);

        logger.debug("============================ Running Delete queries ============================");
        entityManager.flush();
        logger.debug("============================ Ending Delete queries ============================");
        logger.debug("Person : {}", person);

        /*
            SELECT * FROM table_person;
            SELECT * FROM person_phone_list;
            SELECT * FROM person_nick_names;
        * */
    }
}
