package jackyy.integrationforegoing.integration.compat.tconstruct.material;

import jackyy.gunpowderlib.helper.ObjectHelper;
import jackyy.integrationforegoing.integration.compat.tconstruct.TConstructCompat;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.Reference;
import net.minecraftforge.fluids.FluidRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class MaterialReinforcedPinkSlime {

    public static void preInit() {
        Material reinforcedPinkSlime = new Material(Reference.MODID + ".reinforced_pink_slime", 0xFFC279B6);
        reinforcedPinkSlime.addTrait(TConstructCompat.SLIMEY_PINK, MaterialTypes.HEAD);
        reinforcedPinkSlime.addTrait(TinkerTraits.dense, MaterialTypes.HEAD);
        reinforcedPinkSlime.addTrait(TConstructCompat.SLIMEY_PINK, MaterialTypes.EXTRA);
        reinforcedPinkSlime.addTrait(TinkerTraits.unnatural, MaterialTypes.EXTRA);
        reinforcedPinkSlime.addTrait(TConstructCompat.SLIMEY_PINK, MaterialTypes.HANDLE);
        reinforcedPinkSlime.addTrait(TinkerTraits.unnatural, MaterialTypes.HANDLE);
        TinkerRegistry.addMaterialStats(
                reinforcedPinkSlime,
                new HeadMaterialStats(2800, 8.0f, 6.5f, HarvestLevels.DIAMOND),
                new HandleMaterialStats(2.5f, 1000),
                new ExtraMaterialStats(200),
                new BowMaterialStats(0.35f, 2.5f, 6.0f)
        );
        TinkerRegistry.integrate(reinforcedPinkSlime).preInit();
        TConstructCompat.MATERIALS.put("reinforced_pink_slime", reinforcedPinkSlime);
    }

    public static void init() {
        final Material reinforcedPinkSlime = TConstructCompat.MATERIALS.get("reinforced_pink_slime");
        reinforcedPinkSlime.addItem(ObjectHelper.getItemByName(ModNames.IF, "pink_slime_ingot"), 1, Material.VALUE_Ingot);
        reinforcedPinkSlime.setRepresentativeItem(ObjectHelper.getItemByName(ModNames.IF, "pink_slime_ingot"));
        reinforcedPinkSlime.setCraftable(false).setCastable(true);
        reinforcedPinkSlime.setFluid(FluidRegistry.getFluid("molten_reinforced_pink_slime"));
    }

}
