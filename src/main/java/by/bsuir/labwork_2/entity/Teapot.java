package by.bsuir.labwork_2.entity;

import by.bsuir.labwork_2.entity.criteria.SearchCriteria;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Teapot appliance
 */

@Getter
@ToString(callSuper = true)
public class Teapot extends Appliance{

    private final int powerConsumption;
    private final int volume;
    private final Material material;

    /**
     * Constructor for new teapot
     *
     * @param cost cost of new teapot
     * @param powerConsumption power consumption of new teapot
     * @param volume volume of new teapot
     * @param material material of new teapot
     */

    @Builder(setterPrefix = "with")
    public Teapot(int cost, int powerConsumption, int volume, Material material) {
        super(cost);
        this.powerConsumption = powerConsumption;
        this.volume = volume;
        this.material = material;
    }

    @Override
    public boolean isApplianceMatchedCriteria(String criteriaField, Object value) {
        SearchCriteria.TeapotCriteria teapotCriteria = SearchCriteria.TeapotCriteria.valueOf(criteriaField);

        return switch (teapotCriteria) {
            case POWER_CONSUMPTION -> (int) value == powerConsumption;
            case VOLUME -> (int) value == volume;
            case MATERIAL -> material.equals(Material.valueOf((String) value));
            case COST -> (int) value == cost;
        };
    }
}
