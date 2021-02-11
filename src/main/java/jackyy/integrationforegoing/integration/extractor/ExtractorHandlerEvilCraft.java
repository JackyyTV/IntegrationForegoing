package jackyy.integrationforegoing.integration.extractor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class ExtractorHandlerEvilCraft {

    public static void init() {
        ModUtils.registerTreeFluidExtractorEntry(ModNames.EVILCRAFT, "undead_log", 1);
    }

}
