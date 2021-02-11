package jackyy.integrationforegoing.integration.extractor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class ExtractorHandlerBewitchment {

    public static void init() {
        ModUtils.registerTreeFluidExtractorEntry(ModNames.BEWITCHMENT, "cypress_wood", 1);
        ModUtils.registerTreeFluidExtractorEntry(ModNames.BEWITCHMENT, "elder_wood", 1);
        ModUtils.registerTreeFluidExtractorEntry(ModNames.BEWITCHMENT, "juniper_wood", 1);
        ModUtils.registerTreeFluidExtractorEntry(ModNames.BEWITCHMENT, "dragons_blood_wood", 1);
    }

}
