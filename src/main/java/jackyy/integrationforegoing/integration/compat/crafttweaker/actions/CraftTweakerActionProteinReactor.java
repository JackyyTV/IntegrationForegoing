package jackyy.integrationforegoing.integration.compat.crafttweaker.actions;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.actions.IAction;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.buuz135.industrial.api.recipe.ProteinReactorEntry;
import jackyy.integrationforegoing.integration.compat.crafttweaker.CraftTweakerCompat;
import jackyy.integrationforegoing.util.EnumAction;
import net.minecraft.item.ItemStack;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.industrialforegoing.ProteinReactor")
public class CraftTweakerActionProteinReactor {

    @ZenCodeType.Method
    public static void add(IItemStack input) {
        ProteinReactorEntry entry = new ProteinReactorEntry(input.getInternal());
        CraftTweakerAPI.apply(new AddEntry(entry));
    }

    @ZenCodeType.Method
    public static void remove(IItemStack input) {
        CraftTweakerAPI.apply(new RemoveEntry(input.getInternal()));
    }

    private static class AddEntry implements IAction {
        private final ProteinReactorEntry entry;

        private AddEntry(ProteinReactorEntry entry) {
            this.entry = entry;
        }

        @Override
        public void apply() {
            CraftTweakerCompat.PROTEIN_REACTOR_ENTRIES.put(EnumAction.ADD, entry);
        }

        @Override
        public String describe() {
            return "Adding Protein Reactor Entry " + entry.getStack().getDisplayName();
        }
    }

    private static class RemoveEntry implements IAction {
        private final ItemStack stack;

        private RemoveEntry(ItemStack stack) {
            this.stack = stack;
        }

        @Override
        public void apply() {
            CraftTweakerCompat.PROTEIN_REACTOR_ENTRIES.put(EnumAction.REMOVE, new ProteinReactorEntry(stack));
        }

        @Override
        public String describe() {
            return "Removing Protein Reactor Entry " + stack.getDisplayName();
        }
    }

}
