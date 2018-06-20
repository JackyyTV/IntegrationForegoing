package jackyy.integrationforegoing.util;

import com.buuz135.industrial.api.IndustrialForegoingHelper;
import com.buuz135.industrial.api.recipe.BioReactorEntry;
import com.buuz135.industrial.api.recipe.LaserDrillEntry;
import com.buuz135.industrial.api.recipe.ProteinReactorEntry;
import jackyy.integrationforegoing.IntegrationForegoing;
import net.minecraft.block.Block;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.Map;

public class ModUtils {

    public static Item getItemByName(String modid, String name) {
        return Item.REGISTRY.getObject(new ResourceLocation(modid, name));
    }

    public static ItemStack getItemStackByName(String modid, String name, int amount, int meta) {
        return new ItemStack(getItemByName(modid, name), amount, meta);
    }

    public static ItemStack getBlockStackByName(String modid, String name, int amount, int meta) {
        return new ItemStack(getBlockByName(modid, name), amount, meta);
    }

    public static Block getBlockByName(String modid, String name) {
        return Block.REGISTRY.getObject(new ResourceLocation(modid, name));
    }

    public static Potion getPotionByName(String modid, String name) {
        if (ForgeRegistries.POTIONS.getValue(new ResourceLocation(modid, name)) != null) {
            return Potion.REGISTRY.getObject(new ResourceLocation(modid, name));
        }
        return MobEffects.LUCK;
    }

    public static void logIntegration(int state, String type, String modid) {
        if (state == 0) {
            IntegrationForegoing.logger.info("Registering " + type + " for " + getModNameByID(modid) + "...");
        } else if (state == 1) {
            IntegrationForegoing.logger.info("Registered " + type + " for " + getModNameByID(modid));
        }
    }

    public static String getModNameByID(String modid) {
        Map<String, ModContainer> indexedModList = Loader.instance().getIndexedModList();
        ModContainer modContainer = indexedModList.get(modid);
        if (modContainer != null) {
            return modContainer.getName();
        }
        return modid;
    }

    public static void addCustomBioReactorEntryItem(String modid, String name, int amount, int meta) {
        if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(modid, name)) != null) {
            IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(getItemStackByName(modid, name, amount, meta)));
        }
    }

    public static void addCustomProteinReactorEntryItem(String modid, String name, int amount, int meta) {
        if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(modid, name)) != null) {
            IndustrialForegoingHelper.addProteinReactorEntry(new ProteinReactorEntry(getItemStackByName(modid, name, amount, meta)));
        }
    }

    public static void addCustomLaserDrillEntryBlock(int laserMeta, String modid, String name, int amount, int meta, int weight) {
        if (ForgeRegistries.BLOCKS.getValue(new ResourceLocation(modid, name)) != null) {
            IndustrialForegoingHelper.addLaserDrillEntry(new LaserDrillEntry(laserMeta, getBlockStackByName(modid, name, amount, meta), weight));
        }
    }

}
