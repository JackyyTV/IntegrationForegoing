package jackydev.integrationforegoing.handler.laserdrill;

import jackydev.integrationforegoing.util.ModUtils;

public class LaserDrillHandlerThermalFoundation {

    public static void init() {
        ModUtils.addCustomLaserDrillEntryBlock(3, "thermalfoundation", "ore", 1, 8, 1);
        ModUtils.addCustomLaserDrillEntryBlock(15, "thermalfoundation", "ore_fluid", 1, 0, 2);
        ModUtils.addCustomLaserDrillEntryBlock(15, "thermalfoundation", "ore_fluid", 1, 1, 2);
        ModUtils.addCustomLaserDrillEntryBlock(14, "thermalfoundation", "ore_fluid", 1, 2, 3);
        ModUtils.addCustomLaserDrillEntryBlock(4, "thermalfoundation", "ore_fluid", 1, 3, 2);
        ModUtils.addCustomLaserDrillEntryBlock(13, "thermalfoundation", "ore_fluid", 1, 4, 1);
    }

}
