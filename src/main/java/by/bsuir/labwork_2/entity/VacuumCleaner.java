package by.bsuir.labwork_2.entity;

import by.bsuir.labwork_2.entity.criteria.SearchCriteria;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Vacuum cleaner appliance
 */

@Getter
@ToString(callSuper = true)
public class VacuumCleaner extends Appliance{

    private final int powerConsumption;
    private final Material bodyMaterial;
    private final int weight;

    /**
     * Constructor for new vacuum cleaner
     *
     * @param cost cost of new vacuum cleaner
     * @param powerConsumption power consumption of new vacuum cleaner
     * @param material body material of new vacuum cleaner
     * @param weight weight of new vacuum cleaner
     */

    @Builder(setterPrefix = "with")
    public VacuumCleaner(int cost, int powerConsumption, Material material, int weight) {
        super(cost);
        this.powerConsumption = powerConsumption;
        this.bodyMaterial = material;
        this.weight = weight;
    }

    @Override
    public boolean isApplianceMatchedCriteria(String criteriaField, Object value) {
        SearchCriteria.VacuumCleanerCriteria vacuumCleanerCriteria = SearchCriteria.VacuumCleanerCriteria.valueOf(criteriaField);

        return switch (vacuumCleanerCriteria) {
            case POWER_CONSUMPTION -> (int) value == powerConsumption;
            case MATERIAL -> bodyMaterial.equals(Material.valueOf((String) value));
            case WEIGHT -> (int) value == weight;
            case COST -> (int) value == cost;
        };
    }
}
