package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerBotania {

    public static void init() {
        for (int i = 0; i <= 15; i++) {
            ModUtils.registerBioReactorEntry(ModNames.BOTANIA, "petal", 1, i);
        }
    }

}
