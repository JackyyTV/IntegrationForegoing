package jackyy.integrationforegoing.util;

import com.buuz135.industrial.api.IndustrialForegoingHelper;
import com.buuz135.industrial.api.recipe.BioReactorEntry;
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

    public static void logIntegration(int state, EnumIntegrations type, String modid) {
        if (state == 0) {
            switch (type) {
                case STRAW:
                    IntegrationForegoing.logger.info("Registering drink handlers for " + getModNameByID(modid) + "...");
                    break;
                case PLANT:
                    IntegrationForegoing.logger.info("Registering Plant Gatherer entries for " + getModNameByID(modid) + "...");
                    break;
                case LASERDRILL:
                    IntegrationForegoing.logger.info("Registering Laser Drill entries for " + getModNameByID(modid) + "...");
                    break;
                case BIOREACTOR:
                    IntegrationForegoing.logger.info("Registering Bioreactor entries for " + getModNameByID(modid) + "...");
                    break;
                case PROTEIN:
                    IntegrationForegoing.logger.info("Registering Protein Reactor entries for " + getModNameByID(modid) + "...");
                    break;
            }
        } else if (state == 1) {
            switch (type) {
                case STRAW:
                    IntegrationForegoing.logger.info("Registered drink handlers for " + getModNameByID(modid));
                    break;
                case PLANT:
                    IntegrationForegoing.logger.info("Registered Plant Gatherer entries for " + getModNameByID(modid));
                    break;
                case LASERDRILL:
                    IntegrationForegoing.logger.info("Registered Laser Drill entries for " + getModNameByID(modid));
                    break;
                case BIOREACTOR:
                    IntegrationForegoing.logger.info("Registered Bioreactor entries for " + getModNameByID(modid));
                    break;
                case PROTEIN:
                    IntegrationForegoing.logger.info("Registered Protein Reactor entries for " + getModNameByID(modid));
                    break;
            }
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

    //TODO Generate JSON files for the entries
    public static void addCustomLaserDrillEntryBlock(int laserMeta, String modid, String name, int amount, int meta, int weight) {
        /*
        if (ForgeRegistries.BLOCKS.getValue(new ResourceLocation(modid, name)) != null) {
            IndustrialForegoingHelper.addLaserDrillEntry(new LaserDrillEntry(laserMeta, getBlockStackByName(modid, name, amount, meta), weight));
        }
        */
    }

}
