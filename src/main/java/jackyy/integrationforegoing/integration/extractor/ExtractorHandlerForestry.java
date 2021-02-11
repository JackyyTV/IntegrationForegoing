package jackyy.integrationforegoing.integration.extractor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class ExtractorHandlerForestry {

    public static void init() {
        for (int i = 0; i <= 3; i++) {
            ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "logs.0", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "logs.1", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "logs.2", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "logs.3", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "logs.4", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "logs.5", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "logs.6", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "logs.fireproof.0", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "logs.fireproof.1", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "logs.fireproof.2", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "logs.fireproof.3", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "logs.fireproof.4", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "logs.fireproof.5", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "logs.fireproof.6", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "logs.vanilla.fireproof.0", 1, i, 1);
        }
        ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "log.7", 1, 0, 1);
        ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "log.fireproof.7", 1, 0, 1);
        ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "logs.vanilla.fireproof.1", 1, 0, 1);
        ModUtils.registerTreeFluidExtractorEntry(ModNames.FORESTRY, "logs.vanilla.fireproof.1", 1, 1, 1);
    }

}
