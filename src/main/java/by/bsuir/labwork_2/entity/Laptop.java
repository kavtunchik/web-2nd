package by.bsuir.labwork_2.entity;

import by.bsuir.labwork_2.entity.criteria.SearchCriteria;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Laptop appliance
 */

@Getter
@ToString(callSuper = true)
public class Laptop extends Appliance{

    private final int batteryCapacity;
    private final String operatingSystem;
    private final int ram;
    private final int systemMemory;

    /**
     * Constructor for new laptop
     *
     * @param cost cost of new laptop
     * @param batteryCapacity battery capacity of new laptop
     * @param operatingSystem operating system of new laptop
     * @param ram ram of new laptop
     * @param systemMemory system memory of new laptop
     */

    @Builder(setterPrefix = "with")
    public Laptop(int cost, int batteryCapacity, String operatingSystem, int ram, int systemMemory) {
        super(cost);
        this.batteryCapacity = batteryCapacity;
        this.operatingSystem = operatingSystem;
        this.ram = ram;
        this.systemMemory = systemMemory;
    }

    @Override
    public boolean isApplianceMatchedCriteria(String criteriaField, Object value) {
        SearchCriteria.LaptopCriteria laptopCriteria = SearchCriteria.LaptopCriteria.valueOf(criteriaField);

        return switch (laptopCriteria) {
            case RAM -> ram == (int) value;
            case BATTERY_CAPACITY -> batteryCapacity == (int) value;
            case OPERATING_SYSTEM -> operatingSystem.equals(value);
            case SYSTEM_MEMORY -> systemMemory == (int) value;
            case COST -> (int) value == cost;
        };
    }
}
