package me.jacky1356400.integrationforegoing;

import me.jacky1356400.integrationforegoing.proxy.CommonProxy;
import me.jacky1356400.integrationforegoing.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MODID, version = Reference.VERSION, name = Reference.MODNAME, dependencies = Reference.DEPENDS, guiFactory = Reference.GUIFACTORY, acceptedMinecraftVersions = Reference.MCVERSION, useMetadata = true)
public class IntegrationForegoing {

    public static Logger logger = LogManager.getLogger(Reference.MODNAME);

	@SidedProxy(serverSide = Reference.COMMON_PROXY, clientSide = Reference.CLIENT_PROXY)
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
