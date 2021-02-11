package jackyy.integrationforegoing.integration.proteinreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class ProteinReactorHandlerHarvestCraft {

    private static final String[] PROTEINS = new String[] {
            "calamari", "turkey", "venison", "duck", "anchovy",
            "bass", "carp", "catfish", "charr", "clam",
            "crab", "crayfish", "eel", "frog", "grouper",
            "herring", "jellyfish", "mudfish", "octopus", "perch",
            "scallop", "shrimp", "snail", "snapper", "tilapia",
            "trout", "tuna", "turtle", "walleye", "sardine",
            "mussel"
    };

    public static void init() {
        for (String protein : PROTEINS) {
            ModUtils.registerProteinReactorEntry(ModNames.HARVESTCRAFT, protein + "rawitem", 1, 0);
        }
    }

}
