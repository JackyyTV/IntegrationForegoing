package jackyy.integrationforegoing.integration.compat.crafttweaker.actions;

import com.buuz135.industrial.api.recipe.ore.OreFluidEntrySieve;
import com.buuz135.industrial.utils.apihandlers.crafttweaker.CTAction;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import jackyy.integrationforegoing.integration.compat.crafttweaker.CraftTweakerCompat;
import jackyy.integrationforegoing.util.ModUtils;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.industrialforegoing.FluidSievingMachine")
public class CraftTweakerActionFluidSievingMachine {

    @ZenMethod
    public static void add(ILiquidStack input, IItemStack output, IItemStack sieveItem) {
        OreFluidEntrySieve entry = new OreFluidEntrySieve((FluidStack) input.getInternal(), (ItemStack) output.getInternal(), (ItemStack) sieveItem.getInternal());
        CraftTweakerAPI.apply(new AddEntry(entry));
    }

    @ZenMethod
    public static void remove(IItemStack output) {
        CraftTweakerAPI.apply(new RemoveEntry((ItemStack) output.getInternal()));
    }

    private static class AddEntry implements IAction {
        private final OreFluidEntrySieve entry;

        private AddEntry(OreFluidEntrySieve entry) {
            this.entry = entry;
        }

        @Override
        public void apply() {
            CraftTweakerCompat.FLUID_SIEVING_MACHINE_ENTRIES.put(CTAction.ADD, entry);
        }

        @Override
        public String describe() {
            return "Adding Fluid Sieving Machine Entry " + entry.getOutput();
        }
    }

    private static class RemoveEntry implements IAction {
        private final ItemStack output;

        private RemoveEntry(ItemStack output) {
            this.output = output;
        }

        @Override
        public void apply() {
            CraftTweakerCompat.FLUID_SIEVING_MACHINE_ENTRIES.put(CTAction.REMOVE, new OreFluidEntrySieve(ModUtils.getFakeFluid(), output, ItemStack.EMPTY));
        }

        @Override
        public String describe() {
            return "Removing Fluid Sieving Machine Entry " + output;
        }
    }

}
