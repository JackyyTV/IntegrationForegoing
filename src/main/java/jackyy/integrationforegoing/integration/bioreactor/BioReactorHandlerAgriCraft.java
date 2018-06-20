package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerAgriCraft {

    public static void init() {
        ModUtils.addCustomBioReactorEntryItem(ModNames.AGRICRAFT, "agri_seed", 1, 0);
    }

}
