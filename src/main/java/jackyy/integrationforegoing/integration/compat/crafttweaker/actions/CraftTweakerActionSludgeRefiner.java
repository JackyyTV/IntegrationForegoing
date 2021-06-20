package jackyy.integrationforegoing.integration.compat.crafttweaker.actions;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.actions.IAction;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.buuz135.industrial.api.recipe.SludgeEntry;
import jackyy.integrationforegoing.integration.compat.crafttweaker.CraftTweakerCompat;
import jackyy.integrationforegoing.util.EnumAction;
import net.minecraft.item.ItemStack;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.industrialforegoing.SludgeRefiner")
public class CraftTweakerActionSludgeRefiner {

    @ZenCodeType.Method
    public static void add(IItemStack output, int weight) {
        SludgeEntry entry = new SludgeEntry(output.getInternal(), weight);
        CraftTweakerAPI.apply(new AddEntry(entry));
    }

    @ZenCodeType.Method
    public static void remove(IItemStack output) {
        CraftTweakerAPI.apply(new RemoveEntry(output.getInternal()));
    }

    private static class AddEntry implements IAction {
        private final SludgeEntry entry;

        private AddEntry(SludgeEntry entry) {
            this.entry = entry;
        }

        @Override
        public void apply() {
            CraftTweakerCompat.SLUDGE_REFINER_ENTRIES.put(EnumAction.ADD, entry);
        }

        @Override
        public String describe() {
            return "Adding Sludge Refiner Entry " + entry.getStack().getDisplayName();
        }
    }

    private static class RemoveEntry implements IAction {
        private final ItemStack stack;

        private RemoveEntry(ItemStack stack) {
            this.stack = stack;
        }

        @Override
        public void apply() {
            CraftTweakerCompat.SLUDGE_REFINER_ENTRIES.put(EnumAction.REMOVE, new SludgeEntry(stack, 0));
        }

        @Override
        public String describe() {
            return "Removing Sludge Refiner Entry " + stack.getDisplayName();
        }
    }

}
