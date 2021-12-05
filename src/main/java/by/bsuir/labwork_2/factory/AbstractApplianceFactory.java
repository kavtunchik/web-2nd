package by.bsuir.labwork_2.factory;

import by.bsuir.labwork_2.entity.Appliance;
import by.bsuir.labwork_2.factory.impl.LaptopFactory;
import by.bsuir.labwork_2.factory.impl.RefrigeratorFactory;
import by.bsuir.labwork_2.factory.impl.TeapotFactory;
import by.bsuir.labwork_2.factory.impl.VacuumCleanerFactory;
import org.w3c.dom.NodeList;

/**
 * Abstract factory for all {@link Appliance}
 */

public abstract class AbstractApplianceFactory {

    /**
     * Create new appliance
     *
     * @param nodeList the node list
     * @return new appliance
     */

    public abstract Appliance createAppliance(NodeList nodeList);

    /**
     * Gets appliance factory by appliance name.
     *
     * @param applianceName name of appliance
     * @return factory of new appliance
     */

    public static AbstractApplianceFactory getFactory(String applianceName) {
        return switch (applianceName) {
            case "refrigerator" -> new RefrigeratorFactory();
            case "laptop" -> new LaptopFactory();
            case "teapot" -> new TeapotFactory();
            case "vacuumCleaner" -> new VacuumCleanerFactory();
            default -> throw new IllegalArgumentException("No such appliance creator exists");
        };
    }
}
