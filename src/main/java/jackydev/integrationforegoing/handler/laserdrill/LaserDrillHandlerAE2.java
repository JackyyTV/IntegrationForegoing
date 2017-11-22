package jackydev.integrationforegoing.handler.laserdrill;

import jackydev.integrationforegoing.util.ModUtils;

public class LaserDrillHandlerAE2 {

    public static void init() {
        ModUtils.addCustomLaserDrillEntryBlock(8, "appliedenergistics2", "quartz_ore", 1, 0, 2);
        ModUtils.addCustomLaserDrillEntryBlock(8, "appliedenergistics2", "charged_quartz_ore", 1, 0, 1);
    }

}
