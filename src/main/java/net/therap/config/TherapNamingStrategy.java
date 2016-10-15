package net.therap.config;

import org.hibernate.cfg.ImprovedNamingStrategy;

/**
 * @author ashrafhasan
 * @since 10/11/16
 */
public class TherapNamingStrategy extends ImprovedNamingStrategy {
    @Override
    public String foreignKeyColumnName(String propertyName,
                                       String propertyEntityName, String propertyTableName,
                                       String referencedColumnName) {
        return super.foreignKeyColumnName(propertyName, propertyEntityName, propertyTableName,
                referencedColumnName) + "_id";
    }

}
