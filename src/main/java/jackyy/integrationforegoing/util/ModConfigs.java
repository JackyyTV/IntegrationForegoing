package jackyy.integrationforegoing.util;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ModConfigs {

    public static class CommonConfig {

        public final ForgeConfigSpec.BooleanValue craftTweaker;
        public final ForgeConfigSpec.BooleanValue thermal;
        public final ForgeConfigSpec.BooleanValue immersiveEngineering;
        public final ForgeConfigSpec.BooleanValue mysticalAgriculture;
        public final ForgeConfigSpec.BooleanValue mysticalAgradditions;
        public final ForgeConfigSpec.BooleanValue harvestCraft2Trees;
        public final ForgeConfigSpec.BooleanValue exNihiloSequentia;
        public final ForgeConfigSpec.BooleanValue immersivePetroleum;
        public final ForgeConfigSpec.BooleanValue astralSorcery;
        public final ForgeConfigSpec.BooleanValue botania;
        public final ForgeConfigSpec.BooleanValue cyclic;

        public final ForgeConfigSpec.BooleanValue hempHarvestBothBlocks;

        CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("Integration Foregoing Config")
                    .push("integrations");
            craftTweaker = builder.define("craftTweaker", true);
            thermal = builder.define("thermal", true);
            immersiveEngineering = builder.define("immersiveEngineering", true);
            mysticalAgriculture = builder.define("mysticalAgriculture", true);
            mysticalAgradditions = builder.define("mysticalAgradditions", true);
            harvestCraft2Trees = builder.define("harvestCraft2Trees", true);
            exNihiloSequentia = builder.define("exNihiloSequentia", true);
            immersivePetroleum = builder.define("immersivePetroleum", true);
            astralSorcery = builder.define("astralSorcery", true);
            botania = builder.define("botania", true);
            cyclic = builder.define("cyclic", true);
            builder.pop();

            builder.push("misc");
            builder.push("immersive_engineering");
            hempHarvestBothBlocks = builder
                    .comment(
                            "If true, both top and bottom blocks of Industrial Hemp gets harvested by the Plant Recollector.",
                            "Set to false if you only want the top block to be harvested."
                    )
                    .define("hempHarvestBothBlocks", false);
            builder.pop();
            builder.pop();
        }

    }

    public static final ForgeConfigSpec SPEC;
    public static final CommonConfig CONFIG;
    static {
        final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        SPEC = specPair.getRight();
        CONFIG = specPair.getLeft();
    }

}
