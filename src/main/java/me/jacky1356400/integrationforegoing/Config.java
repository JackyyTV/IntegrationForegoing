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
    private static final String CATEGORY_IE = "immersive engineering";
    private static final String CATEGORY_MA = "mystical agriculture";
    private static final String CATEGORY_MA2 = "mystical agradditions";

    public static boolean thermalFoundationIntegration;
    public static boolean immersiveEngineeringIntegration;
    public static boolean mysticalAgricultureIntegration;
    public static boolean mysticalAgradditionsIntegration;
    public static boolean tconstructIntegration;
    public static boolean oreberriesIntegration;
    public static boolean ae2Integration;
    public static boolean rftoolsIntegration;
    public static boolean evilcraftIntegration;
    public static int strawEnderRange;
    public static boolean hempHarvestBothBlocks;
    public static boolean mysticalAgricultureVerboseLogging;
    public static boolean mysticalAgradditionsVerboseLogging;

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
        list.add(new ConfigElement(cfg.getCategory(CATEGORY_IE)));
        list.add(new ConfigElement(cfg.getCategory(CATEGORY_MA)));
        list.add(new ConfigElement(cfg.getCategory(CATEGORY_MA2)));

        return list;
    }

    private static void initConfig(Configuration cfg) {
        thermalFoundationIntegration = cfg.getBoolean("thermalFoundationIntegration", CATEGORY_INTEGRATIONS, true, "If true, enables Thermal Foundation integration");
        immersiveEngineeringIntegration = cfg.getBoolean("immersiveEngineeringIntegration", CATEGORY_INTEGRATIONS, true, "If true, enables Immersive Engineering Integration");
        mysticalAgricultureIntegration = cfg.getBoolean("mysticalAgricultureIntegration", CATEGORY_INTEGRATIONS, true, "If true, enables Mystical Agriculture Integration");
        mysticalAgradditionsIntegration = cfg.getBoolean("mysticalAgradditionsIntegration", CATEGORY_INTEGRATIONS, true, "If true, enables Mystical Agradditions Integration");
        tconstructIntegration = cfg.getBoolean("tconstructIntegration", CATEGORY_INTEGRATIONS, true, "If true, enables Tinkers' Construct Integration");
        oreberriesIntegration = cfg.getBoolean("oreberriesIntegration", CATEGORY_INTEGRATIONS, true, "If true, enables Oreberries Integration");
        ae2Integration = cfg.getBoolean("ae2Integration", CATEGORY_INTEGRATIONS, true, "If true, enables Applied Energistics 2 Integration");
        rftoolsIntegration = cfg.getBoolean("rftoolsIntegration", CATEGORY_INTEGRATIONS, true, "If true, enables RFTools Integration");
        evilcraftIntegration = cfg.getBoolean("evilcraftIntegration", CATEGORY_INTEGRATIONS, true, "If true, enables EvilCraft Integration");
        strawEnderRange = cfg.getInt("strawEnderRange", CATEGORY_TF, 16384, 64, 65536,
                "This number determines the teleportation range for drinking Resonant Ender.\n"
                        + "Range calculation method:\n"
                        + "Player's X / Z position - (this number clamped between 8 and 65536) + (this number clamped between 8 and 65536) * 2\n"
        );
        hempHarvestBothBlocks = cfg.getBoolean("hempHarvestBothBlocks", CATEGORY_IE, true,
                "If true, both top and bottom blocks of Industrial Hemp gets harvested by the Plant Recollector.\n"
                        + "Set to false if you only want the top block to be harvested.\n");
        mysticalAgricultureVerboseLogging = cfg.getBoolean("mysticalAgricultureVerboseLogging", CATEGORY_MA, false,
                "If true, enables verbose logging for Mystical Agriculture integration.\n"
                        + "This config option is intended for debugging purposes.\n");
        mysticalAgradditionsVerboseLogging = cfg.getBoolean("mysticalAgradditionsVerboseLogging", CATEGORY_MA2, false,
                "If true, enables verbose logging for Mystical Agradditions integration.\n"
                        + "This config option is intended for debugging purposes.\n");
    }

}
