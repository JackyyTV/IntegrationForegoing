package me.jacky1356400.integrationforegoing.util;

import net.minecraft.block.properties.PropertyInteger;

public class Reference {

    public static final String MODID = "integrationforegoing";
    public static final String MODNAME = "IntegrationForegoing";
    public static final String VERSION = "1.12-1.2.1";
    public static final String MCVERSION = "[1.12,)";
    public static final String DEPENDS
            = "required-after:industrialforegoing@[1.12-1.3-58,);"
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
            + "after:forestry;";
    public static final String GUIFACTORY = "me.jacky1356400.integrationforegoing.ConfigGuiFactory";
    public static final String PROXY = "me.jacky1356400.integrationforegoing.proxy";

    public static final PropertyInteger OREBERRIES_AGE = PropertyInteger.create("age", 0, 3);

}
