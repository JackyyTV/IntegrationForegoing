package jackyy.integrationforegoing.integration.compat.crafttweaker;

import com.buuz135.industrial.api.IndustrialForegoingHelper;
import com.buuz135.industrial.api.recipe.ore.OreFluidEntryFermenter;
import com.buuz135.industrial.api.recipe.ore.OreFluidEntryRaw;
import com.buuz135.industrial.api.recipe.ore.OreFluidEntrySieve;
import com.buuz135.industrial.utils.apihandlers.crafttweaker.CTAction;
import com.google.common.collect.LinkedListMultimap;
import crafttweaker.CraftTweakerAPI;
import jackyy.integrationforegoing.integration.compat.crafttweaker.actions.CraftTweakerActionFermentationStation;
import jackyy.integrationforegoing.integration.compat.crafttweaker.actions.CraftTweakerActionFluidSievingMachine;
import jackyy.integrationforegoing.integration.compat.crafttweaker.actions.CraftTweakerActionWashingFactory;

public class CraftTweakerCompat {

    public static final LinkedListMultimap<CTAction, OreFluidEntryRaw> WASHING_FACTORY_ENTRIES = LinkedListMultimap.create();
    public static final LinkedListMultimap<CTAction, OreFluidEntryFermenter> FERMENTATION_STATION_ENTRIES = LinkedListMultimap.create();
    public static final LinkedListMultimap<CTAction, OreFluidEntrySieve> FLUID_SIEVING_MACHINE_ENTRIES = LinkedListMultimap.create();

    public static void init() {
        CraftTweakerAPI.registerClass(CraftTweakerActionWashingFactory.class);
        CraftTweakerAPI.registerClass(CraftTweakerActionFermentationStation.class);
        CraftTweakerAPI.registerClass(CraftTweakerActionFluidSievingMachine.class);
    }

    public static void parseActionEntries() {
        WASHING_FACTORY_ENTRIES.forEach((action, entry) -> {
            if (action == CTAction.ADD) IndustrialForegoingHelper.addOreFluidEntryRaw(entry);
            else IndustrialForegoingHelper.removeOreFluidEntryRaw(entry.getOre());
        });
        FERMENTATION_STATION_ENTRIES.forEach((action, entry) -> {
            if (action == CTAction.ADD) IndustrialForegoingHelper.addOreFluidEntryFermenter(entry);
            else IndustrialForegoingHelper.removeOreFluidEntryFermenter(entry.getInput());
        });
        FLUID_SIEVING_MACHINE_ENTRIES.forEach((action, entry) -> {
            if (action == CTAction.ADD) IndustrialForegoingHelper.addOreFluidEntrySieve(entry);
            else IndustrialForegoingHelper.removeOreFluidEntrySieve(entry.getOutput());
        });
    }

}
