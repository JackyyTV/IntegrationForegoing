package me.jacky1356400.integrationforegoing.util;

import com.buuz135.industrial.api.IndustrialForegoingHelper;
import com.buuz135.industrial.api.recipe.BioReactorEntry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

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

    public static void addCustomBioReactorEntry(String modid, String name, int amount, int meta) {
        IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(getItemStackByObject(modid, name, amount, meta)));
    }

}
