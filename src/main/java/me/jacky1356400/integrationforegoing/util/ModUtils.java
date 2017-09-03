package me.jacky1356400.integrationforegoing.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class ModUtils {

    public static Item getItemByObject(String modid, String name) {
        return Item.REGISTRY.getObject(new ResourceLocation(modid, name));
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

}
