package by.bsuir.labwork_2.entity;

import by.bsuir.labwork_2.entity.criteria.SearchCriteria;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Refrigerator appliance
 */

@Getter
@ToString(callSuper = true)
public class Refrigerator extends Appliance{

    private final int overallCapacity;
    private final int weight;
    private final int height;
    private final int width;

    /**
     * Constructor for new refrigerator
     *
     * @param cost cost of new refrigerator
     * @param overallCapacity overall capacity of new refrigerator
     * @param weight weight of new refrigerator
     * @param height height of new refrigerator
     * @param width width of new refrigerator
     */

    @Builder(setterPrefix = "with")
    public Refrigerator(int cost, int overallCapacity, int weight, int height, int width) {
        super(cost);
        this.overallCapacity = overallCapacity;
        this.weight = weight;
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean isApplianceMatchedCriteria(String criteriaField, Object value) {
        SearchCriteria.RefrigeratorCriteria refrigeratorCriteria = SearchCriteria.RefrigeratorCriteria.valueOf(criteriaField);

        return switch (refrigeratorCriteria) {
            case WEIGHT -> (int) value == weight;
            case HEIGHT -> (int) value == height;
            case WIDTH -> (int) value == width;
            case OVERALL_CAPACITY -> (int) value == overallCapacity;
            case COST -> (int) value == cost;
        };
    }
}
