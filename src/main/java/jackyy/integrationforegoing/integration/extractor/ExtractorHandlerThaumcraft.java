package jackyy.integrationforegoing.integration.extractor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class ExtractorHandlerThaumcraft {

    public static void init() {
        ModUtils.registerTreeFluidExtractorEntry(ModNames.THAUMCRAFT, "log_greatwood", 1);
        ModUtils.registerTreeFluidExtractorEntry(ModNames.THAUMCRAFT, "log_silverwood", 1);
    }

}
