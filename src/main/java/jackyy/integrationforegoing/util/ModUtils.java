package jackyy.integrationforegoing.util;

import com.buuz135.industrial.api.IndustrialForegoingHelper;
import com.buuz135.industrial.api.extractor.ExtractorEntry;
import com.buuz135.industrial.api.recipe.BioReactorEntry;
import com.buuz135.industrial.api.recipe.LaserDrillEntry;
import com.buuz135.industrial.api.recipe.ProteinReactorEntry;
import com.buuz135.industrial.proxy.FluidsRegistry;
import com.buuz135.industrial.utils.apihandlers.RecipeHandlers;
import jackyy.gunpowderlib.helper.ObjectHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ModUtils {

    public static void logIntegration(int state, EnumIntegrations type, String modid) {
        if (state == 0) {
            switch (type) {
                case STRAW:
                    Reference.LOGGER.info("Registering drink handlers for " + StringHelper.getModNameByID(modid) + "...");
                    break;
                case PLANT:
                    Reference.LOGGER.info("Registering Plant Gatherer entries for " + StringHelper.getModNameByID(modid) + "...");
                    break;
                case LASERDRILL:
                    Reference.LOGGER.info("Registering Laser Drill entries for " + StringHelper.getModNameByID(modid) + "...");
                    break;
                case BIOREACTOR:
                    Reference.LOGGER.info("Registering Bioreactor entries for " + StringHelper.getModNameByID(modid) + "...");
                    break;
                case PROTEIN:
                    Reference.LOGGER.info("Registering Protein Reactor entries for " + StringHelper.getModNameByID(modid) + "...");
                    break;
                case TREEFLUID:
                    Reference.LOGGER.info("Registering Tree Fluid Extractor entries for " + StringHelper.getModNameByID(modid) + "...");
                    break;
            }
        } else if (state == 1) {
            switch (type) {
                case STRAW:
                    Reference.LOGGER.info("Registered drink handlers for " + StringHelper.getModNameByID(modid));
                    break;
                case PLANT:
                    Reference.LOGGER.info("Registered Plant Gatherer entries for " + StringHelper.getModNameByID(modid));
                    break;
                case LASERDRILL:
                    Reference.LOGGER.info("Registered Laser Drill entries for " + StringHelper.getModNameByID(modid));
                    break;
                case BIOREACTOR:
                    Reference.LOGGER.info("Registered Bioreactor entries for " + StringHelper.getModNameByID(modid));
                    break;
                case PROTEIN:
                    Reference.LOGGER.info("Registered Protein Reactor entries for " + StringHelper.getModNameByID(modid));
                    break;
                case TREEFLUID:
                    Reference.LOGGER.info("Registered Tree Fluid Extractor entries for " + StringHelper.getModNameByID(modid) + "...");
                    break;
            }
        }
    }

    public static void registerBioReactorEntry(String namespace, String path, int amount, int meta) {
        if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(namespace, path)) != null) {
            IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(ObjectHelper.getItemStackByName(namespace, path, amount, meta)));
        }
    }

    public static void registerProteinReactorEntry(String namespace, String path, int amount, int meta) {
        if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(namespace, path)) != null) {
            IndustrialForegoingHelper.addProteinReactorEntry(new ProteinReactorEntry(ObjectHelper.getItemStackByName(namespace, path, amount, meta)));
        }
    }

    public static void registerTreeFluidExtractorEntry(String namespace, String path, int fluidAmount) {
        if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(namespace, path)) != null) {
            RecipeHandlers.tryToAddWoodToLatex(namespace + ":" + path, new FluidStack(FluidsRegistry.LATEX, fluidAmount));
        }
    }

    public static void registerTreeFluidExtractorEntry(String namespace, String path, int amount, int meta, int fluidAmount) {
        if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(namespace, path)) != null) {
            IndustrialForegoingHelper.addWoodToLatex(new ExtractorEntry(ObjectHelper.getItemStackByName(namespace, path, amount, meta), new FluidStack(FluidsRegistry.LATEX, fluidAmount)));
        }
    }

    public static void loadLaserDrillFile(String fileName) {
        LaserDrillEntry.addOreFile(new ResourceLocation(Reference.MODID, fileName + "_ores.json"));
    }

    public static void deleteExistingLaserDrillFile(File dir, String fileName) {
        Path path = dir.toPath().resolve("laser_drill_ores");
        if (Files.exists(path)) {
            File file = new File(path.toFile(), fileName + "_ores.json");
            if (!file.exists())
                return;
            if (file.delete())
                Reference.LOGGER.info("Deleted existing Laser Drill config file " + file.getName());
        }
    }

    public static PropertyInteger getGenericGrowthAge(int maxAge) {
        return PropertyInteger.create("age", 0, maxAge);
    }

    public static FluidStack getFakeFluid() {
        return new FluidStack(FluidRegistry.WATER, 69);
    }

}
