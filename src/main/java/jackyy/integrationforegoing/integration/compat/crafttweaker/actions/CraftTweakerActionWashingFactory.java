package jackyy.integrationforegoing.integration.compat.crafttweaker.actions;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.actions.IAction;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.buuz135.industrial.api.recipe.ore.OreFluidEntryRaw;
import jackyy.integrationforegoing.integration.compat.crafttweaker.CraftTweakerCompat;
import jackyy.integrationforegoing.util.EnumAction;
import jackyy.integrationforegoing.util.ModUtils;
import net.minecraft.item.Item;
import net.minecraft.tags.Tag;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.industrialforegoing.WashingFactory")
public class CraftTweakerActionWashingFactory {

    @ZenCodeType.Method
    public static void add(Tag<Item> itemTag, IFluidStack input, IFluidStack output) {
        OreFluidEntryRaw entry = new OreFluidEntryRaw(itemTag, input.getInternal(), output.getInternal());
        CraftTweakerAPI.apply(new AddEntry(entry));
    }

    @ZenCodeType.Method
    public static void remove(Tag<Item> itemTag) {
        CraftTweakerAPI.apply(new RemoveEntry(itemTag));
    }

    private static class AddEntry implements IAction {
        private final OreFluidEntryRaw entry;

        private AddEntry(OreFluidEntryRaw entry) {
            this.entry = entry;
        }

        @Override
        public void apply() {
            CraftTweakerCompat.WASHING_FACTORY_ENTRIES.put(EnumAction.ADD, entry);
        }

        @Override
        public String describe() {
            return "Adding Washing Factory Entry " + entry.getOre();
        }
    }

    private static class RemoveEntry implements IAction {
        private final Tag<Item> itemTag;

        private RemoveEntry(Tag<Item> itemTag) {
            this.itemTag = itemTag;
        }

        @Override
        public void apply() {
            CraftTweakerCompat.WASHING_FACTORY_ENTRIES.put(EnumAction.REMOVE, new OreFluidEntryRaw(itemTag, ModUtils.getFakeFluid(), ModUtils.getFakeFluid()));
        }

        @Override
        public String describe() {
            return "Removing Washing Factory Entry " + itemTag;
        }
    }

}
