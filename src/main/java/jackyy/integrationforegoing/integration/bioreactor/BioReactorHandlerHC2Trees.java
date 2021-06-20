package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerHC2Trees {

    private static final String[] SAPLINGS = new String[] {
            "apple", "avocado", "candlenut", "cherry", "chestnut",
            "gooseberry", "lemon", "nutmeg", "orange", "peach",
            "pear", "plum", "walnut", "spiderweb", "hazelnut",
            "pawpaw", "soursop", "almond", "apricot", "banana",
            "cashew", "cinnamon", "coconut", "date", "dragonfruit",
            "durian", "fig", "grapefruit", "lime", "mango",
            "olive", "papaya", "paperbark", "pecan", "peppercorn",
            "persimmon", "pistachio", "pomegranate", "starfruit", "vanillabean",
            "breadfruit", "guava", "jackfruit", "lychee", "passionfruit",
            "rambutan", "tamarind", "maple", "pinenut"
    };

    public static void init() {
        for (String sapling : SAPLINGS) {
            ModUtils.registerBioReactorEntry(ModNames.HC2TREES, sapling + "_sapling", 1);
        }
    }

}
