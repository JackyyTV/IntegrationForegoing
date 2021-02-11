package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerThaumcraft {

    public static void init() {
        ModUtils.registerBioReactorEntry(ModNames.THAUMCRAFT, "sapling_greatwood", 1, 0);
        ModUtils.registerBioReactorEntry(ModNames.THAUMCRAFT, "sapling_silverwood", 1, 0);

        ModUtils.registerBioReactorEntry(ModNames.THAUMCRAFT, "shimmerleaf", 1, 0);
        ModUtils.registerBioReactorEntry(ModNames.THAUMCRAFT, "cinderpearl", 1, 0);
        ModUtils.registerBioReactorEntry(ModNames.THAUMCRAFT, "vishroom", 1, 0);
    }

}
