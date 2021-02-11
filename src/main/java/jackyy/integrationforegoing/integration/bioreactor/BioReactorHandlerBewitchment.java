package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerBewitchment {

    private static final String[] SEEDS = new String[] {
            "aconitum", "belladonna", "garlic", "hellebore", "mandrake",
            "white_sage", "wormwood"
    };
    private static final String[] SAPLINGS = new String[] {
            "cypress", "elder", "juniper", "dragons_blood"
    };

    public static void init() {
        for (String seed : SEEDS) {
            ModUtils.registerBioReactorEntry(ModNames.BEWITCHMENT, seed + "_seeds", 1, 0);
        }
        for (String sapling : SAPLINGS) {
            ModUtils.registerBioReactorEntry(ModNames.BEWITCHMENT, sapling + "_sapling", 1, 0);
        }
    }

}
