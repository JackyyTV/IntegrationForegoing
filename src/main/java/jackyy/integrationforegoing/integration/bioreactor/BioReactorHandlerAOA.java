package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerAOA {

    private static final String[] SAPLINGS = new String[] {
            "achony", "bloodtwister", "blue_celevus", "blue_haven", "bright_shyre",
            "churry", "creep", "dawnwood", "eyebush", "eye_hanger",
            "green_celevus", "haunted", "irodust", "irogold", "lucalus",
            "lunicia", "lunosso", "pink_haven", "purple_celevus", "purple_haven",
            "red_celevus", "red_haven", "runic", "shadow", "shyre",
            "stranglewood", "turquoise_haven", "yellow_celevus", "yellow_haven"
    };
    private static final String[] SEEDS = new String[] {
            "bubble_berry", "chilli", "floracle", "goldicap", "heart_fruit",
            "holly_top", "lunacrike", "luna_globe", "lunalon", "magic_marang",
            "rosidon", "tea", "thorny_plant", "trilliad"
    };

    public static void init() {
        for (String sapling : SAPLINGS) {
            ModUtils.registerBioReactorEntry(ModNames.AOA, sapling + "_sapling", 1, 0);
        }
        for (String seed : SEEDS) {
            ModUtils.registerBioReactorEntry(ModNames.AOA, seed + "_seeds", 1, 0);
        }
    }

}
