package jackyy.integrationforegoing.integration;

import jackyy.integrationforegoing.integration.bioreactor.*;
import jackyy.integrationforegoing.integration.compat.crafttweaker.CraftTweakerCompat;
import jackyy.integrationforegoing.integration.plant.PlantRecollectableBotania;
import jackyy.integrationforegoing.integration.plant.PlantRecollectableImmersiveEngineering;
import jackyy.integrationforegoing.integration.proteinreactor.ProteinReactorHandlerExNihiloSequentia;
import jackyy.integrationforegoing.integration.straw.*;
import jackyy.integrationforegoing.util.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;

public class Integrations {

    public static void init() {
        if (ModConfigs.CONFIG.thermal.get() && ModList.get().isLoaded(ModNames.THERMAL)) {
            ModUtils.logIntegration(0, EnumIntegrations.STRAW, ModNames.THERMAL);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryThermal());
            ModUtils.logIntegration(1, EnumIntegrations.STRAW, ModNames.THERMAL);
        }
        if (ModConfigs.CONFIG.immersiveEngineering.get() && ModList.get().isLoaded(ModNames.IE)) {
            ModUtils.logIntegration(0, EnumIntegrations.STRAW, ModNames.IE);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryImmersiveEngineering());
            ModUtils.logIntegration(1, EnumIntegrations.STRAW, ModNames.IE);

            ModUtils.logIntegration(0, EnumIntegrations.PLANT, ModNames.IE);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableImmersiveEngineering());
            ModUtils.logIntegration(1, EnumIntegrations.PLANT, ModNames.IE);
        }
        if (ModConfigs.CONFIG.mysticalAgriculture.get() && ModList.get().isLoaded(ModNames.MAG)) {
            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.MAG);
            BioReactorHandlerMysticalAgriculture.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.MAG);
        }
        if (ModConfigs.CONFIG.mysticalAgradditions.get() && ModList.get().isLoaded(ModNames.MAD)) {
            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.MAD);
            BioReactorHandlerMysticalAgradditions.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.MAD);
        }
        if (ModConfigs.CONFIG.harvestCraft2Trees.get() && ModList.get().isLoaded(ModNames.HC2TREES)) {
            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.HC2TREES);
            BioReactorHandlerHC2Trees.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.HC2TREES);
        }
        if (ModConfigs.CONFIG.exNihiloSequentia.get() && ModList.get().isLoaded(ModNames.EXNIHILOSEQUENTIA)) {
            ModUtils.logIntegration(0, EnumIntegrations.STRAW, ModNames.EXNIHILOSEQUENTIA);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryExNihiloSequentia());
            ModUtils.logIntegration(1, EnumIntegrations.STRAW, ModNames.EXNIHILOSEQUENTIA);

            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.EXNIHILOSEQUENTIA);
            BioReactorHandlerExNihiloSequentia.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.EXNIHILOSEQUENTIA);

            ModUtils.logIntegration(0, EnumIntegrations.PROTEIN, ModNames.EXNIHILOSEQUENTIA);
            ProteinReactorHandlerExNihiloSequentia.init();
            ModUtils.logIntegration(1, EnumIntegrations.PROTEIN, ModNames.EXNIHILOSEQUENTIA);
        }
        if (ModConfigs.CONFIG.immersivePetroleum.get() && ModList.get().isLoaded(ModNames.IP)) {
            ModUtils.logIntegration(0, EnumIntegrations.STRAW, ModNames.IP);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryImmersivePetroleum());
            ModUtils.logIntegration(1, EnumIntegrations.STRAW, ModNames.IP);
        }
        if (ModConfigs.CONFIG.astralSorcery.get() && ModList.get().isLoaded(ModNames.AS)) {
            ModUtils.logIntegration(0, EnumIntegrations.STRAW, ModNames.AS);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryAstralSorcery());
            ModUtils.logIntegration(1, EnumIntegrations.STRAW, ModNames.AS);
        }
        if (ModConfigs.CONFIG.botania.get() && ModList.get().isLoaded(ModNames.BOTANIA)) {
            ModUtils.logIntegration(0, EnumIntegrations.PLANT, ModNames.BOTANIA);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableBotania());
            ModUtils.logIntegration(1, EnumIntegrations.PLANT, ModNames.BOTANIA);

            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.BOTANIA);
            BioReactorHandlerBotania.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.BOTANIA);
        }
        if (ModConfigs.CONFIG.craftTweaker.get() && ModList.get().isLoaded(ModNames.CT)) {
            Reference.LOGGER.info("Parsing CraftTweaker action entries...");
            CraftTweakerCompat.parseActionEntries();
            Reference.LOGGER.info("Parsed CraftTweaker action entries");
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static void initClient() {
    }

}
