package me.jacky1356400.integrationforegoing.proxy;

import me.jacky1356400.integrationforegoing.Config;
import me.jacky1356400.integrationforegoing.IntegrationForegoing;
import me.jacky1356400.integrationforegoing.compat.tconstruct.TConstructCompat;
import me.jacky1356400.integrationforegoing.handler.bioreactor.BioReactorHandlerActuallyAdditions;
import me.jacky1356400.integrationforegoing.handler.bioreactor.BioReactorHandlerIE;
import me.jacky1356400.integrationforegoing.handler.bioreactor.BioReactorHandlerMysticalAgradditions;
import me.jacky1356400.integrationforegoing.handler.bioreactor.BioReactorHandlerMysticalAgriculture;
import me.jacky1356400.integrationforegoing.handler.laserdrill.*;
import me.jacky1356400.integrationforegoing.handler.plant.extrautils2.PlantRecollectableExtraUtilities2;
import me.jacky1356400.integrationforegoing.handler.plant.immersiveengineering.PlantRecollectableIE;
import me.jacky1356400.integrationforegoing.handler.plant.mysticalagradditions.PlantRecollectableMysticalAgradditions;
import me.jacky1356400.integrationforegoing.handler.plant.oreberries.PlantRecollectableOreberries;
import me.jacky1356400.integrationforegoing.handler.straw.immersiveengineering.StrawRegistryIE;
import me.jacky1356400.integrationforegoing.handler.straw.tconstruct.StrawRegistryTCon;
import me.jacky1356400.integrationforegoing.handler.straw.thermalfoundation.StrawRegistryTF;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class CommonProxy {

	public static Configuration config;

	public void preInit(FMLPreInitializationEvent event) {
		File configDir = event.getModConfigurationDirectory();
		config = new Configuration(new File(configDir.getPath(), "integrationforegoing.cfg"));
		Config.readConfig();
        if (Config.thermalFoundationIntegration) {
            if (Loader.isModLoaded("thermalfoundation")) {
                IntegrationForegoing.logger.info("Registering drink handlers for Thermal Foundation...");
                MinecraftForge.EVENT_BUS.register(new StrawRegistryTF());
                IntegrationForegoing.logger.info("Registered drink handlers for Thermal Foundation");
            }
        }
        if (Config.immersiveEngineeringIntegration) {
            if (Loader.isModLoaded("immersiveengineering")) {
                IntegrationForegoing.logger.info("Registering drink handlers for Immersive Engineering...");
                MinecraftForge.EVENT_BUS.register(new StrawRegistryIE());
                IntegrationForegoing.logger.info("Registered drink handlers for Immersive Engineering");

                IntegrationForegoing.logger.info("Registering Plant Recollector entries for Immersive Engineering...");
                MinecraftForge.EVENT_BUS.register(new PlantRecollectableIE());
                IntegrationForegoing.logger.info("Registered Plant Recollector entries for Immersive Engineering");
            }
        }
        if (Config.tconstructIntegration) {
            if (Loader.isModLoaded("tconstruct")) {
                IntegrationForegoing.logger.info("Pre-initialising integration for Tinkers' Construct...");
                TConstructCompat.preInit();
                IntegrationForegoing.logger.info("Pre-initialised integration for Tinkers' Construct");

                IntegrationForegoing.logger.info("Registering drink handlers for Tinkers' Construct...");
                MinecraftForge.EVENT_BUS.register(new StrawRegistryTCon());
                IntegrationForegoing.logger.info("Registered drink handlers for Tinkers' Construct");
            }
        }
        if (Config.extraUtils2Integration) {
            if (Loader.isModLoaded("extrautils2")) {
                IntegrationForegoing.logger.info("Registering Plant Recollector entries for Extra Utilities 2...");
                MinecraftForge.EVENT_BUS.register(new PlantRecollectableExtraUtilities2());
                IntegrationForegoing.logger.info("Registered Plant Recollector entries for Extra Utilities 2");
            }
        }
	}

	public void init(FMLInitializationEvent event) {
        if (Config.thermalFoundationIntegration) {
            if (Loader.isModLoaded("thermalfoundation")) {
                IntegrationForegoing.logger.info("Registering Laser Drill entries for Thermal Foundation...");
                LaserDrillHandlerThermalFoundation.init();
                IntegrationForegoing.logger.info("Registered Laser Drill entries for Thermal Foundation");
            }
        }
        if (Config.immersiveEngineeringIntegration) {
            if (Loader.isModLoaded("immersiveengineering")) {
                IntegrationForegoing.logger.info("Registering Bioreactor entries for Immersive Engineering...");
                BioReactorHandlerIE.init();
                IntegrationForegoing.logger.info("Registered Bioreactor entries for Immersive Engineering");
            }
        }
        if (Config.mysticalAgricultureIntegration) {
            if (Loader.isModLoaded("mysticalagriculture")) {
                IntegrationForegoing.logger.info("Registering Bioreactor entries for Mystical Agriculture...");
                BioReactorHandlerMysticalAgriculture.init();
                IntegrationForegoing.logger.info("Registered Bioreactor entries for Mystical Agriculture");

                IntegrationForegoing.logger.info("Registering Laser Drill entries for Mystical Agriculture...");
                LaserDrillHandlerMysticalAgriculture.init();
                IntegrationForegoing.logger.info("Registered Laser Drill entries for Mystical Agriculture");
            }
        }
        if (Config.mysticalAgradditionsIntegration) {
            if (Loader.isModLoaded("mysticalagradditions")) {
                IntegrationForegoing.logger.info("Registering Bioreactor entries for Mystical Agradditions...");
                BioReactorHandlerMysticalAgradditions.init();
                IntegrationForegoing.logger.info("Registered Bioreactor entries for Mystical Agradditions");

                IntegrationForegoing.logger.info("Registering Plant Recollector entries for Mystical Agradditions...");
                MinecraftForge.EVENT_BUS.register(new PlantRecollectableMysticalAgradditions());
                IntegrationForegoing.logger.info("Registered Plant Recollector entries for Mystical Agradditions");
            }
        }
        if (Config.tconstructIntegration) {
            if (Loader.isModLoaded("tconstruct")) {
                IntegrationForegoing.logger.info("Initialising integration for Tinkers' Construct...");
                TConstructCompat.init();
                IntegrationForegoing.logger.info("Initialised integration for Tinkers' Construct");
            }
        }
        if (Config.oreberriesIntegration) {
            if (Loader.isModLoaded("oreberries")) {
                IntegrationForegoing.logger.info("Registering Plant Recollector entries for Oreberries...");
                MinecraftForge.EVENT_BUS.register(new PlantRecollectableOreberries());
                IntegrationForegoing.logger.info("Registered Plant Recollector entries for Oreberries");
            }
        }
        if (Config.ae2Integration) {
            if (Loader.isModLoaded("appliedenergistics2")) {
                IntegrationForegoing.logger.info("Registering Laser Drill entries for Applied Energistics 2...");
                LaserDrillHandlerAE2.init();
                IntegrationForegoing.logger.info("Registered Laser Drill entries for Applied Energistics 2");
            }
        }
        if (Config.rftoolsIntegration) {
            if (Loader.isModLoaded("rftools")) {
                IntegrationForegoing.logger.info("Registering Laser Drill entries for RFTools...");
                LaserDrillHandlerRFTools.init();
                IntegrationForegoing.logger.info("Registered Laser Drill entries for RFTools");
            }
        }
        if (Config.evilcraftIntegration) {
            if (Loader.isModLoaded("evilcraft")) {
                IntegrationForegoing.logger.info("Registering Laser Drill entries for EvilCraft...");
                LaserDrillHandlerEvilCraft.init();
                IntegrationForegoing.logger.info("Registered Laser Drill entries for EvilCraft");
            }
        }
        if (Config.actuallyAdditionsIntegration) {
            if (Loader.isModLoaded("actuallyadditions")) {
                IntegrationForegoing.logger.info("Registering Bioreactor entries for Actually Additions...");
                BioReactorHandlerActuallyAdditions.init();
                IntegrationForegoing.logger.info("Registered Bioreactor entries for Actually Additions");

                IntegrationForegoing.logger.info("Registering Laser Drill entries for Actually Additions...");
                LaserDrillHandlerActuallyAdditions.init();
                IntegrationForegoing.logger.info("Registered Laser Drill entries for Actually Additions");
            }
        }
        if (Config.forestryIntegration) {
            if (Loader.isModLoaded("forestry")) {
                IntegrationForegoing.logger.info("Registering Laser Drill entries for Forestry...");
                LaserDrillHandlerForestry.init();
                IntegrationForegoing.logger.info("Registered Laser Drill entries for Forestry");
            }
        }
	}

	public void postInit(FMLPostInitializationEvent event) {
	}

}
