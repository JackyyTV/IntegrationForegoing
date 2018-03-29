package jackyy.integrationforegoing.integration;

import jackyy.integrationforegoing.IntegrationForegoing;
import jackyy.integrationforegoing.integration.bioreactor.*;
import jackyy.integrationforegoing.integration.compat.IEGardenClocheCompat;
import jackyy.integrationforegoing.integration.compat.IFBookCompat;
import jackyy.integrationforegoing.integration.compat.TConstructCompat;
import jackyy.integrationforegoing.integration.laserdrill.*;
import jackyy.integrationforegoing.integration.plant.*;
import jackyy.integrationforegoing.integration.proteinreactor.ProteinReactorHandlerExNihiloCreatio;
import jackyy.integrationforegoing.integration.proteinreactor.ProteinReactorHandlerHarvestCraft;
import jackyy.integrationforegoing.integration.proteinreactor.ProteinReactorHandlerNatura;
import jackyy.integrationforegoing.integration.straw.*;
import jackyy.integrationforegoing.util.ModConfig;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;

public class Integrations {

    public static void preInit() {
        if (ModConfig.integrations.thermalFoundation && Loader.isModLoaded(ModNames.TF)) {
            ModUtils.logIntegration(0, "drink handlers", ModNames.TF);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryThermalFoundation());
            ModUtils.logIntegration(1, "drink handlers", ModNames.TF);
        }
        if (ModConfig.integrations.immersiveEngineering && Loader.isModLoaded(ModNames.IE)) {
            ModUtils.logIntegration(0, "drink handlers", ModNames.IE);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryIE());
            ModUtils.logIntegration(1, "drink handlers", ModNames.IE);

