package jackyy.integrationforegoing.util;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.item.EnumDyeColor;

public final class ModProps {

    public static final PropertyInteger ENDERLILLY_AGE = PropertyInteger.create("growth", 0, 7);
    public static final PropertyInteger REDORCHID_AGE = PropertyInteger.create("growth", 0, 6);
    public static final PropertyBool RUSTIC_WILDBERRIES = PropertyBool.create("berries");
    public static final PropertyBool RUSTIC_GRAPES = PropertyBool.create("grapes");
    public static final PropertyEnum<EnumDyeColor> BOTANIA_COLOR = PropertyEnum.create("color", EnumDyeColor.class);

}
