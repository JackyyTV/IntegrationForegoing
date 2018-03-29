package jackyy.integrationforegoing.integration.compat;

import blusunrize.immersiveengineering.api.tool.BelljarHandler;
import jackyy.integrationforegoing.util.ModConfig;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class IEGardenClocheCompat {

    public static void init() {
        if (ModConfig.misc.immersiveEngineering.gardenCloche.allowFertilizer) {
            BelljarHandler.registerBasicItemFertilizer(
                    ModUtils.getItemStackByName(ModNames.IF, "fertilizer", 1, 0),
                    ModConfig.misc.immersiveEngineering.gardenCloche.fertilizerGrowthMultiplier
            );
        }
    }

}
