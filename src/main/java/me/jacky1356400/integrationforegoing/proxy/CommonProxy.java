package me.jacky1356400.integrationforegoing.proxy;

import com.buuz135.industrial.api.IndustrialForegoingHelper;
import me.jacky1356400.integrationforegoing.Config;
import me.jacky1356400.integrationforegoing.IntegrationForegoing;
import me.jacky1356400.integrationforegoing.compat.tconstruct.TConstructCompat;
import me.jacky1356400.integrationforegoing.handler.bioreactor.BioReactorHandlerIE;
import me.jacky1356400.integrationforegoing.handler.bioreactor.BioReactorHandlerMysticalAgradditions;
import me.jacky1356400.integrationforegoing.handler.bioreactor.BioReactorHandlerMysticalAgriculture;
import me.jacky1356400.integrationforegoing.handler.laserdrill.LaserDrillHandlerAE2;
import me.jacky1356400.integrationforegoing.handler.laserdrill.LaserDrillHandlerEvilCraft;
import me.jacky1356400.integrationforegoing.handler.laserdrill.LaserDrillHandlerMysticalAgriculture;
import me.jacky1356400.integrationforegoing.handler.laserdrill.LaserDrillHandlerRFTools;
import me.jacky1356400.integrationforegoing.handler.plant.immersiveengineering.CropHempPlantRecollectable;
import me.jacky1356400.integrationforegoing.handler.plant.mysticalagradditions.MysticalAgradditionsCropsPlantRecollectable;
import me.jacky1356400.integrationforegoing.handler.plant.mysticalagriculture.MysticalAgricultureCropsPlantRecollectable;
import me.jacky1356400.integrationforegoing.handler.plant.oreberries.*;
import me.jacky1356400.integrationforegoing.handler.straw.immersiveengineering.StrawRegistryIE;
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
            }
        }
        if (Config.tconstructIntegration) {
            if (Loader.isModLoaded("tconstruct")) {
                IntegrationForegoing.logger.info("Pre-initialising integration for Tinkers' Construct...");
                TConstructCompat.preInit();
                IntegrationForegoing.logger.info("Pre-initialised integration for Tinkers' Construct");
            }
        }
	}

	public void init(FMLInitializationEvent event) {
        if (Config.immersiveEngineeringIntegration) {
            if (Loader.isModLoaded("immersiveengineering")) {
                IntegrationForegoing.logger.info("Registering Bioreactor entries for Immersive Engineering...");
                BioReactorHandlerIE.init();
                IntegrationForegoing.logger.info("Registered Bioreactor entries for Immersive Engineering");

                IntegrationForegoing.logger.info("Registering Plant Recollector entries for Immersive Engineering...");
                IndustrialForegoingHelper.addPlantRecollectable(new CropHempPlantRecollectable());
                IntegrationForegoing.logger.info("Registered Plant Recollector entries for Immersive Engineering");
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

                IntegrationForegoing.logger.info("Registering Plant Recollector entries for Mystical Agriculture...");
                IndustrialForegoingHelper.addPlantRecollectable(new MysticalAgricultureCropsPlantRecollectable());
                IntegrationForegoing.logger.info("Registered Plant Recollector entries for Mystical Agriculture");
            }
        }
        if (Config.mysticalAgradditionsIntegration) {
            if (Loader.isModLoaded("mysticalagradditions")) {
                IntegrationForegoing.logger.info("Registering Bioreactor entries for Mystical Agradditions...");
                BioReactorHandlerMysticalAgradditions.init();
                IntegrationForegoing.logger.info("Registered Bioreactor entries for Mystical Agradditions");

                IntegrationForegoing.logger.info("Registering Plant Recollector entries for Mystical Agradditions...");
                IndustrialForegoingHelper.addPlantRecollectable(new MysticalAgradditionsCropsPlantRecollectable());
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
                IndustrialForegoingHelper.addPlantRecollectable(new OreberryBushPlantRecollectable());
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
	}

	public void postInit(FMLPostInitializationEvent event) {
	}

}
