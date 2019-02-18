package jackyy.integrationforegoing.integration;

import jackyy.integrationforegoing.integration.bioreactor.*;
import jackyy.integrationforegoing.integration.compat.IEGardenClocheCompat;
import jackyy.integrationforegoing.integration.compat.IFBookCompat;
import jackyy.integrationforegoing.integration.compat.TConstructCompat;
import jackyy.integrationforegoing.integration.plant.*;
import jackyy.integrationforegoing.integration.proteinreactor.ProteinReactorHandlerExNihiloCreatio;
import jackyy.integrationforegoing.integration.proteinreactor.ProteinReactorHandlerHarvestCraft;
import jackyy.integrationforegoing.integration.proteinreactor.ProteinReactorHandlerNatura;
import jackyy.integrationforegoing.integration.straw.*;
import jackyy.integrationforegoing.util.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Integrations {

    public static void preInit(FMLPreInitializationEvent event) {
        if (ModConfig.integrations.thermalFoundation && Loader.isModLoaded(ModNames.TF)) {
            ModUtils.logIntegration(0, EnumIntegrations.STRAW, ModNames.TF);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryThermalFoundation());
            ModUtils.logIntegration(1, EnumIntegrations.STRAW, ModNames.TF);

            ModUtils.logIntegration(0, EnumIntegrations.LASERDRILL, ModNames.TF);
            ModUtils.loadLaserDrillFile(ModNames.TF);
            ModUtils.logIntegration(1, EnumIntegrations.LASERDRILL, ModNames.TF);
        } else if (!ModConfig.integrations.thermalFoundation) {
            ModUtils.deleteExistingLaserDrillFile(event.getModConfigurationDirectory(), ModNames.TF);
        }
        if (ModConfig.integrations.immersiveEngineering && Loader.isModLoaded(ModNames.IE)) {
            ModUtils.logIntegration(0, EnumIntegrations.STRAW, ModNames.IE);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryImmersiveEngineering());
            ModUtils.logIntegration(1, EnumIntegrations.STRAW, ModNames.IE);

            ModUtils.logIntegration(0, EnumIntegrations.PLANT, ModNames.IE);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableImmersiveEngineering());
            ModUtils.logIntegration(1, EnumIntegrations.PLANT, ModNames.IE);
        }
        if (ModConfig.integrations.tconstruct && Loader.isModLoaded(ModNames.TCON)) {
            Reference.LOGGER.info("Pre-initialising integration for Tinkers' Construct...");
            TConstructCompat.preInit();
            Reference.LOGGER.info("Pre-initialised integration for Tinkers' Construct");

            ModUtils.logIntegration(0, EnumIntegrations.STRAW, ModNames.TCON);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryTConstruct());
            ModUtils.logIntegration(1, EnumIntegrations.STRAW, ModNames.TCON);
        }
        if (ModConfig.integrations.mysticalAgriculture && Loader.isModLoaded(ModNames.MAG)) {
            ModUtils.logIntegration(0, EnumIntegrations.LASERDRILL, ModNames.MAG);
            ModUtils.loadLaserDrillFile(ModNames.MAG);
            ModUtils.logIntegration(1, EnumIntegrations.LASERDRILL, ModNames.MAG);
        } else if (!ModConfig.integrations.mysticalAgriculture) {
            ModUtils.deleteExistingLaserDrillFile(event.getModConfigurationDirectory(), ModNames.MAG);
        }
        if (ModConfig.integrations.oreberries && Loader.isModLoaded(ModNames.OREBERRIES)) {
            ModUtils.logIntegration(0, EnumIntegrations.PLANT, ModNames.OREBERRIES);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableOreberries());
            ModUtils.logIntegration(1, EnumIntegrations.PLANT, ModNames.OREBERRIES);
        }
        if (ModConfig.integrations.ae2 && Loader.isModLoaded(ModNames.AE2)) {
            ModUtils.logIntegration(0, EnumIntegrations.LASERDRILL, ModNames.AE2);
            ModUtils.loadLaserDrillFile(ModNames.AE2);
            ModUtils.logIntegration(1, EnumIntegrations.LASERDRILL, ModNames.AE2);
        } else if (!ModConfig.integrations.ae2) {
            ModUtils.deleteExistingLaserDrillFile(event.getModConfigurationDirectory(), ModNames.AE2);
        }
        if (ModConfig.integrations.rftools && Loader.isModLoaded(ModNames.RFTOOLS)) {
            ModUtils.logIntegration(0, EnumIntegrations.LASERDRILL, ModNames.RFTOOLS);
            ModUtils.loadLaserDrillFile(ModNames.RFTOOLS);
            ModUtils.logIntegration(1, EnumIntegrations.LASERDRILL, ModNames.RFTOOLS);
        } else if (!ModConfig.integrations.rftools) {
            ModUtils.deleteExistingLaserDrillFile(event.getModConfigurationDirectory(), ModNames.RFTOOLS);
        }
        if (ModConfig.integrations.evilcraft && Loader.isModLoaded(ModNames.EVILCRAFT)) {
            ModUtils.logIntegration(0, EnumIntegrations.LASERDRILL, ModNames.EVILCRAFT);
            ModUtils.loadLaserDrillFile(ModNames.EVILCRAFT);
            ModUtils.logIntegration(1, EnumIntegrations.LASERDRILL, ModNames.EVILCRAFT);
        } else if (!ModConfig.integrations.evilcraft) {
            ModUtils.deleteExistingLaserDrillFile(event.getModConfigurationDirectory(), ModNames.EVILCRAFT);
        }
        if (ModConfig.integrations.actuallyAdditions && Loader.isModLoaded(ModNames.AA)) {
            ModUtils.logIntegration(0, EnumIntegrations.LASERDRILL, ModNames.AA);
            ModUtils.loadLaserDrillFile(ModNames.AA);
            ModUtils.logIntegration(1, EnumIntegrations.LASERDRILL, ModNames.AA);
        } else if (!ModConfig.integrations.actuallyAdditions) {
            ModUtils.deleteExistingLaserDrillFile(event.getModConfigurationDirectory(), ModNames.AA);
        }
        if (ModConfig.integrations.forestry && Loader.isModLoaded(ModNames.FORESTRY)) {
            ModUtils.logIntegration(0, EnumIntegrations.LASERDRILL, ModNames.FORESTRY);
            ModUtils.loadLaserDrillFile(ModNames.FORESTRY);
            ModUtils.logIntegration(1, EnumIntegrations.LASERDRILL, ModNames.FORESTRY);
        } else if (!ModConfig.integrations.forestry) {
            ModUtils.deleteExistingLaserDrillFile(event.getModConfigurationDirectory(), ModNames.FORESTRY);
        }
        if (ModConfig.integrations.extraUtils2 && Loader.isModLoaded(ModNames.XU2)) {
            ModUtils.logIntegration(0, EnumIntegrations.PLANT, ModNames.XU2);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableExtraUtilities2());
            ModUtils.logIntegration(1, EnumIntegrations.PLANT, ModNames.XU2);
        }
        if (ModConfig.integrations.oreShrubs && Loader.isModLoaded(ModNames.ORESHRUBS)) {
            ModUtils.logIntegration(0, EnumIntegrations.PLANT, ModNames.ORESHRUBS);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableOreShrubs());
            ModUtils.logIntegration(1, EnumIntegrations.PLANT, ModNames.ORESHRUBS);
        }
        if (ModConfig.integrations.exNihiloCreatio && Loader.isModLoaded(ModNames.EXNIHILOCREATIO)) {
            ModUtils.logIntegration(0, EnumIntegrations.STRAW, ModNames.EXNIHILOCREATIO);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryExNihiloCreatio());
            ModUtils.logIntegration(1, EnumIntegrations.STRAW, ModNames.EXNIHILOCREATIO);
        }
        if (ModConfig.integrations.natura && Loader.isModLoaded(ModNames.NATURA)) {
            ModUtils.logIntegration(0, EnumIntegrations.PLANT, ModNames.NATURA);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableNatura());
            ModUtils.logIntegration(1, EnumIntegrations.PLANT, ModNames.NATURA);
        }
        if (ModConfig.integrations.rustic && Loader.isModLoaded(ModNames.RUSTIC)) {
            ModUtils.logIntegration(0, EnumIntegrations.STRAW, ModNames.RUSTIC);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryRustic());
            ModUtils.logIntegration(1, EnumIntegrations.STRAW, ModNames.RUSTIC);

            ModUtils.logIntegration(0, EnumIntegrations.PLANT, ModNames.RUSTIC);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableRustic());
            ModUtils.logIntegration(1, EnumIntegrations.PLANT, ModNames.RUSTIC);
        }
        if (ModConfig.integrations.matterOverdrive && Loader.isModLoaded(ModNames.MATTEROVERDRIVE)) {
            ModUtils.logIntegration(0, EnumIntegrations.LASERDRILL, ModNames.MATTEROVERDRIVE);
            ModUtils.loadLaserDrillFile(ModNames.MATTEROVERDRIVE);
            ModUtils.logIntegration(1, EnumIntegrations.LASERDRILL, ModNames.MATTEROVERDRIVE);
        } else if (!ModConfig.integrations.matterOverdrive) {
            ModUtils.deleteExistingLaserDrillFile(event.getModConfigurationDirectory(), ModNames.MATTEROVERDRIVE);
        }
        if (ModConfig.integrations.agriCraft && Loader.isModLoaded(ModNames.AGRICRAFT)) {
            ModUtils.logIntegration(0, EnumIntegrations.PLANT, ModNames.AGRICRAFT);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableAgriCraft());
            ModUtils.logIntegration(1, EnumIntegrations.PLANT, ModNames.AGRICRAFT);
        }
        if (ModConfig.integrations.silentsGems && Loader.isModLoaded(ModNames.SILENTSGEMS)) {
            ModUtils.logIntegration(0, EnumIntegrations.LASERDRILL, ModNames.SILENTSGEMS);
            ModUtils.loadLaserDrillFile(ModNames.SILENTSGEMS);
            ModUtils.logIntegration(1, EnumIntegrations.LASERDRILL, ModNames.SILENTSGEMS);
        } else if (!ModConfig.integrations.silentsGems) {
            ModUtils.deleteExistingLaserDrillFile(event.getModConfigurationDirectory(), ModNames.SILENTSGEMS);
        }
        if (ModConfig.integrations.enderIO && Loader.isModLoaded(ModNames.ENDERIO)) {
            ModUtils.logIntegration(0, EnumIntegrations.STRAW, ModNames.ENDERIO);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryEnderIO());
            ModUtils.logIntegration(1, EnumIntegrations.STRAW, ModNames.ENDERIO);
        }
        if (ModConfig.integrations.immersivePetroleum && Loader.isModLoaded(ModNames.IP)) {
            ModUtils.logIntegration(0, EnumIntegrations.STRAW, ModNames.IP);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryImmersivePetroleum());
            ModUtils.logIntegration(1, EnumIntegrations.STRAW, ModNames.IP);
        }
        if (ModConfig.integrations.biomesoPlenty && Loader.isModLoaded(ModNames.BIOMESOP)) {
            ModUtils.logIntegration(0, EnumIntegrations.STRAW, ModNames.BIOMESOP);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryBiomesOPlenty());
            ModUtils.logIntegration(1, EnumIntegrations.STRAW, ModNames.BIOMESOP);

            ModUtils.logIntegration(0, EnumIntegrations.LASERDRILL, ModNames.BIOMESOP);
            ModUtils.loadLaserDrillFile(ModNames.BIOMESOP);
            ModUtils.logIntegration(1, EnumIntegrations.LASERDRILL, ModNames.BIOMESOP);
        } else if (!ModConfig.integrations.biomesoPlenty) {
            ModUtils.deleteExistingLaserDrillFile(event.getModConfigurationDirectory(), ModNames.BIOMESOP);
        }
        if (ModConfig.integrations.astralSorcery && Loader.isModLoaded(ModNames.AS)) {
            ModUtils.logIntegration(0, EnumIntegrations.STRAW, ModNames.AS);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryAstralSorcery());
            ModUtils.logIntegration(1, EnumIntegrations.STRAW, ModNames.AS);

            ModUtils.logIntegration(0, EnumIntegrations.LASERDRILL, ModNames.AS);
            ModUtils.loadLaserDrillFile(ModNames.AS);
            ModUtils.logIntegration(1, EnumIntegrations.LASERDRILL, ModNames.AS);
        } else if (!ModConfig.integrations.astralSorcery) {
            ModUtils.deleteExistingLaserDrillFile(event.getModConfigurationDirectory(), ModNames.AS);
        }
        if (ModConfig.integrations.botania && Loader.isModLoaded(ModNames.BOTANIA)) {
            ModUtils.logIntegration(0, EnumIntegrations.PLANT, ModNames.BOTANIA);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableBotania());
            ModUtils.logIntegration(1, EnumIntegrations.PLANT, ModNames.BOTANIA);
        }
        if (ModConfig.integrations.nuclearCraft && Loader.isModLoaded(ModNames.NUCLEARCRAFT)) {
            ModUtils.logIntegration(0, EnumIntegrations.LASERDRILL, ModNames.NUCLEARCRAFT);
            ModUtils.loadLaserDrillFile(ModNames.NUCLEARCRAFT);
            ModUtils.logIntegration(1, EnumIntegrations.LASERDRILL, ModNames.NUCLEARCRAFT);
        } else if (!ModConfig.integrations.nuclearCraft) {
            ModUtils.deleteExistingLaserDrillFile(event.getModConfigurationDirectory(), ModNames.NUCLEARCRAFT);
        }
    }

    public static void init() {
        Reference.LOGGER.info("Registering Guide Book entries...");
        IFBookCompat.init();
        Reference.LOGGER.info("Registered Guide Book entries");
        if (ModConfig.integrations.immersiveEngineering && Loader.isModLoaded(ModNames.IE)) {
            Reference.LOGGER.info("Initialising Garden Cloche integration for Immersive Engineering...");
            IEGardenClocheCompat.init();
            Reference.LOGGER.info("Initialised Garden Cloche integration for Immersive Engineering");

            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.IE);
            BioReactorHandlerImmersiveEngineering.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.IE);
        }
        if (ModConfig.integrations.tconstruct && Loader.isModLoaded(ModNames.TCON)) {
            Reference.LOGGER.info("Initialising integration for Tinkers' Construct...");
            TConstructCompat.init();
            Reference.LOGGER.info("Initialised integration for Tinkers' Construct");

            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.TCON);
            BioReactorHandlerTConstruct.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.TCON);
        }
        if (ModConfig.integrations.mysticalAgriculture && Loader.isModLoaded(ModNames.MAG)) {
            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.MAG);
            BioReactorHandlerMysticalAgriculture.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.MAG);
        }
        if (ModConfig.integrations.mysticalAgradditions && Loader.isModLoaded(ModNames.MAD)) {
            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.MAD);
            BioReactorHandlerMysticalAgradditions.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.MAD);
        }
        if (ModConfig.integrations.evilcraft && Loader.isModLoaded(ModNames.EVILCRAFT)) {
            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.EVILCRAFT);
            BioReactorHandlerEvilCraft.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.EVILCRAFT);
        }
        if (ModConfig.integrations.actuallyAdditions && Loader.isModLoaded(ModNames.AA)) {
            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.AA);
            BioReactorHandlerActuallyAdditions.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.AA);
        }
        if (ModConfig.integrations.harvestCraft && Loader.isModLoaded(ModNames.HARVESTCRAFT)) {
            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.HARVESTCRAFT);
            BioReactorHandlerHarvestCraft.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.HARVESTCRAFT);

            ModUtils.logIntegration(0, EnumIntegrations.PROTEIN, ModNames.HARVESTCRAFT);
            ProteinReactorHandlerHarvestCraft.init();
            ModUtils.logIntegration(1, EnumIntegrations.PROTEIN, ModNames.HARVESTCRAFT);
        }
        if (ModConfig.integrations.exNihiloCreatio && Loader.isModLoaded(ModNames.EXNIHILOCREATIO)) {
            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.EXNIHILOCREATIO);
            BioReactorHandlerExNihiloCreatio.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.EXNIHILOCREATIO);

            ModUtils.logIntegration(0, EnumIntegrations.PROTEIN, ModNames.EXNIHILOCREATIO);
            ProteinReactorHandlerExNihiloCreatio.init();
            ModUtils.logIntegration(1, EnumIntegrations.PROTEIN, ModNames.EXNIHILOCREATIO);
        }
        if (ModConfig.integrations.simpleCorn && Loader.isModLoaded(ModNames.SIMPLECORN)) {
            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.SIMPLECORN);
            BioReactorHandlerSimpleCorn.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.SIMPLECORN);
        }
        if (ModConfig.integrations.natura && Loader.isModLoaded(ModNames.NATURA)) {
            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.NATURA);
            BioReactorHandlerNatura.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.NATURA);

            ModUtils.logIntegration(0, EnumIntegrations.PROTEIN, ModNames.NATURA);
            ProteinReactorHandlerNatura.init();
            ModUtils.logIntegration(1, EnumIntegrations.PROTEIN, ModNames.NATURA);
        }
        if (ModConfig.integrations.rustic && Loader.isModLoaded(ModNames.RUSTIC)) {
            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.RUSTIC);
            BioReactorHandlerRustic.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.RUSTIC);
        }
        if (ModConfig.integrations.agriCraft && Loader.isModLoaded(ModNames.AGRICRAFT)) {
            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.AGRICRAFT);
            BioReactorHandlerAgriCraft.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.AGRICRAFT);
        }
        if (ModConfig.integrations.silentsGems && Loader.isModLoaded(ModNames.SILENTSGEMS)) {
            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.SILENTSGEMS);
            BioReactorHandlerSilentsGems.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.SILENTSGEMS);
        }
        if (ModConfig.integrations.biomesoPlenty && Loader.isModLoaded(ModNames.BIOMESOP)) {
            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.BIOMESOP);
            BioReactorHandlerBiomesOPlenty.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.BIOMESOP);
        }
        if (ModConfig.integrations.botania && Loader.isModLoaded(ModNames.BOTANIA)) {
            ModUtils.logIntegration(0, EnumIntegrations.BIOREACTOR, ModNames.BOTANIA);
            BioReactorHandlerBotania.init();
            ModUtils.logIntegration(1, EnumIntegrations.BIOREACTOR, ModNames.BOTANIA);
        }
    }

    @SideOnly(Side.CLIENT)
    public static void preInitClient() {
        if (ModConfig.integrations.tconstruct && Loader.isModLoaded(ModNames.TCON)) {
            TConstructCompat.initClient();
        }
    }

}
