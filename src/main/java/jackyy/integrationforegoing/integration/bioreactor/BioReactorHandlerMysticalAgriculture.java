package jackyy.integrationforegoing.integration.bioreactor;

import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;

public class BioReactorHandlerMysticalAgriculture {

    private static final String[] SEEDS = new String[] {
            "stone", "dirt", "nature", "wood", "water",
            "ice", "fire", "dye", "nether", "coal",
            "iron", "nether_quartz", "glowstone", "redstone", "obsidian",
            "gold", "lapis_lazuli", "end", "experience", "diamond",
            "emerald", "zombie", "pig", "chicken", "cow",
            "sheep", "slime", "skeleton", "creeper", "spider",
            "rabbit", "guardian", "blaze", "ghast", "enderman",
            "wither_skeleton", "rubber", "silicon", "sulfur", "aluminum",
            "copper", "saltpeter", "tin", "bronze", "zinc",
            "brass", "silver", "lead", "graphite", "steel",
            "nickel", "constantan", "electrum", "invar", "mithril",
            "tungsten", "titanium", "uranium", "chrome", "platinum",
            "iridium", "ruby", "sapphire", "peridot", "amber",
            "topaz", "malachite", "tanzanite", "blizz", "blitz",
            "basalz", "signalum", "lumium", "enderium", "fluxed_electrum",
            "hop_graphite", "aluminum_brass", "knightslime", "ardite", "cobalt",
            "manyullyn", "grains_of_infinity", "electrical_steel", "redstone_alloy", "conductive_iron",
            "soularium", "dark_steel", "pulsating_iron", "energetic_alloy", "vibrant_alloy",
            "end_steel", "mystical_flower", "manasteel", "elementium", "terrasteel",
            "quicksilver", "thaumium", "void_metal", "dawnstone", "uranium_238",
            "iridium_ore", "osmium", "glowstone_ingot", "refined_obsidian", "aquarium",
            "cold_iron", "star_steel", "adamantine", "marble", "limestone",
            "basalt", "apatite", "electrotine", "alumite", "steeleaf",
            "ironwood", "knightmetal", "fiery_ingot", "meteoric_iron", "desh",
            "coralium", "abyssalnite", "dreadium", "slimy_bone", "syrmorite",
            "octine", "valonite", "thorium", "boron", "lithium",
            "magnesium", "black_quartz", "menril", "vinteum", "chimerite",
            "blue_topaz", "moonstone", "sunstone", "aquamarine", "starmetal",
            "rock_crystal", "ender_biotite", "dilithium", "tritanium", "jade",
            "slate", "dark_gem", "compressed_iron", "ender_amethyst", "draconium",
            "yellorium", "sky_stone", "certus_quartz", "fluix", "quartz_enriched_iron"
    };

    public static void init() {
        for (int i = 16; i <= 21; i++) {
            ModUtils.registerBioReactorEntry(ModNames.MAG, "crafting", 1, i);
        }
        for (int i = 1; i <= 5; i++) {
            ModUtils.registerBioReactorEntry(ModNames.MAG, "tier" + i + "_inferium_seeds", 1, 0);
        }
        for (String seed : SEEDS) {
            ModUtils.registerBioReactorEntry(ModNames.MAG, seed + "_seeds", 1, 0);
        }
    }

}
