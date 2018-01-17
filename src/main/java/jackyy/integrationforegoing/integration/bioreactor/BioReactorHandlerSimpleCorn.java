package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerSimpleCorn {

    public static void init() {
        ModUtils.addCustomBioReactorEntryItem(ModNames.SIMPLECORN, "kernels", 1, 0);
    }

}
