package by.bsuir.labwork_2.dao;

import by.bsuir.labwork_2.entity.Appliance;
import by.bsuir.labwork_2.entity.criteria.ApplianceCriteria;

/**
 * The interface of Appliance dao classes
 */

public interface ApplianceDao {

    /**
     * Finds all the all appliances with given criteria.
     *
     * @param applianceCriteria search criteria
     * @return all matched appliance
     */
    Appliance[] find(ApplianceCriteria applianceCriteria);
}
