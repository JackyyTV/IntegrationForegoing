package jackyy.integrationforegoing.integration;

import jackyy.integrationforegoing.IntegrationForegoing;
import jackyy.integrationforegoing.config.Config;
import jackyy.integrationforegoing.integration.bioreactor.*;
import jackyy.integrationforegoing.integration.compat.IFBookCompat;
import jackyy.integrationforegoing.integration.compat.TConstructCompat;
import jackyy.integrationforegoing.integration.laserdrill.*;
import jackyy.integrationforegoing.integration.plant.*;
import jackyy.integrationforegoing.integration.proteinreactor.ProteinReactorHandlerExNihiloCreatio;
import jackyy.integrationforegoing.integration.proteinreactor.ProteinReactorHandlerHarvestCraft;
import jackyy.integrationforegoing.integration.proteinreactor.ProteinReactorHandlerNatura;
import jackyy.integrationforegoing.integration.straw.StrawRegistryExNihiloCreatio;
import jackyy.integrationforegoing.integration.straw.StrawRegistryIE;
import jackyy.integrationforegoing.integration.straw.StrawRegistryTConstruct;
import jackyy.integrationforegoing.integration.straw.StrawRegistryThermalFoundation;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;

public class Integrations {

    public static void preInit() {
        if (Config.thermalFoundationIntegration && Loader.isModLoaded(ModNames.TF)) {
            ModUtils.logIntegration(0, "drink handlers", ModNames.TF);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryThermalFoundation());
            ModUtils.logIntegration(1, "drink handlers", ModNames.TF);
        }
        if (Config.immersiveEngineeringIntegration && Loader.isModLoaded(ModNames.IE)) {
            ModUtils.logIntegration(0, "drink handlers", ModNames.IE);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryIE());
            ModUtils.logIntegration(1, "drink handlers", ModNames.IE);

