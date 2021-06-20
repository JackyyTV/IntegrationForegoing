package jackyy.integrationforegoing.util;

import com.buuz135.industrial.api.IndustrialForegoingHelper;
import com.buuz135.industrial.api.recipe.BioReactorEntry;
import com.buuz135.industrial.api.recipe.ProteinReactorEntry;
import jackyy.gunpowderlib.helper.ObjectHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

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
                case BIOREACTOR:
                    Reference.LOGGER.info("Registering Bioreactor entries for " + StringHelper.getModNameByID(modid) + "...");
                    break;
                case PROTEIN:
                    Reference.LOGGER.info("Registering Protein Reactor entries for " + StringHelper.getModNameByID(modid) + "...");
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
                case BIOREACTOR:
                    Reference.LOGGER.info("Registered Bioreactor entries for " + StringHelper.getModNameByID(modid));
                    break;
                case PROTEIN:
                    Reference.LOGGER.info("Registered Protein Reactor entries for " + StringHelper.getModNameByID(modid));
                    break;
            }
        }
    }

    public static void registerBioReactorEntry(String namespace, String path, int amount) {
        if (ObjectHelper.getItemByName(namespace, path) != null) {
            IndustrialForegoingHelper.addBioReactorEntry(new BioReactorEntry(ObjectHelper.getItemStackByName(namespace, path, amount)));
        }
    }

    public static void registerProteinReactorEntry(String namespace, String path, int amount) {
        if (ObjectHelper.getItemByName(namespace, path)!= null) {
            IndustrialForegoingHelper.addProteinReactorEntry(new ProteinReactorEntry(ObjectHelper.getItemStackByName(namespace, path, amount)));
        }
    }

    public static Fluid getFluidByName(String namespace, String path) {
        if (ForgeRegistries.FLUIDS.getValue(new ResourceLocation(namespace, path)) != null) {
            return ForgeRegistries.FLUIDS.getValue(new ResourceLocation(namespace, path));
        }
        return Fluids.EMPTY;
    }

    public static IntegerProperty getGenericGrowthAge(int maxAge) {
        return IntegerProperty.create("age", 0, maxAge);
    }

    public static FluidStack getFakeFluid() {
        return FluidStack.EMPTY;
    }

}
