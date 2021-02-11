package jackyy.integrationforegoing.integration.extractor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class ExtractorHandlerRustic {

    public static void init() {
        ModUtils.registerTreeFluidExtractorEntry(ModNames.RUSTIC, "log", 1, 0, 1);
        ModUtils.registerTreeFluidExtractorEntry(ModNames.RUSTIC, "log", 1, 1, 1);
    }

}
