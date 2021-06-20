package jackyy.integrationforegoing.integration.compat.crafttweaker.actions;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.actions.IAction;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.buuz135.industrial.recipe.LaserDrillFluidRecipe;
import com.buuz135.industrial.recipe.LaserDrillOreRecipe;
import com.buuz135.industrial.recipe.LaserDrillRarity;
import jackyy.integrationforegoing.integration.compat.crafttweaker.CraftTweakerCompat;
import jackyy.integrationforegoing.util.EnumAction;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.industrialforegoing.LaserDrill")
public class CraftTweakerActionLaserDrill {

    @ZenCodeType.Method
    public static void addOre(String ore, int lensColor, int minY, int maxY, int weight, int defaultWeight) {
        LaserDrillOreRecipe recipe = LaserDrillOreRecipe.createWithDefault(ore, lensColor, minY, maxY, weight, defaultWeight);
        CraftTweakerAPI.apply(new AddOreEntry(recipe));
    }

    @ZenCodeType.Method
    public static void addOreEnd(String ore, int lensColor, int minY, int maxY, int weight) {
        LaserDrillOreRecipe recipe = LaserDrillOreRecipe.createEnd(ore, lensColor, minY, maxY, weight);
        CraftTweakerAPI.apply(new AddOreEntry(recipe));
    }

    @ZenCodeType.Method
    public static void addOreNether(String ore, int lensColor, int minY, int maxY, int weight) {
        LaserDrillOreRecipe recipe = LaserDrillOreRecipe.createNether(ore, lensColor, minY, maxY, weight);
        CraftTweakerAPI.apply(new AddOreEntry(recipe));
    }

    @ZenCodeType.Method
    public static void removeOre(String recipeName) {
        CraftTweakerAPI.apply(new RemoveOreEntry(recipeName));
    }

    @ZenCodeType.Method
    public static void addFluid(FluidStack fluid, int lensColor, int minY, int maxY, int weight) {
        LaserDrillFluidRecipe recipe = new LaserDrillFluidRecipe(
                fluid, lensColor, LaserDrillFluidRecipe.EMPTY,
                new LaserDrillRarity(new RegistryKey[0], new RegistryKey[0], minY, maxY, weight)
        );
        CraftTweakerAPI.apply(new AddFluidEntry(recipe));
    }

    @ZenCodeType.Method
    public static void addFluidEnd(FluidStack fluid, int lensColor, int minY, int maxY, int weight) {
        LaserDrillFluidRecipe recipe = new LaserDrillFluidRecipe(
                fluid, lensColor, LaserDrillFluidRecipe.EMPTY,
                new LaserDrillRarity(LaserDrillRarity.END, new RegistryKey[0], minY, maxY, weight)
        );
        CraftTweakerAPI.apply(new AddFluidEntry(recipe));
    }

    @ZenCodeType.Method
    public static void addFluidNether(FluidStack fluid, int lensColor, int minY, int maxY, int weight) {
        LaserDrillFluidRecipe recipe = new LaserDrillFluidRecipe(
                fluid, lensColor, LaserDrillFluidRecipe.EMPTY,
                new LaserDrillRarity(LaserDrillRarity.NETHER, new RegistryKey[0], minY, maxY, weight)
        );
        CraftTweakerAPI.apply(new AddFluidEntry(recipe));
    }

    @ZenCodeType.Method
    public static void removeFluid(FluidStack fluid) {
        CraftTweakerAPI.apply(new RemoveFluidEntry(fluid));
    }

    private static class AddOreEntry implements IAction {
        private final LaserDrillOreRecipe recipe;

        private AddOreEntry(LaserDrillOreRecipe recipe) {
            this.recipe = recipe;
        }

        @Override
        public void apply() {
            CraftTweakerCompat.LASER_DRILL_ORE_ENTRIES.put(EnumAction.ADD, recipe);
        }

        @Override
        public String describe() {
            return "Adding Laser Drill Ore Recipe " + recipe.getRecipeKey();
        }
    }

    private static class RemoveOreEntry implements IAction {
        private final String recipeName;

        private RemoveOreEntry(String recipeName) {
            this.recipeName = recipeName;
        }

        @Override
        public void apply() {
            LaserDrillOreRecipe recipe = new LaserDrillOreRecipe(recipeName, Ingredient.EMPTY, 0, new ResourceLocation(recipeName));
            CraftTweakerCompat.LASER_DRILL_ORE_ENTRIES.put(EnumAction.REMOVE, recipe);
        }

        @Override
        public String describe() {
            return "Removing Laser Drill Ore Recipe " + recipeName;
        }
    }

    private static class AddFluidEntry implements IAction {
        private final LaserDrillFluidRecipe recipe;

        private AddFluidEntry(LaserDrillFluidRecipe recipe) {
            this.recipe = recipe;
        }

        @Override
        public void apply() {
            CraftTweakerCompat.LASER_DRILL_FLUID_ENTRIES.put(EnumAction.ADD, recipe);
        }

        @Override
        public String describe() {
            return "Adding Laser Drill Fluid Recipe " + recipe.getRecipeKey();
        }
    }

    private static class RemoveFluidEntry implements IAction {
        private final FluidStack output;

        private RemoveFluidEntry(FluidStack output) {
            this.output = output;
        }

        @Override
        public void apply() {
            LaserDrillFluidRecipe recipe = new LaserDrillFluidRecipe(output, 0, LaserDrillFluidRecipe.EMPTY);
            CraftTweakerCompat.LASER_DRILL_FLUID_ENTRIES.put(EnumAction.REMOVE, recipe);
        }

        @Override
        public String describe() {
            return "Removing Laser Drill Fluid Recipe " + output.getDisplayName();
        }
    }

}
