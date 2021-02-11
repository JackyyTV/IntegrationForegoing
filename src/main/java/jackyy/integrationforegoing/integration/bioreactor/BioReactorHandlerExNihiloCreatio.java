package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerExNihiloCreatio {

    private static final String[] SEEDS = new String[] {
            "oak", "spruce", "birch", "jungle", "acacia",
            "darkoak", "cactus", "sugarcane", "carrot", "potato"
    };

    public static void init() {
        for (String seed : SEEDS) {
            ModUtils.registerBioReactorEntry(ModNames.EXNIHILOCREATIO, "item_seed_" + seed, 1, 0);
        }
        ModUtils.registerBioReactorEntry(ModNames.EXNIHILOCREATIO, "item_material", 1, 3);
        ModUtils.registerBioReactorEntry(ModNames.EXNIHILOCREATIO, "item_material", 1, 4);
    }

}
