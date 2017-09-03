package me.jacky1356400.integrationforegoing.proxy;

import com.buuz135.industrial.api.fluid.StrawHelper;
import me.jacky1356400.integrationforegoing.Config;
import me.jacky1356400.integrationforegoing.IntegrationForegoing;
import me.jacky1356400.integrationforegoing.straw.immersiveengineering.*;
import me.jacky1356400.integrationforegoing.straw.thermalfoundation.*;
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
		MinecraftForge.EVENT_BUS.register(this);
	}

	public void init(FMLInitializationEvent event) {
	}

	public void postInit(FMLPostInitializationEvent event) {
	    if (Config.thermalFoundationIntegration) {
	        if (Loader.isModLoaded("thermalfoundation")) {
                IntegrationForegoing.logger.info("Registering drink handlers for Thermal Foundation...");
                StrawHelper.register("aerotheum", new DrinkHandlerAerotheum());
                StrawHelper.register("coal", new DrinkHandlerCoal());
                StrawHelper.register("crude_oil", new DrinkHandlerCrudeOil());
                StrawHelper.register("cryotheum", new DrinkHandlerCryotheum());
                StrawHelper.register("ender", new DrinkHandlerEnder());
                StrawHelper.register("glowstone", new DrinkHandlerGlowstone());
                StrawHelper.register("mana", new DrinkHandlerMana());
                StrawHelper.register("petrotheum", new DrinkHandlerPetrotheum());
                StrawHelper.register("pyrotheum", new DrinkHandlerPyrotheum());
                StrawHelper.register("redstone", new DrinkHandlerRedstone());
                StrawHelper.register("steam", new DrinkHandlerSteam());
                IntegrationForegoing.logger.info("Registered drink handlers for Thermal Foundation");
            }
        }
        if (Config.immersiveEngineeringIntegration) {
	        if (Loader.isModLoaded("immersiveengineering")) {
                IntegrationForegoing.logger.info("Registering drink handlers for Immersive Engineering...");
	            StrawHelper.register("biodiesel", new DrinkHandlerBiodiesel());
                StrawHelper.register("concrete", new DrinkHandlerConcrete());
                StrawHelper.register("creosote", new DrinkHandlerCreosoteOil());
                StrawHelper.register("ethanol", new DrinkHandlerEthanol());
                StrawHelper.register("plantoil", new DrinkHandlerPlantOil());
                IntegrationForegoing.logger.info("Registered drink handlers for Immersive Engineering");
            }
        }
	}

}
