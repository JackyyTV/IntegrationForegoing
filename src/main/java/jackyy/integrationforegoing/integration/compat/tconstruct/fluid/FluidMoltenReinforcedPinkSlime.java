package jackyy.integrationforegoing.integration.compat.tconstruct.fluid;

import jackyy.gunpowderlib.helper.ObjectHelper;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.shared.FluidsClientProxy;

public class FluidMoltenReinforcedPinkSlime {

    private static final ResourceLocation STILL = new ResourceLocation("tconstruct:blocks/fluids/molten_metal_flow");
    private static final ResourceLocation FLOWING = new ResourceLocation("tconstruct:blocks/fluids/molten_metal");
    private static Fluid moltenPinkSlimeFluid;

    public static void registerFluid() {
        moltenPinkSlimeFluid = new Fluid("molten_reinforced_pink_slime", FLOWING, STILL) {
            @Override
            public int getColor() {
                return 0xFF000000 | 0xC279B6;
            }
        }.setUnlocalizedName(Reference.MODID + ".molten_reinforced_pink_slime");
        moltenPinkSlimeFluid.setDensity(2000).setLuminosity(10).setTemperature(1000).setViscosity(10000);
        FluidRegistry.registerFluid(moltenPinkSlimeFluid);
        FluidRegistry.addBucketForFluid(moltenPinkSlimeFluid);

        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("fluid", moltenPinkSlimeFluid.getName());
        tag.setString("ore", "ReinforcedPinkSlime");
        tag.setBoolean("toolforge", true);
        FMLInterModComms.sendMessage("tconstruct", "integrateSmeltery", tag);
    }

    public static void registerRecipes() {
        Fluid f = FluidRegistry.getFluid("molten_reinforced_pink_slime");
        if (f != null) {
            TinkerRegistry.registerMelting(
                    ObjectHelper.getItemByName(ModNames.IF, "pink_slime_ingot"),
                    f, Material.VALUE_Ingot
            );
            TinkerRegistry.registerTableCasting(
                    ObjectHelper.getItemStackByName(ModNames.IF, "pink_slime_ingot", 1, 0),
                    ObjectHelper.getItemStackByName(ModNames.TCON, "cast_custom", 1, 0),
                    f, Material.VALUE_Ingot
            );
        }
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenderers() {
        if (moltenPinkSlimeFluid == null) {
            return;
        }
        Block block = moltenPinkSlimeFluid.getBlock();
        if (block == null) {
            return;
        }
        FluidsClientProxy.FluidStateMapper mapper = new FluidsClientProxy.FluidStateMapper(moltenPinkSlimeFluid);
        ModelLoader.setCustomStateMapper(block, mapper);
        Item item = Item.getItemFromBlock(block);
        if (item != Items.AIR) {
            ModelLoader.registerItemVariants(item);
            ModelLoader.setCustomMeshDefinition(item, mapper);
        }
    }

}
