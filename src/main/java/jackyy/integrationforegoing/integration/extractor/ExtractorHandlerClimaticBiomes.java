package jackyy.integrationforegoing.integration.extractor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class ExtractorHandlerClimaticBiomes {

    public static void init() {
        ModUtils.registerTreeFluidExtractorEntry(ModNames.CLIMATICBIOMES, "pine_log", 1);
    }

}
