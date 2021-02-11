package jackyy.integrationforegoing.integration.compat.crafttweaker.actions;

import com.buuz135.industrial.api.recipe.ore.OreFluidEntryFermenter;
import com.buuz135.industrial.utils.apihandlers.crafttweaker.CTAction;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.api.liquid.ILiquidStack;
import jackyy.integrationforegoing.integration.compat.crafttweaker.CraftTweakerCompat;
import jackyy.integrationforegoing.util.ModUtils;
import net.minecraftforge.fluids.FluidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.industrialforegoing.FermentationStation")
public class CraftTweakerActionFermentationStation {

    @ZenMethod
    public static void add(ILiquidStack input, ILiquidStack output) {
        OreFluidEntryFermenter entry = new OreFluidEntryFermenter((FluidStack) input.getInternal(), (FluidStack) output.getInternal());
        CraftTweakerAPI.apply(new AddEntry(entry));
    }

    @ZenMethod
    public static void remove(ILiquidStack input) {
        CraftTweakerAPI.apply(new RemoveEntry((FluidStack) input.getInternal()));
    }

    private static class AddEntry implements IAction {
        private final OreFluidEntryFermenter entry;

        private AddEntry(OreFluidEntryFermenter entry) {
            this.entry = entry;
        }

        @Override
        public void apply() {
            CraftTweakerCompat.FERMENTATION_STATION_ENTRIES.put(CTAction.ADD, entry);
        }

        @Override
        public String describe() {
            return "Adding Fermentation Station Entry " + entry.getInput();
        }
    }

    private static class RemoveEntry implements IAction {
        private final FluidStack input;

        private RemoveEntry(FluidStack input) {
            this.input = input;
        }

        @Override
        public void apply() {
            CraftTweakerCompat.FERMENTATION_STATION_ENTRIES.put(CTAction.REMOVE, new OreFluidEntryFermenter(input, ModUtils.getFakeFluid()));
        }

        @Override
        public String describe() {
            return "Removing Fermentation Station Entry " + input;
        }
    }

}
