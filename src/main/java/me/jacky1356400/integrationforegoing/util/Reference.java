package me.jacky1356400.integrationforegoing.util;

import net.minecraft.block.properties.PropertyInteger;

public class Reference {

    public static final String MODID = "integrationforegoing";
    public static final String MODNAME = "Integration Foregoing";
    public static final String VERSION = "1.12-1.3.1";
    public static final String MCVERSION = "[1.12,)";
    public static final String DEPENDS
            = "required-after:industrialforegoing@[1.12.1-1.5.0,);"
            + "after:thermalfoundation;"
            + "after:immersiveengineering;"
            + "after:tconstruct;"
            + "after:mysticalagriculture;"
            + "after:mysticalagradditions;"
            + "after:oreberries;"
            + "after:appliedenergistics2;"
            + "after:rftools;"
            + "after:evilcraft;"
            + "after:actuallyadditions;"
            + "after:forestry;"
            + "after:extrautils2";
    public static final String GUIFACTORY = "me.jacky1356400.integrationforegoing.ConfigGuiFactory";
    public static final String COMMON_PROXY = "me.jacky1356400.integrationforegoing.proxy.CommonProxy";
    public static final String CLIENT_PROXY = "me.jacky1356400.integrationforegoing.proxy.ClientProxy";

    public static final PropertyInteger OREBERRIES_AGE = PropertyInteger.create("age", 0, 3);
    public static final PropertyInteger ORESHRUBS_AGE = PropertyInteger.create("age", 0, 4);
    public static final PropertyInteger ENDERLILLY_AGE = PropertyInteger.create("growth", 0, 7);

}
