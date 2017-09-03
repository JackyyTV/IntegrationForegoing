package me.jacky1356400.integrationforegoing;

import me.jacky1356400.integrationforegoing.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = IntegrationForegoing.MODID, version = IntegrationForegoing.VERSION, name = IntegrationForegoing.MODNAME, dependencies = IntegrationForegoing.DEPENDS, guiFactory = IntegrationForegoing.GUIFACTORY, useMetadata = true)
public class IntegrationForegoing {

    public static final String MODID = "integrationforegoing";
    public static final String MODNAME = "IntegrationForegoing";
    public static final String VERSION = "1.12-1.0";
    public static final String DEPENDS = "required-after:industrialforegoing@[1.12-1.2-46,);";
    public static final String GUIFACTORY = "me.jacky1356400.integrationforegoing.ConfigGuiFactory";
    public static final String PROXY = "me.jacky1356400.integrationforegoing.proxy";

	public static Logger logger = LogManager.getLogger(MODNAME);

	@SidedProxy(serverSide = IntegrationForegoing.PROXY + ".CommonProxy", clientSide = IntegrationForegoing.PROXY + ".ClientProxy")
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}

}
