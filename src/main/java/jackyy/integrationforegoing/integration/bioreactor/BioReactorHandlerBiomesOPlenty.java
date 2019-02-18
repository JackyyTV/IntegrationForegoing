package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerBiomesOPlenty {

    public static void init() {
        for (int i = 0; i <= 7; i++) {
            ModUtils.registerBioReactorEntry(ModNames.BIOMESOP, "sapling_0", 1, i);
            ModUtils.registerBioReactorEntry(ModNames.BIOMESOP, "sapling_1", 1, i);
            ModUtils.registerBioReactorEntry(ModNames.BIOMESOP, "sapling_2", 1, i);
        }
    }

}
