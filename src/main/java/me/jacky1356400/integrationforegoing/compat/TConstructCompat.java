package me.jacky1356400.integrationforegoing.compat;

import gnu.trove.map.hash.THashMap;
import me.jacky1356400.integrationforegoing.IntegrationForegoing;
import me.jacky1356400.integrationforegoing.util.ModUtils;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.tools.TinkerTraits;

import java.util.Map;

public class TConstructCompat {

    private static final Map<String, Material> materials = new THashMap<>();

    public static void preInit() {
        Material plastic = new Material(IntegrationForegoing.MODID + ".plastic", 0xFFADADAD);
        plastic.setCraftable(true);
        plastic.addTrait(TinkerTraits.stonebound);
        TinkerRegistry.addMaterialStats(plastic,
                new HeadMaterialStats(1500, 0.6f, -1.0f, 1),
                new HandleMaterialStats(0.1f, 1500),
                new ExtraMaterialStats(10),
                new BowMaterialStats(20.0f, 4.2f, 2.5f)
        );
        TinkerRegistry.integrate(plastic).preInit();
        materials.put("plastic", plastic);
    }

    public static void init() {
        final Material plastic = materials.get("plastic");
        plastic.addItem(ModUtils.getItemByObject("industrialforegoing", "plastic"), 1, Material.VALUE_Fragment);
        plastic.setRepresentativeItem(ModUtils.getItemStackByObject("industrialforegoing", "plastic", 1, 0));
    }

}
