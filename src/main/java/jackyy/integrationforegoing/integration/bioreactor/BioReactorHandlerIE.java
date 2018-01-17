package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerIE {

    public static void init() {
        ModUtils.addCustomBioReactorEntryItem(ModNames.IE, "seed", 1, 0);
    }

}
