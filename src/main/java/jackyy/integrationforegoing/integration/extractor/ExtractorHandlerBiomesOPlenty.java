package jackyy.integrationforegoing.integration.extractor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class ExtractorHandlerBiomesOPlenty {

    public static void init() {
        for (int i = 4; i <= 7; i++) {
            ModUtils.registerTreeFluidExtractorEntry(ModNames.BIOMESOP, "log_0", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.BIOMESOP, "log_1", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.BIOMESOP, "log_2", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.BIOMESOP, "log_3", 1, i, 1);
        }
        ModUtils.registerTreeFluidExtractorEntry(ModNames.BIOMESOP, "log_4", 1, 4, 1);
        ModUtils.registerTreeFluidExtractorEntry(ModNames.BIOMESOP, "log_4", 1, 5, 1);
    }

}
