package net.therap.processor;

import net.therap.domain.primaryKey.AllocationSizeOne;
import net.therap.domain.primaryKey.AllocationSizeThree;

import javax.persistence.EntityManager;

/**
 * @author ashrafhasan
 * @since 10/11/16
 */
public class PrimaryKeyProcessor implements DbCommandProcessor {

    @Override
    public void process(EntityManager entityManager) {
        AllocationSizeOne allocationSizeOne = new AllocationSizeOne("one");
        entityManager.persist(allocationSizeOne);
        allocationSizeOne = new AllocationSizeOne("two");
        entityManager.persist(allocationSizeOne);
        allocationSizeOne = new AllocationSizeOne("three");
        entityManager.persist(allocationSizeOne);

        //fetch sequence nextval(1) and multiply by 3 again. Then sequentially assign id for 3 times

        AllocationSizeThree allocationSizeThree = new AllocationSizeThree("three");
        entityManager.persist(allocationSizeThree);
        allocationSizeThree = new AllocationSizeThree("four");
        entityManager.persist(allocationSizeThree);
        allocationSizeThree = new AllocationSizeThree("five");
        entityManager.persist(allocationSizeThree);

        //fetch sequence nextval(2) and multiply by 3 again. Repeat same procedure.

        allocationSizeThree = new AllocationSizeThree("six");
        entityManager.persist(allocationSizeThree);
        allocationSizeThree = new AllocationSizeThree("seven");
        entityManager.persist(allocationSizeThree);
        allocationSizeThree = new AllocationSizeThree("eight");
        entityManager.persist(allocationSizeThree);

        /*
            SELECT * FROM table_allocation_size_one;
            SELECT alloc_size_one_sequence.nextval FROM dual;

            SELECT * FROM table_allocation_size_three;
            SELECT alloc_size_three_sequence.nextval FROM dual;
         */
    }
}
