package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerMysticalAgradditions {

    public static void init() {
        ModUtils.registerBioReactorEntry(ModNames.MAD, "insanium", 1, 1);
        ModUtils.registerBioReactorEntry(ModNames.MAD, "tier6_inferium_seeds", 1, 0);
        ModUtils.registerBioReactorEntry(ModNames.MAD, "nether_star_seeds", 1, 0);
        ModUtils.registerBioReactorEntry(ModNames.MAD, "awakened_draconium_seeds", 1, 0);
    }

}
