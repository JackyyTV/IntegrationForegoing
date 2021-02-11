package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerRandomThings {

    public static void init() {
        for (int i = 0; i <= 2; i++) {
            ModUtils.registerBioReactorEntry(ModNames.RANDOMTHINGS, "beans", 1, i);
        }
        for (int i = 0; i <= 16; i++) {
            ModUtils.registerBioReactorEntry(ModNames.RANDOMTHINGS, "grassseeds", 1, i);
        }
        ModUtils.registerBioReactorEntry(ModNames.RANDOMTHINGS, "lotusseeds", 1, 0);
        ModUtils.registerBioReactorEntry(ModNames.RANDOMTHINGS, "glowingmushroom", 1, 0);
        ModUtils.registerBioReactorEntry(ModNames.RANDOMTHINGS, "spectresapling", 1, 0);
    }

}
