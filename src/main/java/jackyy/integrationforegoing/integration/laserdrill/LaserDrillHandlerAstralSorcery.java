package jackyy.integrationforegoing.integration.laserdrill;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class LaserDrillHandlerAstralSorcery {

    public static void init() {
        ModUtils.addCustomLaserDrillEntryBlock(0, ModNames.AS, "blockcustomore", 1, 0, 1);
        ModUtils.addCustomLaserDrillEntryBlock(11, ModNames.AS, "blockcustomore", 1, 1, 1);
        ModUtils.addCustomLaserDrillEntryBlock(3, ModNames.AS, "blockcustomsandore", 1, 0, 2);
    }

}
