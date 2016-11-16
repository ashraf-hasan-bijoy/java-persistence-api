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
        logger.debug("\n\n\n\n");
        logger.debug("==============================" + "Start of Execution" + "=================================");

        PersistenceManager manager = new PersistenceManager();

        ProcessFindAction processFindAction = new ProcessFindAction();
//        processFindAction.findForDataAccess(manager.getEmFactory());
//        processFindAction.findForRelation(manager.getEmFactory());
//        processFindAction.invalidAccessLazilyAssociatedEntity(manager.getEmFactory());

        ProcessInsertAction processInsertAction = new ProcessInsertAction();
//        processInsertAction.simpleInsert(manager.getEmFactory());
//        processInsertAction.insertWithAssociatedDetachedEntity(manager.getEmFactory());
//        processInsertAction.invalidInsertWithAssociatedDetachedEntity(manager.getEmFactory());

//        ProcessUpdateAction processUpdateAction = new ProcessUpdateAction();
//        processUpdateAction.updateManagedEntity(manager.getEmFactory());
//        processUpdateAction.updateDetachedEntity(manager.getEmFactory());
//        processUpdateAction.invalidMerge(manager.getEmFactory());

        ProcessDeleteAction processDeleteAction = new ProcessDeleteAction();
//        processDeleteAction.deleteManagedEntity(manager.getEmFactory());
//        processDeleteAction.deleteDetachedEntity(manager.getEmFactory());
//        processDeleteAction.invalidDeleteForDetachedEntity(manager.getEmFactory());
//        processDeleteAction.invalidChildDeleteWithParentExists(manager.getEmFactory());

        ProcessDbFlush processDbFlush = new ProcessDbFlush();
//        processDbFlush.flushWithTransactionCommit(manager.getEmFactory());
//        processDbFlush.flushWithMethodCall(manager.getEmFactory());
        manager.close();

        logger.debug("==============================" + "End of Execution" + "=================================");
    }
}
