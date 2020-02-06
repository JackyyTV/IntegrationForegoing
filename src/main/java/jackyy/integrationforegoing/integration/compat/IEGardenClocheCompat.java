package jackyy.integrationforegoing.integration.compat;

import blusunrize.immersiveengineering.api.tool.BelljarHandler;
import jackyy.gunpowderlib.helper.ObjectHelper;
import jackyy.integrationforegoing.util.ModConfig;
import jackyy.integrationforegoing.util.ModNames;

public class IEGardenClocheCompat {

    public static void init() {
        if (ModConfig.misc.immersiveEngineering.gardenCloche.allowFertilizer) {
            BelljarHandler.registerBasicItemFertilizer(
                    ObjectHelper.getItemStackByName(ModNames.IF, "fertilizer", 1, 0),
                    ModConfig.misc.immersiveEngineering.gardenCloche.fertilizerGrowthMultiplier
            );
        }
    }

}
