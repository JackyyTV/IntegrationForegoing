package jackyy.integrationforegoing.handler.laserdrill;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class LaserDrillHandlerEvilCraft {

    public static void init() {
        ModUtils.addCustomLaserDrillEntryBlock(15, ModNames.EVILCRAFT, "dark_ore", 1, 0, 2);
    }

}
