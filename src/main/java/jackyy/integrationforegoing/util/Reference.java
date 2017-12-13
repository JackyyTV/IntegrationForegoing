package jackyy.integrationforegoing.util;

import net.minecraft.block.properties.PropertyInteger;

public class Reference {

    public static final String MODID = "integrationforegoing";
    public static final String MODNAME = "Integration Foregoing";
    public static final String VERSION = "1.12-1.4";
    public static final String MCVERSION = "[1.12,)";
    public static final String DEPENDS
            = "required-after:" + ModNames.IF + "@[1.12.1-1.5.0,);"
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
            + "after:" + ModNames.EXNIHILOCREATIO + ";";
    public static final String GUIFACTORY = "jackyy.integrationforegoing.config.ConfigGuiFactory";
    public static final String COMMON_PROXY = "jackyy.integrationforegoing.proxy.CommonProxy";
    public static final String CLIENT_PROXY = "jackyy.integrationforegoing.proxy.ClientProxy";

    public static final PropertyInteger OREBERRIES_AGE = PropertyInteger.create("age", 0, 3);
    public static final PropertyInteger ORESHRUBS_AGE = PropertyInteger.create("age", 0, 4);
    public static final PropertyInteger ENDERLILLY_AGE = PropertyInteger.create("growth", 0, 7);
    public static final PropertyInteger REDORCHID_AGE = PropertyInteger.create("growth", 0, 6);

}
