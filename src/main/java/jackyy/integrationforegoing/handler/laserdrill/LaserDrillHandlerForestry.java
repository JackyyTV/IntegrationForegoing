package jackyy.integrationforegoing.handler.laserdrill;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class LaserDrillHandlerForestry {

    public static void init() {
        ModUtils.addCustomLaserDrillEntryBlock(3, ModNames.FORESTRY, "resources", 1, 0, 6);
    }

}
