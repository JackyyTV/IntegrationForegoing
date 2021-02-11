package jackyy.integrationforegoing.proxy;

import jackyy.integrationforegoing.integration.Integrations;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        Integrations.preInit(event);
    }

    public void init(FMLInitializationEvent event) {
        Integrations.init();
    }

    public void postInit(FMLPostInitializationEvent event) {
        Integrations.postInit();
    }

}
