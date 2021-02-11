package jackyy.integrationforegoing.integration.compat.crafttweaker.actions;

import com.buuz135.industrial.api.recipe.ore.OreFluidEntryRaw;
import com.buuz135.industrial.utils.apihandlers.crafttweaker.CTAction;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.api.liquid.ILiquidStack;
import jackyy.integrationforegoing.integration.compat.crafttweaker.CraftTweakerCompat;
import jackyy.integrationforegoing.util.ModUtils;
import net.minecraftforge.fluids.FluidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.industrialforegoing.WashingFactory")
public class CraftTweakerActionWashingFactory {

    @ZenMethod
    public static void add(String ore, ILiquidStack input, ILiquidStack output) {
        OreFluidEntryRaw entry = new OreFluidEntryRaw(ore, (FluidStack) input.getInternal(), (FluidStack) output.getInternal());
        CraftTweakerAPI.apply(new AddEntry(entry));
    }

    @ZenMethod
    public static void remove(String ore) {
        CraftTweakerAPI.apply(new RemoveEntry(ore));
    }

    private static class AddEntry implements IAction {
        private final OreFluidEntryRaw entry;

        private AddEntry(OreFluidEntryRaw entry) {
            this.entry = entry;
        }

        @Override
        public void apply() {
            CraftTweakerCompat.WASHING_FACTORY_ENTRIES.put(CTAction.ADD, entry);
        }

        @Override
        public String describe() {
            return "Adding Washing Factory Entry " + entry.getOre();
        }
    }

    private static class RemoveEntry implements IAction {
        private final String ore;

        private RemoveEntry(String ore) {
            this.ore = ore;
        }

        @Override
        public void apply() {
            CraftTweakerCompat.WASHING_FACTORY_ENTRIES.put(CTAction.REMOVE, new OreFluidEntryRaw(ore, ModUtils.getFakeFluid(), ModUtils.getFakeFluid()));
        }

        @Override
        public String describe() {
            return "Removing Washing Factory Entry " + ore;
        }
    }

}
