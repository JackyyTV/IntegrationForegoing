package jackyy.integrationforegoing.handler.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerMysticalAgradditions {

    public static void init() {
        ModUtils.addCustomBioReactorEntryItem(ModNames.MAD, "insanium", 1, 1);
        ModUtils.addCustomBioReactorEntryItem(ModNames.MAD, "tier6_inferium_seeds", 1, 0);
        ModUtils.addCustomBioReactorEntryItem(ModNames.MAD, "nether_star_seeds", 1, 0);
        ModUtils.addCustomBioReactorEntryItem(ModNames.MAD, "awakened_draconium_seeds", 1, 0);
    }

}
