package jackyy.integrationforegoing.integration.laserdrill;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class LaserDrillHandlerRFTools {

    public static void init() {
        ModUtils.addCustomLaserDrillEntryBlock(0, ModNames.RFTOOLS, "dimensional_shard_ore", 1, 0, 1);
        ModUtils.addCustomLaserDrillEntryBlock(0, ModNames.RFTOOLS, "dimensional_shard_ore", 1, 1, 1);
        ModUtils.addCustomLaserDrillEntryBlock(0, ModNames.RFTOOLS, "dimensional_shard_ore", 1, 2, 1);
    }

}
