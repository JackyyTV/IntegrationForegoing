package jackyy.integrationforegoing.util;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.MODID, name = "IntegrationForegoing", category = Reference.MODID)
public class ModConfig {

    public static Integrations integrations = new Integrations();
    public static Misc misc = new Misc();

    public static class Integrations {
        public boolean thermalFoundation = true;
        public boolean immersiveEngineering = true;
        public boolean mysticalAgriculture = true;
        public boolean mysticalAgradditions = true;
        public boolean tconstruct = true;
        public boolean oreberries = true;
        public boolean ae2 = true;
        public boolean rftools = true;
        public boolean evilcraft = true;
        public boolean actuallyAdditions = true;
        public boolean forestry = true;
        public boolean extraUtils2 = true;
        public boolean oreShrubs = true;
        public boolean harvestCraft = true;
        public boolean exNihiloCreatio = true;
        public boolean simpleCorn = true;
        public boolean natura = true;
        public boolean rustic = true;
        public boolean matterOverdrive = true;
        public boolean agriCraft = true;
        public boolean silentsGems = true;
        public boolean enderIO = true;
        public boolean immersivePetroleum = true;
        public boolean biomesoPlenty = true;
        public boolean astralSorcery = true;
        public boolean botania = true;
        public boolean nuclearCraft = true;
    }

    public static class Misc {
        public ThermalFoundation thermalFoundation = new ThermalFoundation();
        public static class ThermalFoundation {
            @Config.RangeInt(min = 64, max = 65536)
            @Config.Comment({
                    "This number determines the teleportation range for drinking Resonant Ender.",
                    "Range calculation method:",
                    "Player's X / Z position - (this number clamped between 8 and 65536) + (this number clamped between 8 and 65536) * 2"
            })
            public int strawEnderRange = 16384;
        }
        public ImmersiveEngineering immersiveEngineering = new ImmersiveEngineering();
        public static class ImmersiveEngineering {
            @Config.Comment({
                    "If true, both top and bottom blocks of Industrial Hemp gets harvested by the Plant Recollector.",
                    "Set to false if you only want the top block to be harvested."
            })
            public boolean hempHarvestBothBlocks = false;
            public GardenCloche gardenCloche = new GardenCloche();
            public static class GardenCloche {
                @Config.Comment("If true, allows Fertilizer from Industrial Foregoing to be used in Garden Cloche.")
                public boolean allowFertilizer = true;
                @Config.Comment("Set the growth multiplier for Fertilizer from Industrial Foregoing in Garden Cloche.")
                public float fertilizerGrowthMultiplier = 1.5f;
            }
        }
        public Natura natura = new Natura();
        public static class Natura {
            @Config.Comment("If true, replant is needed for Natura crops, otherwise Plant Gatherer won't remove the crops.")
            public boolean naturaCropsReplant = false;
        }
        public Rustic rustic = new Rustic();
        public static class Rustic {
            @Config.Comment("If true, replant is needed for Rustic herbs, otherwise Plant Gatherer won't remove the herbs.")
            public boolean rusticHerbsReplant = false;
        }
    }

    @Mod.EventBusSubscriber
    public static class ConfigHolder {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(Reference.MODID)) {
                ConfigManager.sync(Reference.MODID, Config.Type.INSTANCE);
            }
        }
    }

}
