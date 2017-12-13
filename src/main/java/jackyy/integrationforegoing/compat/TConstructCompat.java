package jackyy.integrationforegoing.compat;

import com.buuz135.industrial.entity.EntityPinkSlime;
import gnu.trove.map.hash.THashMap;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;
import jackyy.integrationforegoing.util.Reference;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;
import slimeknights.tconstruct.tools.traits.TraitSlimey;

import java.util.Map;

public class TConstructCompat {

    private static final Map<String, Material> materials = new THashMap<>();
    private static final AbstractTrait SLIMEY_PINK = new TraitSlimey("pink", EntityPinkSlime.class);

    public static void preInit() {
        Material plastic = new Material(Reference.MODID + ".plastic", 0xFFADADAD);
        plastic.setCraftable(true);
        plastic.addTrait(TinkerTraits.stonebound);
        TinkerRegistry.addMaterialStats(
                plastic,
                new HeadMaterialStats(1500, 6.0f, -1.0f, HarvestLevels.STONE),
                new HandleMaterialStats(0.1f, 1500),
                new ExtraMaterialStats(150),
                new BowMaterialStats(20.0f, 4.2f, 2.5f)
        );
        TinkerRegistry.integrate(plastic).preInit();
        materials.put("plastic", plastic);

        Material pinkSlime = new Material(Reference.MODID + ".pink_slime", 0xFFF3AEC6);
        pinkSlime.setCraftable(true);
        pinkSlime.addTrait(SLIMEY_PINK);
        TinkerRegistry.addMaterialStats(
                pinkSlime,
                new HeadMaterialStats(2000, 3.0f, 1.0f, HarvestLevels.STONE),
                new HandleMaterialStats(2.5f, 2000),
                new ExtraMaterialStats(200),
                new BowMaterialStats(15.0f, 4.7f, 3.0f)
        );
        TinkerRegistry.integrate(pinkSlime).preInit();
        materials.put("pink_slime", pinkSlime);
    }

    public static void init() {
        final Material plastic = materials.get("plastic");
        plastic.addItem(ModUtils.getItemByObject(ModNames.IF, "plastic"), 1, Material.VALUE_Fragment);
        plastic.setRepresentativeItem(ModUtils.getItemByObject(ModNames.IF, "plastic"));

        final Material pinkSlime = materials.get("pink_slime");
        pinkSlime.addItem(ModUtils.getItemByObject(ModNames.IF, "pink_slime"), 1, Material.VALUE_Fragment);
        pinkSlime.setRepresentativeItem(ModUtils.getItemByObject(ModNames.IF, "pink_slime"));
    }

}
