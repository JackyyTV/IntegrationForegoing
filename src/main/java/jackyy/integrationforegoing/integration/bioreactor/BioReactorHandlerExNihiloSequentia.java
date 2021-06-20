package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerExNihiloSequentia {

    public static void init() {
        ModUtils.registerBioReactorEntry(ModNames.EXNIHILOSEQUENTIA, "grass_seeds", 1);
        ModUtils.registerBioReactorEntry(ModNames.EXNIHILOSEQUENTIA, "ancient_spores", 1);
    }

}
