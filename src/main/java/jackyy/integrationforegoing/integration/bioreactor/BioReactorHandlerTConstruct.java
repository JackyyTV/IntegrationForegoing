package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerTConstruct {

    public static void init() {
        ModUtils.addCustomBioReactorEntryItem(ModNames.TCON, "slime_sapling", 1, 0);
        ModUtils.addCustomBioReactorEntryItem(ModNames.TCON, "slime_sapling", 1, 1);
        ModUtils.addCustomBioReactorEntryItem(ModNames.TCON, "slime_sapling", 1, 2);
    }

}
