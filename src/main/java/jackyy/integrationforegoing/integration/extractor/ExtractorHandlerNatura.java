package jackyy.integrationforegoing.integration.extractor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class ExtractorHandlerNatura {

    public static void init() {
        for (int i = 0; i <= 3; i++) {
            ModUtils.registerTreeFluidExtractorEntry(ModNames.NATURA, "overworld_logs", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.NATURA, "overworld_logs2", 1, i, 1);
        }
        for (int i = 0; i <= 2; i++) {
            ModUtils.registerTreeFluidExtractorEntry(ModNames.NATURA, "redwood_logs", 1, i, 1);
            ModUtils.registerTreeFluidExtractorEntry(ModNames.NATURA, "nether_logs", 1, i, 1);
        }
        ModUtils.registerTreeFluidExtractorEntry(ModNames.NATURA, "nether_logs2", 1, 0, 1);
        ModUtils.registerTreeFluidExtractorEntry(ModNames.NATURA, "nether_logs2", 1, 15, 1);
    }

}
