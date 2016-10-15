package net.therap;

import net.therap.config.PersistenceManager;
import net.therap.processor.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ashrafhasan
 * @since 10/10/16
 */
public class Main {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.debug("\n\n\n\n\n\n\n\n\n\n");
        logger.debug("==============================" + "Start of Execution" + "=================================");

        PersistenceManager manager = new PersistenceManager();
//        manager.execute(new ManyToOneUniProcessor());
//        manager.execute(new OneToManyUniJoinColumnProcessor());
//        manager.execute(new OneToManyUniJoinTableProcessor());
//        manager.execute(new OneToManyBiProcessor());
//        manager.execute(new InvalidOneToManyProcessor());
        manager.close();

        logger.debug("==============================" + "End of Execution" + "=================================");
    }
}
