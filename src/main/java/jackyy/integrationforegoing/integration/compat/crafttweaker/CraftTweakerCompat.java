package jackyy.integrationforegoing.integration.compat.crafttweaker;

import com.buuz135.industrial.api.IndustrialForegoingHelper;
import com.buuz135.industrial.api.recipe.BioReactorEntry;
import com.buuz135.industrial.api.recipe.ProteinReactorEntry;
import com.buuz135.industrial.api.recipe.SludgeEntry;
import com.buuz135.industrial.api.recipe.ore.OreFluidEntryFermenter;
import com.buuz135.industrial.api.recipe.ore.OreFluidEntryRaw;
import com.buuz135.industrial.api.recipe.ore.OreFluidEntrySieve;
import com.buuz135.industrial.recipe.LaserDrillFluidRecipe;
import com.buuz135.industrial.recipe.LaserDrillOreRecipe;
import com.google.common.collect.LinkedListMultimap;
import jackyy.integrationforegoing.util.EnumAction;

public class CraftTweakerCompat {

    public static final LinkedListMultimap<EnumAction, BioReactorEntry> BIO_REACTOR_ENTRIES = LinkedListMultimap.create();
    public static final LinkedListMultimap<EnumAction, SludgeEntry> SLUDGE_REFINER_ENTRIES = LinkedListMultimap.create();
    public static final LinkedListMultimap<EnumAction, ProteinReactorEntry> PROTEIN_REACTOR_ENTRIES = LinkedListMultimap.create();
    public static final LinkedListMultimap<EnumAction, LaserDrillOreRecipe> LASER_DRILL_ORE_ENTRIES = LinkedListMultimap.create();
    public static final LinkedListMultimap<EnumAction, LaserDrillFluidRecipe> LASER_DRILL_FLUID_ENTRIES = LinkedListMultimap.create();
    public static final LinkedListMultimap<EnumAction, OreFluidEntryRaw> WASHING_FACTORY_ENTRIES = LinkedListMultimap.create();
    public static final LinkedListMultimap<EnumAction, OreFluidEntryFermenter> FERMENTATION_STATION_ENTRIES = LinkedListMultimap.create();
    public static final LinkedListMultimap<EnumAction, OreFluidEntrySieve> FLUID_SIEVING_MACHINE_ENTRIES = LinkedListMultimap.create();

    public static void parseActionEntries() {
        BIO_REACTOR_ENTRIES.forEach((action, entry) -> {
            if (action == EnumAction.ADD) IndustrialForegoingHelper.addBioReactorEntry(entry);
            else IndustrialForegoingHelper.removeBioReactorEntry(entry.getStack());
        });
        SLUDGE_REFINER_ENTRIES.forEach((action, entry) -> {
            if (action == EnumAction.ADD) IndustrialForegoingHelper.addSludgeRefinerEntry(entry);
            else IndustrialForegoingHelper.removeSludgeRefinerEntry(entry.getStack());
        });
        PROTEIN_REACTOR_ENTRIES.forEach((action, entry) -> {
            if (action == EnumAction.ADD) IndustrialForegoingHelper.addProteinReactorEntry(entry);
            else IndustrialForegoingHelper.removeProteinReactorEntry(entry.getStack());
        });
        LASER_DRILL_ORE_ENTRIES.forEach((action, entry) -> {
            if (action == EnumAction.ADD) LaserDrillOreRecipe.SERIALIZER.write(entry);
            //else
        });
        WASHING_FACTORY_ENTRIES.forEach((action, entry) -> {
            if (action == EnumAction.ADD) IndustrialForegoingHelper.addOreFluidEntryRaw(entry);
            else IndustrialForegoingHelper.removeOreFluidEntryRaw(entry.getOre());
        });
        FERMENTATION_STATION_ENTRIES.forEach((action, entry) -> {
            if (action == EnumAction.ADD) IndustrialForegoingHelper.addOreFluidEntryFermenter(entry);
            else IndustrialForegoingHelper.removeOreFluidEntryFermenter(entry.getInput());
        });
        FLUID_SIEVING_MACHINE_ENTRIES.forEach((action, entry) -> {
            if (action == EnumAction.ADD) IndustrialForegoingHelper.addOreFluidEntrySieve(entry);
            else IndustrialForegoingHelper.removeOreFluidEntrySieve(entry.getOutput());
        });
    }

}
