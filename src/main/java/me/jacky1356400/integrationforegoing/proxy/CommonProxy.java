package me.jacky1356400.integrationforegoing.proxy;

import com.buuz135.industrial.utils.StrawUtils;
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
                StrawUtils.register("aerotheum", new DrinkHandlerAerotheum());
                StrawUtils.register("coal", new DrinkHandlerCoal());
                StrawUtils.register("crude_oil", new DrinkHandlerCrudeOil());
                StrawUtils.register("cryotheum", new DrinkHandlerCryotheum());
                StrawUtils.register("ender", new DrinkHandlerEnder());
                StrawUtils.register("glowstone", new DrinkHandlerGlowstone());
                StrawUtils.register("mana", new DrinkHandlerMana());
                StrawUtils.register("petrotheum", new DrinkHandlerPetrotheum());
                StrawUtils.register("pyrotheum", new DrinkHandlerPyrotheum());
                StrawUtils.register("redstone", new DrinkHandlerRedstone());
                StrawUtils.register("steam", new DrinkHandlerSteam());
                IntegrationForegoing.logger.info("Registered drink handlers for Thermal Foundation");
            }
        }
        if (Config.immersiveEngineeringIntegration) {
	        if (Loader.isModLoaded("immersiveengineering")) {
                IntegrationForegoing.logger.info("Registering drink handlers for Immersive Engineering...");
	            StrawUtils.register("biodiesel", new DrinkHandlerBiodiesel());
                StrawUtils.register("concrete", new DrinkHandlerConcrete());
                StrawUtils.register("creosote", new DrinkHandlerCreosoteOil());
                StrawUtils.register("ethanol", new DrinkHandlerEthanol());
                StrawUtils.register("plantoil", new DrinkHandlerPlantOil());
                IntegrationForegoing.logger.info("Registered drink handlers for Immersive Engineering");
            }
        }
	}

}
