package jackyy.integrationforegoing.proxy;

import jackyy.integrationforegoing.config.Config;
import jackyy.integrationforegoing.util.Integrations;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class CommonProxy {

	public static Configuration config;

	public void preInit(FMLPreInitializationEvent event) {
		File configDir = event.getModConfigurationDirectory();
		config = new Configuration(new File(configDir.getPath(), "IntegrationForegoing.cfg"));
		Config.readConfig();
        Integrations.preInit();
	}

	public void init(FMLInitializationEvent event) {
        Integrations.init();
	}

	public void postInit(FMLPostInitializationEvent event) {
	}

}
