package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerNatura {

    public static void init() {
        ModUtils.addCustomBioReactorEntryItem(ModNames.NATURA, "overworld_seeds", 1, 0);
        ModUtils.addCustomBioReactorEntryItem(ModNames.NATURA, "overworld_seeds", 1, 1);
        for (int i = 0; i <= 3; i++) {
            ModUtils.addCustomBioReactorEntryItem(ModNames.NATURA, "overworld_sapling", 1, i);
            ModUtils.addCustomBioReactorEntryItem(ModNames.NATURA, "overworld_sapling2", 1, i);
        }
        ModUtils.addCustomBioReactorEntryItem(ModNames.NATURA, "redwood_sapling", 1, 0);
        ModUtils.addCustomBioReactorEntryItem(ModNames.NATURA, "nether_sapling", 1, 0);
        ModUtils.addCustomBioReactorEntryItem(ModNames.NATURA, "nether_sapling", 1, 1);
        ModUtils.addCustomBioReactorEntryItem(ModNames.NATURA, "nether_sapling", 1, 2);
        ModUtils.addCustomBioReactorEntryItem(ModNames.NATURA, "nether_sapling2", 1, 0);
    }

}
