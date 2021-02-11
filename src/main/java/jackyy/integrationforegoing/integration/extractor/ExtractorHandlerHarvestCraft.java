package jackyy.integrationforegoing.integration.extractor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class ExtractorHandlerHarvestCraft {

    public static void init() {
        ModUtils.registerTreeFluidExtractorEntry(ModNames.HARVESTCRAFT, "pamcinnamon", 1);
        ModUtils.registerTreeFluidExtractorEntry(ModNames.HARVESTCRAFT, "pammaple", 1);
        ModUtils.registerTreeFluidExtractorEntry(ModNames.HARVESTCRAFT, "pampaperbark", 1);
    }

}
