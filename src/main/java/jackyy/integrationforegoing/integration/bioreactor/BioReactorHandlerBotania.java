package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;
import net.minecraft.item.DyeColor;

public class BioReactorHandlerBotania {

    public static void init() {
        for (int i = 0; i <= 15; i++) {
            ModUtils.registerBioReactorEntry(ModNames.BOTANIA, DyeColor.byId(i).getString() + "_petal", 1);
        }
    }

}
