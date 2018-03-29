package jackyy.integrationforegoing.integration.laserdrill;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class LaserDrillHandlerMatterOverdrive {

    public static void init() {
        ModUtils.addCustomLaserDrillEntryBlock(3, ModNames.MATTEROVERDRIVE, "dilithium_ore", 1, 0, 2);
        ModUtils.addCustomLaserDrillEntryBlock(7, ModNames.MATTEROVERDRIVE, "tritanium_ore", 1, 0, 2);
    }

}