            ModUtils.logIntegration(0, "Plant Gatherer entries", ModNames.IE);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableIE());
            ModUtils.logIntegration(1, "Plant Gatherer entries", ModNames.IE);
        }
        if (Config.tconstructIntegration && Loader.isModLoaded(ModNames.TCON)) {
            IntegrationForegoing.logger.info("Pre-initialising integration for Tinkers' Construct...");
            TConstructCompat.preInit();
            IntegrationForegoing.logger.info("Pre-initialised integration for Tinkers' Construct");

            ModUtils.logIntegration(0, "drink handlers", ModNames.TCON);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryTConstruct());
            ModUtils.logIntegration(1, "drink handlers", ModNames.TCON);
        }
        if (Config.oreberriesIntegration && Loader.isModLoaded(ModNames.OREBERRIES)) {
            ModUtils.logIntegration(0, "Plant Gatherer entries", ModNames.OREBERRIES);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableOreberries());
            ModUtils.logIntegration(1, "Plant Gatherer entries", ModNames.OREBERRIES);
        }
        if (Config.extraUtils2Integration && Loader.isModLoaded(ModNames.XU2)) {
            ModUtils.logIntegration(0, "Plant Gatherer entries", ModNames.XU2);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableExtraUtilities2());
            ModUtils.logIntegration(1, "Plant Gatherer entries", ModNames.XU2);
        }
        if (Config.oreShrubsIntegration && Loader.isModLoaded(ModNames.ORESHRUBS)) {
            ModUtils.logIntegration(0, "Plant Gatherer entries", ModNames.ORESHRUBS);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableOreShrubs());
            ModUtils.logIntegration(1, "Plant Gatherer entries", ModNames.ORESHRUBS);
        }
        if (Config.exNihiloCreatioIntegration && Loader.isModLoaded(ModNames.EXNIHILOCREATIO)) {
            ModUtils.logIntegration(0, "drink handlers", ModNames.EXNIHILOCREATIO);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryExNihiloCreatio());
            ModUtils.logIntegration(1, "drink handlers", ModNames.EXNIHILOCREATIO);
        }
        if (Config.simpleCornIntegration && Loader.isModLoaded(ModNames.SIMPLECORN)) {
            ModUtils.logIntegration(0, "Plant Gatherer entries", ModNames.SIMPLECORN);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableSimpleCorn());
            ModUtils.logIntegration(1, "Plant Gatherer entries", ModNames.SIMPLECORN);
        }
        if (Config.naturaIntegration && Loader.isModLoaded(ModNames.NATURA)) {
            ModUtils.logIntegration(0, "drink handlers", ModNames.NATURA);
            MinecraftForge.EVENT_BUS.register(new PlantRecollectableNatura());
            ModUtils.logIntegration(1, "drink handlers", ModNames.NATURA);
        }
    }

    public static void init() {
        IntegrationForegoing.logger.info("Registering Guide Book entries...");
        IFBookCompat.init();
        IntegrationForegoing.logger.info("Registered Guide Book entries");
        if (Config.thermalFoundationIntegration && Loader.isModLoaded(ModNames.TF)) {
            ModUtils.logIntegration(0, "Laser Drill entries", ModNames.TF);
            LaserDrillHandlerThermalFoundation.init();
            ModUtils.logIntegration(1, "Laser Drill entries", ModNames.TF);
        }
        if (Config.immersiveEngineeringIntegration && Loader.isModLoaded(ModNames.IE)) {
            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.IE);
            BioReactorHandlerIE.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.IE);
        }
        if (Config.mysticalAgricultureIntegration && Loader.isModLoaded(ModNames.MAG)) {
            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.MAG);
            BioReactorHandlerMysticalAgriculture.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.MAG);

            ModUtils.logIntegration(0, "Laser Drill entries", ModNames.MAG);
            LaserDrillHandlerMysticalAgriculture.init();
            ModUtils.logIntegration(1, "Laser Drill entries", ModNames.MAG);
        }
        if (Config.mysticalAgradditionsIntegration && Loader.isModLoaded(ModNames.MAD)) {
            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.MAD);
            BioReactorHandlerMysticalAgradditions.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.MAD);
        }
        if (Config.tconstructIntegration && Loader.isModLoaded(ModNames.TCON)) {
            IntegrationForegoing.logger.info("Initialising integration for Tinkers' Construct...");
            TConstructCompat.init();
            IntegrationForegoing.logger.info("Initialised integration for Tinkers' Construct");

            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.TCON);
            BioReactorHandlerTConstruct.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.TCON);
        }
        if (Config.ae2Integration && Loader.isModLoaded(ModNames.AE2)) {
            ModUtils.logIntegration(0, "Laser Drill entries", ModNames.AE2);
            LaserDrillHandlerAE2.init();
            ModUtils.logIntegration(1, "Laser Drill entries", ModNames.AE2);
        }
        if (Config.rftoolsIntegration && Loader.isModLoaded(ModNames.RFTOOLS)) {
            ModUtils.logIntegration(0, "Laser Drill entries", ModNames.RFTOOLS);
            LaserDrillHandlerRFTools.init();
            ModUtils.logIntegration(1, "Laser Drill entries", ModNames.RFTOOLS);
        }
        if (Config.evilcraftIntegration && Loader.isModLoaded(ModNames.EVILCRAFT)) {
            ModUtils.logIntegration(0, "Laser Drill entries", ModNames.EVILCRAFT);
            LaserDrillHandlerEvilCraft.init();
            ModUtils.logIntegration(1, "Laser Drill entries", ModNames.EVILCRAFT);

            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.EVILCRAFT);
            BioReactorHandlerEvilCraft.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.EVILCRAFT);
        }
        if (Config.actuallyAdditionsIntegration && Loader.isModLoaded(ModNames.AA)) {
            ModUtils.logIntegration(0, "Laser Drill entries", ModNames.AA);
            LaserDrillHandlerActuallyAdditions.init();
            ModUtils.logIntegration(1, "Laser Drill entries", ModNames.AA);

            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.AA);
            BioReactorHandlerActuallyAdditions.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.AA);
        }
        if (Config.forestryIntegration && Loader.isModLoaded(ModNames.FORESTRY)) {
            ModUtils.logIntegration(0, "Laser Drill entries", ModNames.FORESTRY);
            LaserDrillHandlerForestry.init();
            ModUtils.logIntegration(1, "Laser Drill entries", ModNames.FORESTRY);
        }
        if (Config.harvestCraftIntegration && Loader.isModLoaded(ModNames.HARVESTCRAFT)) {
            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.HARVESTCRAFT);
            BioReactorHandlerHarvestCraft.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.HARVESTCRAFT);

            ModUtils.logIntegration(0, "Protein Reactor entries", ModNames.HARVESTCRAFT);
            ProteinReactorHandlerHarvestCraft.init();
            ModUtils.logIntegration(1, "Protein Reactor entries", ModNames.HARVESTCRAFT);
        }
        if (Config.exNihiloCreatioIntegration && Loader.isModLoaded(ModNames.EXNIHILOCREATIO)) {
            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.EXNIHILOCREATIO);
            BioReactorHandlerExNihiloCreatio.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.EXNIHILOCREATIO);

            ModUtils.logIntegration(0, "Protein Reactor entries", ModNames.EXNIHILOCREATIO);
            ProteinReactorHandlerExNihiloCreatio.init();
            ModUtils.logIntegration(1, "Protein Reactor entries", ModNames.EXNIHILOCREATIO);
        }
        if (Config.simpleCornIntegration && Loader.isModLoaded(ModNames.SIMPLECORN)) {
            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.SIMPLECORN);
            BioReactorHandlerSimpleCorn.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.SIMPLECORN);
        }
        if (Config.naturaIntegration && Loader.isModLoaded(ModNames.NATURA)) {
            ModUtils.logIntegration(0, "Bioreactor entries", ModNames.NATURA);
            BioReactorHandlerNatura.init();
            ModUtils.logIntegration(1, "Bioreactor entries", ModNames.NATURA);

            ModUtils.logIntegration(0, "Protein Reactor entries", ModNames.NATURA);
            ProteinReactorHandlerNatura.init();
            ModUtils.logIntegration(1, "Protein Reactor entries", ModNames.NATURA);
        }
    }

}
