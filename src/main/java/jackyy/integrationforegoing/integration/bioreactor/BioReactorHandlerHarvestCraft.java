package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerHarvestCraft {

    private static final String[] SEEDS = new String[] {
            "blackberry", "blueberry", "candleberry", "raspberry", "strawberry",
            "cactusfruit", "asparagus", "barley", "oats", "rye",
            "corn", "bambooshoot", "cantaloupe", "cucumber", "wintersquash",
            "zucchini", "beet", "onion", "parsnip", "peanut",
            "radish", "rutabaga", "sweetpotato", "turnip", "rhubarb",
            "celery", "garlic", "ginger", "spiceleaf", "tea",
            "coffee", "mustard", "broccoli", "cauliflower", "leek",
            "lettuce", "scallion", "artichoke", "brusselsprout", "cabbage",
            "spinach", "bean", "soybean", "bellpeper", "chilipepper",
            "eggplant", "okra", "peas", "tomato", "cotton",
            "pineapple", "grape", "kiwi", "cranberry", "rice",
            "seaweed", "curryleaf", "sesameseeds", "waterchestnut"
    };
    private static final String[] SAPLINGS = new String[] {
            "date", "papaya", "cherry", "fig", "dragonfruit",
            "apple", "lemon", "pear", "olive", "grapefruit",
            "pomegranate", "cashew", "vanillabean", "starfruit", "banana",
            "plum", "avocado", "pecan", "pistachio", "lime",
            "peppercorn", "almond", "gooseberry", "peach", "chestnut",
            "coconut", "mango", "apricot", "orange", "walnut",
            "persimmon", "nutmeg", "durian", "cinnamon", "maple",
            "paperbark"
    };

    public static void init() {
        for (String seed : SEEDS) {
            ModUtils.registerBioReactorEntry(ModNames.HARVESTCRAFT, seed + "seeditem", 1, 0);
        }
        for (String sapling : SAPLINGS) {
            ModUtils.registerBioReactorEntry(ModNames.HARVESTCRAFT, sapling + "_sapling", 1, 0);
        }
    }

}
