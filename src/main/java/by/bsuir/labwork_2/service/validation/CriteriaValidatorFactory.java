package by.bsuir.labwork_2.service.validation;

import by.bsuir.labwork_2.entity.Material;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * The Criteria validator factory.
 */

public class CriteriaValidatorFactory {

    private final static CriteriaValidatorFactory instance = new CriteriaValidatorFactory();
    private final Map<String, CriteriaValidator> validators = new HashMap<>();

    private final String NUMBER_VALIDATOR_NAME = "number";
    private final String STRING_VALIDATOR_NAME = "string";
    private final String MATERIAL_VALIDATOR_NAME = "material";

    {
        validators.put(NUMBER_VALIDATOR_NAME, value -> (int) value > 0);
        validators.put(STRING_VALIDATOR_NAME, value -> StringUtils.isNotEmpty((String) value));
        validators.put(MATERIAL_VALIDATOR_NAME, value -> {
            try {
                Material.valueOf((String) value);
                return true;
            } catch (ClassCastException | IllegalArgumentException e) {
                return false;
            }
        });
    }

    private CriteriaValidatorFactory() {
    }

    /**
     * Gets instance
     *
     * @return instance
     */
    public static CriteriaValidatorFactory getInstance() {
        return instance;
    }

    /**
     * Gets validator
     *
     * @param criteriaName name of criteria
     * @return validator
     */
    public CriteriaValidator getValidator(String criteriaName) {
        return switch (criteriaName) {
            case "os" -> validators.get(STRING_VALIDATOR_NAME);
            case "material" -> validators.get(MATERIAL_VALIDATOR_NAME);
            default -> validators.get(NUMBER_VALIDATOR_NAME);
        };
    }
}
