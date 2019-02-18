package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerTConstruct {

    public static void init() {
        for (int i = 0; i <= 2; i++) {
            ModUtils.registerBioReactorEntry(ModNames.TCON, "slime_sapling", 1, i);
        }
    }

}
