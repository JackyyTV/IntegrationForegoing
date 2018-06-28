package jackyy.integrationforegoing.integration.laserdrill;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class LaserDrillHandlerBiomesOP {

    public static void init() {
        ModUtils.addCustomLaserDrillEntryBlock(0, ModNames.BIOMESOP, "biome_block", 1, 0, 1);
        ModUtils.addCustomLaserDrillEntryBlock(2, ModNames.BIOMESOP, "gem_ore", 1, 0, 1);
        ModUtils.addCustomLaserDrillEntryBlock(14, ModNames.BIOMESOP, "gem_ore", 1, 1, 2);
        ModUtils.addCustomLaserDrillEntryBlock(5, ModNames.BIOMESOP, "gem_ore", 1, 2, 2);
        ModUtils.addCustomLaserDrillEntryBlock(1, ModNames.BIOMESOP, "gem_ore", 1, 3, 1);
        ModUtils.addCustomLaserDrillEntryBlock(10, ModNames.BIOMESOP, "gem_ore", 1, 4, 1);
        ModUtils.addCustomLaserDrillEntryBlock(9, ModNames.BIOMESOP, "gem_ore", 1, 5, 1);
        ModUtils.addCustomLaserDrillEntryBlock(11, ModNames.BIOMESOP, "gem_ore", 1, 6, 2);
        ModUtils.addCustomLaserDrillEntryBlock(1, ModNames.BIOMESOP, "gem_ore", 1, 7, 1);
    }

}
