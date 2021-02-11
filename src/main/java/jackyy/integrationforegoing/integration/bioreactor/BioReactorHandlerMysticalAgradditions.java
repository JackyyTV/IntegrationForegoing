package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerMysticalAgradditions {

    private static final String[] SEEDS = new String[] {
            "tier6_inferium", "nether_star", "dragon_egg", "awakened_draconium", "neutronium"
    };

    public static void init() {
        ModUtils.registerBioReactorEntry(ModNames.MAD, "insanium", 1, 1);
        for (String seed : SEEDS) {
            ModUtils.registerBioReactorEntry(ModNames.MAD, seed + "_seeds", 1, 0);
        }
    }

}
