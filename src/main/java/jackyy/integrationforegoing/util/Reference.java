package jackyy.integrationforegoing.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static jackyy.integrationforegoing.util.ModNames.*;

public final class Reference {

    public static final String MODID = "integrationforegoing";
    public static final String MODNAME = "Integration Foregoing";
    public static final String VERSION = "1.12.2-1.10";
    public static final String MCVERSION = "[1.12,1.13)";
    public static final String DEPENDS
            = "required-after:" + IF + "@[1.12.0,);"
            + "required-after:" + LIB + "@[1.12.2-1.0,);"
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
            + "after:" + BIOMESOP + ";"
            + "after:" + AS + ";"
            + "after:" + BOTANIA + ";"
            + "after:" + NUCLEARCRAFT + ";";

    public static final Logger LOGGER = LogManager.getLogger(MODNAME);

    public static final String COMMON_PROXY = "jackyy.integrationforegoing.proxy.CommonProxy";
    public static final String CLIENT_PROXY = "jackyy.integrationforegoing.proxy.ClientProxy";

    public static final String PLANT_TEXT = "text.integrationforegoing.plant.";

}
