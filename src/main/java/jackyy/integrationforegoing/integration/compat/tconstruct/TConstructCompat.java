package jackyy.integrationforegoing.integration.compat.tconstruct;

import com.buuz135.industrial.entity.EntityPinkSlime;
import jackyy.integrationforegoing.integration.compat.tconstruct.fluid.FluidMoltenReinforcedPinkSlime;
import jackyy.integrationforegoing.integration.compat.tconstruct.material.MaterialPinkSlime;
import jackyy.integrationforegoing.integration.compat.tconstruct.material.MaterialPlastic;
import jackyy.integrationforegoing.integration.compat.tconstruct.material.MaterialReinforcedPinkSlime;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.tools.traits.TraitSlimey;

import java.util.HashMap;
import java.util.Map;

public class TConstructCompat {

    public static final Map<String, Material> MATERIALS = new HashMap<>();
    public static final AbstractTrait SLIMEY_PINK = new TraitSlimey("pink", EntityPinkSlime.class);

    public static void preInit() {
        MaterialPlastic.preInit();
        MaterialPinkSlime.preInit();
        MaterialReinforcedPinkSlime.preInit();
        FluidMoltenReinforcedPinkSlime.registerFluid();
    }

    public static void init() {
        MaterialPlastic.init();
        MaterialPinkSlime.init();
        MaterialReinforcedPinkSlime.init();
        FluidMoltenReinforcedPinkSlime.registerRecipes();
    }

    @SideOnly(Side.CLIENT)
    public static void initClient() {
        FluidMoltenReinforcedPinkSlime.registerRenderers();
    }

}
