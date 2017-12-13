package jackyy.integrationforegoing.util;

import jackyy.integrationforegoing.IntegrationForegoing;
import jackyy.integrationforegoing.compat.IFBookCompat;
import jackyy.integrationforegoing.compat.TConstructCompat;
import jackyy.integrationforegoing.config.Config;
import jackyy.integrationforegoing.handler.bioreactor.*;
import jackyy.integrationforegoing.handler.laserdrill.*;
import jackyy.integrationforegoing.handler.plant.extrautils2.PlantRecollectableExtraUtilities2;
import jackyy.integrationforegoing.handler.plant.immersiveengineering.PlantRecollectableIE;
import jackyy.integrationforegoing.handler.plant.oreberries.PlantRecollectableOreberries;
import jackyy.integrationforegoing.handler.plant.oreshrubs.PlantRecollectableOreShrubs;
import jackyy.integrationforegoing.handler.proteinreactor.ProteinReactorHandlerExNihiloCreatio;
import jackyy.integrationforegoing.handler.proteinreactor.ProteinReactorHandlerHarvestCraft;
import jackyy.integrationforegoing.handler.straw.exnihilocreatio.StrawRegistryExNihiloCreatio;
import jackyy.integrationforegoing.handler.straw.immersiveengineering.StrawRegistryIE;
import jackyy.integrationforegoing.handler.straw.tconstruct.StrawRegistryTCon;
import jackyy.integrationforegoing.handler.straw.thermalfoundation.StrawRegistryTF;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;

public class Integrations {

    public static void preInit() {
        if (Config.thermalFoundationIntegration && Loader.isModLoaded(ModNames.TF)) {
            ModUtils.logIntegration(0, "drink handlers", ModNames.TF);
            MinecraftForge.EVENT_BUS.register(new StrawRegistryTF());
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
            MinecraftForge.EVENT_BUS.register(new StrawRegistryTCon());
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
    }

}
