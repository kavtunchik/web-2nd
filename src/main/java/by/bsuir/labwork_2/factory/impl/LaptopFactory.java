package by.bsuir.labwork_2.factory.impl;

import by.bsuir.labwork_2.entity.Appliance;
import by.bsuir.labwork_2.entity.Laptop;
import by.bsuir.labwork_2.entity.criteria.SearchCriteria;
import by.bsuir.labwork_2.factory.AbstractApplianceFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Laptop factory
 */

public class LaptopFactory extends AbstractApplianceFactory {
    @Override
    public Appliance createAppliance(NodeList nodeList) {
        Laptop.LaptopBuilder laptopBuilder = Laptop.builder();
        for (int i = 0; i < nodeList.getLength(); i++) {

            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String xmlValue = nodeList.item(i).getTextContent();

                SearchCriteria.LaptopCriteria laptopCriteria = SearchCriteria
                        .LaptopCriteria
                        .valueOf(nodeList.item(i).getNodeName().toUpperCase());

                switch (laptopCriteria) {
                    case BATTERY_CAPACITY -> laptopBuilder.withBatteryCapacity(Integer.parseInt(xmlValue));
                    case OPERATING_SYSTEM -> laptopBuilder.withOperatingSystem(xmlValue);
                    case RAM -> laptopBuilder.withRam(Integer.parseInt(xmlValue));
                    case SYSTEM_MEMORY -> laptopBuilder.withSystemMemory(Integer.parseInt(xmlValue));
                    case COST -> laptopBuilder.withCost(Integer.parseInt(xmlValue));
                }
            }
        }
        return laptopBuilder.build();
    }
}
