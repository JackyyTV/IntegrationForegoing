package jackyy.integrationforegoing.integration.compat.crafttweaker.actions;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.actions.IAction;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.buuz135.industrial.api.recipe.ore.OreFluidEntryFermenter;
import jackyy.integrationforegoing.util.EnumAction;
import jackyy.integrationforegoing.integration.compat.crafttweaker.CraftTweakerCompat;
import jackyy.integrationforegoing.util.ModUtils;
import net.minecraftforge.fluids.FluidStack;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.industrialforegoing.FermentationStation")
public class CraftTweakerActionFermentationStation {

    @ZenCodeType.Method
    public static void add(IFluidStack input, IFluidStack output) {
        OreFluidEntryFermenter entry = new OreFluidEntryFermenter(input.getInternal(), output.getInternal());
        CraftTweakerAPI.apply(new AddEntry(entry));
    }

    @ZenCodeType.Method
    public static void remove(IFluidStack input) {
        CraftTweakerAPI.apply(new RemoveEntry(input.getInternal()));
    }

    private static class AddEntry implements IAction {
        private final OreFluidEntryFermenter entry;

        private AddEntry(OreFluidEntryFermenter entry) {
            this.entry = entry;
        }

        @Override
        public void apply() {
            CraftTweakerCompat.FERMENTATION_STATION_ENTRIES.put(EnumAction.ADD, entry);
        }

        @Override
        public String describe() {
            return "Adding Fermentation Station Entry " + entry.getInput().getDisplayName();
        }
    }

    private static class RemoveEntry implements IAction {
        private final FluidStack input;

        private RemoveEntry(FluidStack input) {
            this.input = input;
        }

        @Override
        public void apply() {
            CraftTweakerCompat.FERMENTATION_STATION_ENTRIES.put(EnumAction.REMOVE, new OreFluidEntryFermenter(input, ModUtils.getFakeFluid()));
        }

        @Override
        public String describe() {
            return "Removing Fermentation Station Entry " + input.getDisplayName();
        }
    }

}
