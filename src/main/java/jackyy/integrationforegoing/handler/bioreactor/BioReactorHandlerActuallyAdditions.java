package jackyy.integrationforegoing.handler.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerActuallyAdditions {

    public static void init() {
        ModUtils.addCustomBioReactorEntryItem(ModNames.AA, "item_rice_seed", 1, 0);
        ModUtils.addCustomBioReactorEntryItem(ModNames.AA, "item_canola_seed", 1, 0);
        ModUtils.addCustomBioReactorEntryItem(ModNames.AA, "item_flax_seed", 1, 0);
        ModUtils.addCustomBioReactorEntryItem(ModNames.AA, "item_coffee_seed", 1, 0);
    }

}
