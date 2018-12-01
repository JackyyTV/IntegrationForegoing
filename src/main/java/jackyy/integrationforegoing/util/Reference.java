package jackyy.integrationforegoing.util;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.item.EnumDyeColor;

import static jackyy.integrationforegoing.util.ModNames.*;

public final class Reference {

    public static final String MODID = "integrationforegoing";
    public static final String MODNAME = "Integration Foregoing";
    public static final String VERSION = "1.12.2-1.8";
    public static final String MCVERSION = "[1.12,1.13)";
    public static final String DEPENDS
            = "required-after:" + IF + "@[1.11.0,);"
            + "after:" + TF + ";"
            + "after:" + IE + ";"
            + "after:" + TCON + ";"
            + "after:" + MAG + ";"
            + "after:" + MAD + ";"
            + "after:" + OREBERRIES + ";"
            + "after:" + AE2 + ";"
            + "after:" + RFTOOLS + ";"
            + "after:" + EVILCRAFT + ";"
            + "after:" + AA + ";"
            + "after:" + FORESTRY + ";"
            + "after:" + XU2 + ";"
            + "after:" + ORESHRUBS + ";"
            + "after:" + HARVESTCRAFT + ";"
            + "after:" + EXNIHILOCREATIO + ";"
            + "after:" + SIMPLECORN + ";"
            + "after:" + NATURA + ";"
            + "after:" + RUSTIC + ";"
            + "after:" + MATTEROVERDRIVE + ";"
            + "after:" + AGRICRAFT + ";"
            + "after:" + SILENTSGEMS + ";"
            + "after:" + ENDERIO + ";"
            + "after:" + IP + ";"
            + "after:" + BIOMESOP + ";";

    public static final String COMMON_PROXY = "jackyy.integrationforegoing.proxy.CommonProxy";
    public static final String CLIENT_PROXY = "jackyy.integrationforegoing.proxy.ClientProxy";

    public static final String PLANT_TEXT = "text.integrationforegoing.plant.";

    public static final PropertyInteger OREBERRIES_AGE = PropertyInteger.create("age", 0, 3);
    public static final PropertyInteger ORESHRUBS_AGE = PropertyInteger.create("age", 0, 4);
    public static final PropertyInteger ENDERLILLY_AGE = PropertyInteger.create("growth", 0, 7);
    public static final PropertyInteger REDORCHID_AGE = PropertyInteger.create("growth", 0, 6);
    public static final PropertyInteger NATURA_BERRIES_AGE = PropertyInteger.create("age", 0, 3);
    public static final PropertyInteger NATURA_BARLEY_AGE = PropertyInteger.create("age", 0, 3);
    public static final PropertyInteger NATURA_COTTON_AGE = PropertyInteger.create("age", 0, 4);
    public static final PropertyBool RUSTIC_WILDBERRIES = PropertyBool.create("berries");
    public static final PropertyInteger RUSTIC_CROPS_AGE = PropertyInteger.create("age", 0, 3);
    public static final PropertyBool RUSTIC_GRAPES = PropertyBool.create("grapes");
    public static final PropertyEnum<EnumDyeColor> BOTANIA_COLOR = PropertyEnum.create("color", EnumDyeColor.class);

}
