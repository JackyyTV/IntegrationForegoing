package jackyy.integrationforegoing.handler.laserdrill;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class LaserDrillHandlerAE2 {

    public static void init() {
        ModUtils.addCustomLaserDrillEntryBlock(8, ModNames.AE2, "quartz_ore", 1, 0, 2);
        ModUtils.addCustomLaserDrillEntryBlock(8, ModNames.AE2, "charged_quartz_ore", 1, 0, 1);
    }

}
