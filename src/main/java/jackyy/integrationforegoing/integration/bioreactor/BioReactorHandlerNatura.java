package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerNatura {

    public static void init() {
        ModUtils.registerBioReactorEntry(ModNames.NATURA, "overworld_seeds", 1, 0);
        ModUtils.registerBioReactorEntry(ModNames.NATURA, "overworld_seeds", 1, 1);
        for (int i = 0; i <= 3; i++) {
            ModUtils.registerBioReactorEntry(ModNames.NATURA, "overworld_sapling", 1, i);
            ModUtils.registerBioReactorEntry(ModNames.NATURA, "overworld_sapling2", 1, i);
        }
        ModUtils.registerBioReactorEntry(ModNames.NATURA, "redwood_sapling", 1, 0);
        ModUtils.registerBioReactorEntry(ModNames.NATURA, "nether_sapling", 1, 0);
        ModUtils.registerBioReactorEntry(ModNames.NATURA, "nether_sapling", 1, 1);
        ModUtils.registerBioReactorEntry(ModNames.NATURA, "nether_sapling", 1, 2);
        ModUtils.registerBioReactorEntry(ModNames.NATURA, "nether_sapling2", 1, 0);
    }

}
