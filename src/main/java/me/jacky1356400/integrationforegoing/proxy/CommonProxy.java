package me.jacky1356400.integrationforegoing.proxy;

import com.buuz135.industrial.utils.StrawUtils;
import me.jacky1356400.integrationforegoing.Config;
import me.jacky1356400.integrationforegoing.IntegrationForegoing;
import me.jacky1356400.integrationforegoing.straw.thermalfoundation.DrinkHandlerEnder;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
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
            IntegrationForegoing.logger.info("Registering drink handlers for Thermal Foundation...");
            StrawUtils.register("ender", new DrinkHandlerEnder());
            IntegrationForegoing.logger.info("Registered drink handlers for Thermal Foundation");
        }
	}

}
