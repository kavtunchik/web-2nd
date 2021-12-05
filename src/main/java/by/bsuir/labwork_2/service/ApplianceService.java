package by.bsuir.labwork_2.service;

import by.bsuir.labwork_2.entity.Appliance;
import by.bsuir.labwork_2.entity.criteria.ApplianceCriteria;

/**
 * The interface of appliance service.
 */

public interface ApplianceService {

    /**
     * Find all appliances that matched criteria.
     *
     * @param applianceCriteria criteria of appliance
     * @return all matched appliances
     */
    Appliance[] findByCriteria(ApplianceCriteria applianceCriteria);
}
