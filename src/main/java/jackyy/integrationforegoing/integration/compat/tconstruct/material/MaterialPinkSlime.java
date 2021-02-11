package jackyy.integrationforegoing.integration.compat.tconstruct.material;

import jackyy.gunpowderlib.helper.ObjectHelper;
import jackyy.integrationforegoing.integration.compat.tconstruct.TConstructCompat;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.Reference;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;

public class MaterialPinkSlime {

    public static void preInit() {
        Material pinkSlime = new Material(Reference.MODID + ".pink_slime", 0xFFF3AEC6);
        pinkSlime.setCraftable(true);
        pinkSlime.addTrait(TConstructCompat.SLIMEY_PINK);
        TinkerRegistry.addMaterialStats(
                pinkSlime,
                new HeadMaterialStats(1600, 5.0f, 4.0f, HarvestLevels.STONE),
                new HandleMaterialStats(1.8f, 500),
                new ExtraMaterialStats(150),
                new BowMaterialStats(0.5f, 1.8f, 3.0f)
        );
        TinkerRegistry.integrate(pinkSlime).preInit();
        TConstructCompat.MATERIALS.put("pink_slime", pinkSlime);
    }

    public static void init() {
        final Material pinkSlime = TConstructCompat.MATERIALS.get("pink_slime");
        pinkSlime.addItem(ObjectHelper.getItemByName(ModNames.IF, "pink_slime"), 1, Material.VALUE_Fragment);
        pinkSlime.setRepresentativeItem(ObjectHelper.getItemByName(ModNames.IF, "pink_slime"));
    }

}
