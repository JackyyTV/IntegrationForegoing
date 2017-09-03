package me.jacky1356400.integrationforegoing;

import me.jacky1356400.integrationforegoing.proxy.CommonProxy;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;

public class Config {

    private static final String CATEGORY_INTEGRATIONS = "integrations";
    private static final String CATEGORY_TF = "thermal foundation";

    public static boolean thermalFoundationIntegration;
    public static boolean immersiveEngineeringIntegration;
    public static int strawEnderRange;

    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initConfig(cfg);
        } catch (Exception e) {
            IntegrationForegoing.logger.error("Error caught when loading config!", e);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    public static List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = new ArrayList<>();
        Configuration cfg = CommonProxy.config;

        list.add(new ConfigElement(cfg.getCategory(CATEGORY_INTEGRATIONS)));
        list.add(new ConfigElement(cfg.getCategory(CATEGORY_TF)));

        return list;
    }

    private static void initConfig(Configuration cfg) {
        thermalFoundationIntegration = cfg.getBoolean("thermalFoundationIntegration", CATEGORY_INTEGRATIONS, true, "If true, enables Thermal Foundation integration");
        immersiveEngineeringIntegration = cfg.getBoolean("immersiveEngineeringIntegration", CATEGORY_INTEGRATIONS, true, "If true, enables Immersive Engineering Integration");
        strawEnderRange = cfg.getInt("strawEnderRange", CATEGORY_TF, 16384, 64, 65536,
                "This number determines the teleportation range for drinking Resonant Ender.\n"
                        + "Range calculation method:\n"
                        + "Player's X / Z position - (this number clamped between 8 and 65536) + (this number clamped between 8 and 65536) * 2\n"
        );
    }

}
