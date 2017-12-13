package jackyy.integrationforegoing.handler.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerEvilCraft {

    public static void init() {
        ModUtils.addCustomBioReactorEntryItem(ModNames.EVILCRAFT, "undead_sapling", 1, 0);
    }

}
