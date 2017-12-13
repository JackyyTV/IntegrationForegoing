package jackyy.integrationforegoing.handler.laserdrill;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class LaserDrillHandlerMysticalAgriculture {

    public static void init() {
        ModUtils.addCustomLaserDrillEntryBlock(4, ModNames.MAG, "inferium_ore", 1, 0, 4);
        ModUtils.addCustomLaserDrillEntryBlock(3, ModNames.MAG, "prosperity_ore", 1, 0, 4);
    }

}
