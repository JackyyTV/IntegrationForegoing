package jackydev.integrationforegoing.util;

import com.buuz135.industrial.api.IndustrialForegoingHelper;
import com.buuz135.industrial.api.recipe.BioReactorEntry;
import com.buuz135.industrial.api.recipe.LaserDrillEntry;
import com.buuz135.industrial.utils.apihandlers.RecipeHandlers;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModUtils {

    public static Item getItemByObject(String modid, String name) {
        return Item.REGISTRY.getObject(new ResourceLocation(modid, name));
    }

    public static ItemStack getItemStackByObject(String modid, String name, int amount, int meta) {
        return new ItemStack(getItemByObject(modid, name), amount, meta);
    }

    public static ItemStack getBlockItemStackByObject(String modid, String name, int amount, int meta) {
        return new ItemStack(getBlockByObject(modid, name), amount, meta);
    }

    public static Block getBlockByObject(String modid, String name) {
        return Block.REGISTRY.getObject(new ResourceLocation(modid, name));
    }

    public static Potion getPotionByObject(String modid, String name) {
        return Potion.REGISTRY.getObject(new ResourceLocation(modid, name));
    }

    public static SoundEvent getSoundByObject(String modid, String name) {
        return SoundEvent.REGISTRY.getObject(new ResourceLocation(modid, name));
    }

    public static void addCustomBioReactorEntryItem(String modid, String name, int amount, int meta) {
        if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(modid, name)) != null) {
            IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(getItemStackByObject(modid, name, amount, meta)));
        }
    }

    public static void addCustomBioReactorEntryBlock(String modid, String name, int amount, int meta) {
        if (ForgeRegistries.BLOCKS.getValue(new ResourceLocation(modid, name)) != null) {
            IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(getBlockItemStackByObject(modid, name, amount, meta)));
        }
    }

    public static void addCustomLaserDrillEntryItem(int laserMeta, String modid, String name, int amount, int meta, int weight) {
        if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(modid, name)) != null) {
            IndustrialForegoingHelper.addLaserDrillEntry(new LaserDrillEntry(laserMeta, getItemStackByObject(modid, name, amount, meta), weight));
        }
    }

    public static void addCustomLaserDrillEntryBlock(int laserMeta, String modid, String name, int amount, int meta, int weight) {
        if (ForgeRegistries.BLOCKS.getValue(new ResourceLocation(modid, name)) != null) {
            IndustrialForegoingHelper.addLaserDrillEntry(new LaserDrillEntry(laserMeta, getBlockItemStackByObject(modid, name, amount, meta), weight));
        }
    }

    public static void addCustomBioReactorEntriesFromOreDict(String oreDict) {
        NonNullList<ItemStack> stacks = RecipeHandlers.getRealOredictedItems(oreDict);
        if (stacks.size() > 0)
            for (ItemStack stack : stacks)
                IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(stack));
    }

}
