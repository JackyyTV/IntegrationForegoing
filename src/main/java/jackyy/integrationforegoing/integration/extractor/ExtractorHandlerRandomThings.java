package jackyy.integrationforegoing.integration.extractor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class ExtractorHandlerRandomThings {

    public static void init() {
        ModUtils.registerTreeFluidExtractorEntry(ModNames.RANDOMTHINGS, "spectrelog", 1);
    }

}
