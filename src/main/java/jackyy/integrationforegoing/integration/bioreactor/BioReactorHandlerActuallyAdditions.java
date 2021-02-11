package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerActuallyAdditions {

    private static final String[] SEEDS = new String[] {
            "rice", "canola", "flax", "coffee"
    };

    public static void init() {
        for (String seed : SEEDS) {
            ModUtils.registerBioReactorEntry(ModNames.AA, "item_" + seed + "_seed", 1, 0);
        }
    }

}
