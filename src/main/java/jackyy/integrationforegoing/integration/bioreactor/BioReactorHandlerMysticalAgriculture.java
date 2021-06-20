package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerMysticalAgriculture {

    private static final String[] SEEDS = new String[] {
            "air", "earth", "water", "fire", "inferium",
            "stone", "dirt", "wood", "ice", "nature",
            "dye", "coal", "coral", "honey", "pig",
            "chicken", "cow", "sheep", "squid", "fish",
            "slime", "turtle", "iron", "nether_quartz", "glowstone",
            "redstone", "obsidian", "prismarine", "zombie", "skeleton",
            "creeper", "spider", "rabbit", "gold", "lapis_lazuli",
            "end", "experience", "blaze", "ghast", "enderman",
            "diamond", "emerald", "netherite", "wither_skeleton", "rubber",
            "silicon", "sulfur", "aluminum", "copper", "saltpeter",
            "tin", "bronze", "zinc", "brass", "silver",
            "lead", "graphite", "steel", "nickel", "constantan",
            "electrum", "invar", "mithril", "tungsten", "titanium",
            "uranium", "chrome", "platinum", "iridium", "blizz",
            "blitz", "basalz", "signalum", "lumium", "enderium",
            "hop_graphite", "mystical_flower", "manasteel", "elementium", "terrasteel",
            "osmium", "refined_glowstone", "refined_obsidian", "ender_biotite", "aquamarine",
            "starmetal", "rock_crystal", "compressed_iron", "yellorium", "cyanite",
            "sky_stone", "certus_quartz", "fluix", "quartz_enriched_iron", "energized_steel",
            "blazing_crystal", "niotic_crystal", "spirited_crystal", "uraninite"
    };

    public static void init() {
        ModUtils.registerBioReactorEntry(ModNames.MAG, "prosperity_seed_base", 1);
        ModUtils.registerBioReactorEntry(ModNames.MAG, "soulium_seed_base", 1);
        for (String seed : SEEDS) {
            ModUtils.registerBioReactorEntry(ModNames.MAG, seed + "_seeds", 1);
        }
    }

}
