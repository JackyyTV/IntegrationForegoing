package jackyy.integrationforegoing.handler.laserdrill;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class LaserDrillHandlerThermalFoundation {

    public static void init() {
        ModUtils.addCustomLaserDrillEntryBlock(3, ModNames.TF, "ore", 1, 8, 1);
        ModUtils.addCustomLaserDrillEntryBlock(15, ModNames.TF, "ore_fluid", 1, 0, 2);
        ModUtils.addCustomLaserDrillEntryBlock(15, ModNames.TF, "ore_fluid", 1, 1, 2);
        ModUtils.addCustomLaserDrillEntryBlock(14, ModNames.TF, "ore_fluid", 1, 2, 3);
        ModUtils.addCustomLaserDrillEntryBlock(4, ModNames.TF, "ore_fluid", 1, 3, 2);
        ModUtils.addCustomLaserDrillEntryBlock(13, ModNames.TF, "ore_fluid", 1, 4, 1);
    }

}
