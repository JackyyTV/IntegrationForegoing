package jackyy.integrationforegoing.integration.compat.tconstruct.material;

import jackyy.gunpowderlib.helper.ObjectHelper;
import jackyy.integrationforegoing.integration.compat.tconstruct.TConstructCompat;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.Reference;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class MaterialPlastic {

    public static void preInit() {
        Material plastic = new Material(Reference.MODID + ".plastic", 0xFFADADAD);
        plastic.setCraftable(true);
        plastic.addTrait(TinkerTraits.stonebound);
        TinkerRegistry.addMaterialStats(
                plastic,
                new HeadMaterialStats(1200, 3.5f, -1.0f, HarvestLevels.STONE),
                new HandleMaterialStats(0.1f, 1500),
                new ExtraMaterialStats(100),
                new BowMaterialStats(0.9f, 1.1f, 1.0f)
        );
        TinkerRegistry.integrate(plastic).preInit();
        TConstructCompat.MATERIALS.put("plastic", plastic);
    }

    public static void init() {
        final Material plastic = TConstructCompat.MATERIALS.get("plastic");
        plastic.addItem(ObjectHelper.getItemByName(ModNames.IF, "plastic"), 1, Material.VALUE_Fragment);
        plastic.setRepresentativeItem(ObjectHelper.getItemByName(ModNames.IF, "plastic"));
    }

}
