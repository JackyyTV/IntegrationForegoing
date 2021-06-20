package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerMysticalAgradditions {

    private static final String[] SEEDS = new String[] {
            "nether_star", "dragon_egg", "nitro_crystal"
    };

    public static void init() {
        for (String seed : SEEDS) {
            ModUtils.registerBioReactorEntry(ModNames.MAG, seed + "_seeds", 1);
        }
    }

}
