package by.bsuir.labwork_2.entity.criteria;

/**
 * All criteria
 */

public final class SearchCriteria {
    private SearchCriteria() {
    }

    /**
     * Laptop criteria
     */

    public enum LaptopCriteria {
        COST,
        BATTERY_CAPACITY,
        OPERATING_SYSTEM,
        RAM,
        SYSTEM_MEMORY;
    }

    /**
     * Refrigerator criteria
     */

    public enum RefrigeratorCriteria {
        COST,
        OVERALL_CAPACITY,
        WEIGHT,
        HEIGHT,
        WIDTH
    }

    /**
     * Teapot criteria
     */

    public enum TeapotCriteria {
        COST,
        POWER_CONSUMPTION,
        VOLUME,
        MATERIAL
    }

    /**
     * Vacuum cleaner criteria
     */

    public enum VacuumCleanerCriteria {
        COST,
        POWER_CONSUMPTION,
        MATERIAL,
        WEIGHT
    }
}
