package jackyy.integrationforegoing.integration.proteinreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class ProteinReactorHandlerAOA {

    private static final String[] PROTEINS = new String[] {
            "candlefish", "crimson_skipper", "crimson_stripefish", "dark_hatchetfish", "fingerfish",
            "golden_gullfish", "ironback", "limefish", "pearl_stripefish", "rainbowfish",
            "razorfish", "rocketfish", "sailback", "sapphire_strider", "turquoise_stripefish",
            "violet_skipper", "charger_shank", "chimera_chop", "ursa_meat", "furlion_chop",
            "halycon_beef"
    };

    public static void init() {
        for (String protein : PROTEINS) {
            ModUtils.registerProteinReactorEntry(ModNames.AOA, "raw_" + protein, 1, 0);
        }
    }

}
