package jackyy.integrationforegoing;

import jackyy.integrationforegoing.integration.Integrations;
import jackyy.integrationforegoing.util.ModConfigs;
import jackyy.integrationforegoing.util.Reference;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MODID)
public class IntegrationForegoing {

    public IntegrationForegoing() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigs.SPEC, "IntegrationForegoing.toml");
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        Integrations.init();
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        Integrations.initClient();
    }

}