            ModUtils.logIntegration(0, "Plant Gatherer entries", ModNames.IE);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableIE());
            ModUtils.logIntegration(1, "Plant Gatherer entries", ModNames.IE);
        }
        if (ModConfig.integrations.tconstruct && Loader.isModLoaded(ModNames.TCON)) {
            IntegrationForegoing.logger.info("Pre-initialising integration for Tinkers' Construct...");
            TConstructCompat.preInit();
            IntegrationForegoing.logger.info("Pre-initialised integration for Tinkers' Construct");

            ModUtils.logIntegration(0, "drink handlers", ModNames.TCON);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryTConstruct());
            ModUtils.logIntegration(1, "drink handlers", ModNames.TCON);
        }
        if (ModConfig.integrations.oreberries && Loader.isModLoaded(ModNames.OREBERRIES)) {
            ModUtils.logIntegration(0, "Plant Gatherer entries", ModNames.OREBERRIES);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableOreberries());
            ModUtils.logIntegration(1, "Plant Gatherer entries", ModNames.OREBERRIES);
        }
        if (ModConfig.integrations.extraUtils2 && Loader.isModLoaded(ModNames.XU2)) {
            ModUtils.logIntegration(0, "Plant Gatherer entries", ModNames.XU2);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableExtraUtilities2());
            ModUtils.logIntegration(1, "Plant Gatherer entries", ModNames.XU2);
        }
        if (ModConfig.integrations.oreShrubs && Loader.isModLoaded(ModNames.ORESHRUBS)) {
            ModUtils.logIntegration(0, "Plant Gatherer entries", ModNames.ORESHRUBS);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableOreShrubs());
            ModUtils.logIntegration(1, "Plant Gatherer entries", ModNames.ORESHRUBS);
        }
        if (ModConfig.integrations.exNihiloCreatio && Loader.isModLoaded(ModNames.EXNIHILOCREATIO)) {
            ModUtils.logIntegration(0, "drink handlers", ModNames.EXNIHILOCREATIO);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryExNihiloCreatio());
            ModUtils.logIntegration(1, "drink handlers", ModNames.EXNIHILOCREATIO);
        }
        if (ModConfig.integrations.natura && Loader.isModLoaded(ModNames.NATURA)) {
            ModUtils.logIntegration(0, "Plant Gatherer entries", ModNames.NATURA);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableNatura());
            ModUtils.logIntegration(1, "Plant Gatherer entries", ModNames.NATURA);
        }
        if (ModConfig.integrations.rustic && Loader.isModLoaded(ModNames.RUSTIC)) {
            ModUtils.logIntegration(0, "drink handlers", ModNames.RUSTIC);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryRustic());
            ModUtils.logIntegration(1, "drink handlers", ModNames.RUSTIC);

            ModUtils.logIntegration(0, "Plant Gatherer entries", ModNames.RUSTIC);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableRustic());
            ModUtils.logIntegration(1, "Plant Gatherer entries", ModNames.RUSTIC);
        }
    }

    public static void init() {
        IntegrationForegoing.logger.info("Registering Guide Book entries...");
        IFBookCompat.init();
        IntegrationForegoing.logger.info("Registered Guide Book entries");
        if (ModConfig.integrations.thermalFoundation && Loader.isModLoaded(ModNames.TF)) {
            ModUtils.logIntegration(0, "Laser Drill entries", ModNames.TF);
            LaserDrillHandlerThermalFoundation.init();
            ModUtils.logIntegration(1, "Laser Drill entries", ModNames.TF);
        }
        if (ModConfig.integrations.immersiveEngineering && Loader.isModLoaded(ModNames.IE)) {
            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.IE);
            BioReactorHandlerIE.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.IE);

            ModUtils.logIntegration(0, "Garden Cloche integration", ModNames.IE);
            IEGardenClocheCompat.init();
            ModUtils.logIntegration(1, "Garden Cloche integration", ModNames.IE);
        }
        if (ModConfig.integrations.mysticalAgriculture && Loader.isModLoaded(ModNames.MAG)) {
            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.MAG);
            BioReactorHandlerMysticalAgriculture.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.MAG);

            ModUtils.logIntegration(0, "Laser Drill entries", ModNames.MAG);
            LaserDrillHandlerMysticalAgriculture.init();
            ModUtils.logIntegration(1, "Laser Drill entries", ModNames.MAG);
        }
        if (ModConfig.integrations.mysticalAgradditions && Loader.isModLoaded(ModNames.MAD)) {
            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.MAD);
            BioReactorHandlerMysticalAgradditions.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.MAD);
        }
        if (ModConfig.integrations.tconstruct && Loader.isModLoaded(ModNames.TCON)) {
            IntegrationForegoing.logger.info("Initialising integration for Tinkers' Construct...");
            TConstructCompat.init();
            IntegrationForegoing.logger.info("Initialised integration for Tinkers' Construct");

            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.TCON);
            BioReactorHandlerTConstruct.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.TCON);
        }
        if (ModConfig.integrations.ae2 && Loader.isModLoaded(ModNames.AE2)) {
            ModUtils.logIntegration(0, "Laser Drill entries", ModNames.AE2);
            LaserDrillHandlerAE2.init();
            ModUtils.logIntegration(1, "Laser Drill entries", ModNames.AE2);
        }
        if (ModConfig.integrations.rftools && Loader.isModLoaded(ModNames.RFTOOLS)) {
            ModUtils.logIntegration(0, "Laser Drill entries", ModNames.RFTOOLS);
            LaserDrillHandlerRFTools.init();
            ModUtils.logIntegration(1, "Laser Drill entries", ModNames.RFTOOLS);
        }
        if (ModConfig.integrations.evilcraft && Loader.isModLoaded(ModNames.EVILCRAFT)) {
            ModUtils.logIntegration(0, "Laser Drill entries", ModNames.EVILCRAFT);
            LaserDrillHandlerEvilCraft.init();
            ModUtils.logIntegration(1, "Laser Drill entries", ModNames.EVILCRAFT);

            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.EVILCRAFT);
            BioReactorHandlerEvilCraft.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.EVILCRAFT);
        }
        if (ModConfig.integrations.actuallyAdditions && Loader.isModLoaded(ModNames.AA)) {
            ModUtils.logIntegration(0, "Laser Drill entries", ModNames.AA);
            LaserDrillHandlerActuallyAdditions.init();
            ModUtils.logIntegration(1, "Laser Drill entries", ModNames.AA);

            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.AA);
            BioReactorHandlerActuallyAdditions.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.AA);
        }
        if (ModConfig.integrations.forestry && Loader.isModLoaded(ModNames.FORESTRY)) {
            ModUtils.logIntegration(0, "Laser Drill entries", ModNames.FORESTRY);
            LaserDrillHandlerForestry.init();
            ModUtils.logIntegration(1, "Laser Drill entries", ModNames.FORESTRY);
        }
        if (ModConfig.integrations.harvestCraft && Loader.isModLoaded(ModNames.HARVESTCRAFT)) {
            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.HARVESTCRAFT);
            BioReactorHandlerHarvestCraft.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.HARVESTCRAFT);

            ModUtils.logIntegration(0, "Protein Reactor entries", ModNames.HARVESTCRAFT);
            ProteinReactorHandlerHarvestCraft.init();
            ModUtils.logIntegration(1, "Protein Reactor entries", ModNames.HARVESTCRAFT);
        }
        if (ModConfig.integrations.exNihiloCreatio && Loader.isModLoaded(ModNames.EXNIHILOCREATIO)) {
            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.EXNIHILOCREATIO);
            BioReactorHandlerExNihiloCreatio.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.EXNIHILOCREATIO);

            ModUtils.logIntegration(0, "Protein Reactor entries", ModNames.EXNIHILOCREATIO);
            ProteinReactorHandlerExNihiloCreatio.init();
            ModUtils.logIntegration(1, "Protein Reactor entries", ModNames.EXNIHILOCREATIO);
        }
        if (ModConfig.integrations.simpleCorn && Loader.isModLoaded(ModNames.SIMPLECORN)) {
            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.SIMPLECORN);
            BioReactorHandlerSimpleCorn.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.SIMPLECORN);
        }
        if (ModConfig.integrations.natura && Loader.isModLoaded(ModNames.NATURA)) {
            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.NATURA);
            BioReactorHandlerNatura.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.NATURA);

            ModUtils.logIntegration(0, "Protein Reactor entries", ModNames.NATURA);
            ProteinReactorHandlerNatura.init();
            ModUtils.logIntegration(1, "Protein Reactor entries", ModNames.NATURA);
        }
        if (ModConfig.integrations.rustic && Loader.isModLoaded(ModNames.RUSTIC)) {
            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.RUSTIC);
            BioReactorHandlerRustic.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.RUSTIC);
        }
        if (ModConfig.integrations.matterOverdrive && Loader.isModLoaded(ModNames.MATTEROVERDRIVE)) {
            ModUtils.logIntegration(0, "Laser Drill entries", ModNames.MATTEROVERDRIVE);
            LaserDrillHandlerMatterOverdrive.init();
            ModUtils.logIntegration(1, "Laser Drill entries", ModNames.MATTEROVERDRIVE);
        }
    }

}
