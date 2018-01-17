package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerNatura {

    public static void init() {
        ModUtils.addCustomBioReactorEntryItem(ModNames.NATURA, "overworld_seeds", 1, 0);
        ModUtils.addCustomBioReactorEntryItem(ModNames.NATURA, "overworld_seeds", 1, 1);
    }

}
