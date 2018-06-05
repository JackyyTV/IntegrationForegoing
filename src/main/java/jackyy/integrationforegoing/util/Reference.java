package jackyy.integrationforegoing.util;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;

public final class Reference {
    public static final String MODID = "integrationforegoing";
    public static final String MODNAME = "Integration Foregoing";
    public static final String VERSION = "1.12-1.6.1";
    public static final String MCVERSION = "[1.12,1.13)";
    public static final String DEPENDS
            = "required-after:" + ModNames.IF + "@[1.12.2-1.6.5,);"
            + "after:" + ModNames.TF + ";"
            + "after:" + ModNames.IE + ";"
            + "after:" + ModNames.TCON + ";"
            + "after:" + ModNames.MAG + ";"
            + "after:" + ModNames.MAD + ";"
            + "after:" + ModNames.OREBERRIES + ";"
            + "after:" + ModNames.AE2 + ";"
            + "after:" + ModNames.RFTOOLS + ";"
            + "after:" + ModNames.EVILCRAFT + ";"
            + "after:" + ModNames.AA + ";"
            + "after:" + ModNames.FORESTRY + ";"
            + "after:" + ModNames.XU2 + ";"
            + "after:" + ModNames.ORESHRUBS + ";"
            + "after:" + ModNames.HARVESTCRAFT + ";"
            + "after:" + ModNames.EXNIHILOCREATIO + ";"
            + "after:" + ModNames.SIMPLECORN + ";"
            + "after:" + ModNames.NATURA + ";"
            + "after:" + ModNames.RUSTIC + ";"
            + "after:" + ModNames.MATTEROVERDRIVE + ";";

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
}
