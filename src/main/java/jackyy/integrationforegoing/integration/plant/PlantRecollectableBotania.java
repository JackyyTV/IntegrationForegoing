package jackyy.integrationforegoing.integration.plant;

import com.buuz135.industrial.api.plant.PlantRecollectable;
import jackyy.gunpowderlib.helper.ObjectHelper;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModProps;
import jackyy.integrationforegoing.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Collections;
import java.util.List;

public class PlantRecollectableBotania {

    @SubscribeEvent
    public void register(RegistryEvent.Register<PlantRecollectable> event) {
        IForgeRegistry<PlantRecollectable> registry = event.getRegistry();
        registry.register(new PlantRecollectable("tall_mystical_flowers") {
            @Override
            public boolean canBeHarvested(World world, BlockPos pos, IBlockState blockState) {
                ResourceLocation registryName = blockState.getBlock().getRegistryName();
                ResourceLocation registryName2 = world.getBlockState(pos.up()).getBlock().getRegistryName();
                return registryName.getNamespace().equals(ModNames.BOTANIA)
                        && registryName.getPath().contains("doubleflower")
                        && registryName2.getNamespace().equals(ModNames.BOTANIA)
                        && registryName2.getPath().contains("doubleflower");
            }

            @Override
            public List<ItemStack> doHarvestOperation(World world, BlockPos pos, IBlockState blockState) {
                NonNullList<ItemStack> stacks = NonNullList.create();
                IBlockState petal = ObjectHelper.getBlockByName(ModNames.BOTANIA, "buriedpetals").getDefaultState();
                world.setBlockToAir(pos.up());
                switch (blockState.getBlock().getRegistryName().getPath()) {
                    case "doubleflower1":
                        switch (blockState.getBlock().getMetaFromState(blockState)) {
                            case 0:
                                world.setBlockState(pos, petal.withProperty(ModProps.BOTANIA_COLOR, EnumDyeColor.WHITE));
                                stacks.add(0, ObjectHelper.getItemStackByName(ModNames.BOTANIA, "petal", 3, 0));
                                break;
                            case 1:
                                world.setBlockState(pos, petal.withProperty(ModProps.BOTANIA_COLOR, EnumDyeColor.ORANGE));
                                stacks.add(0, ObjectHelper.getItemStackByName(ModNames.BOTANIA, "petal", 3, 1));
                                break;
                            case 2:
                                world.setBlockState(pos, petal.withProperty(ModProps.BOTANIA_COLOR, EnumDyeColor.MAGENTA));
                                stacks.add(0, ObjectHelper.getItemStackByName(ModNames.BOTANIA, "petal", 3, 2));
                                break;
                            case 3:
                                world.setBlockState(pos, petal.withProperty(ModProps.BOTANIA_COLOR, EnumDyeColor.LIGHT_BLUE));
                                stacks.add(0, ObjectHelper.getItemStackByName(ModNames.BOTANIA, "petal", 3, 3));
                                break;
                            case 4:
                                world.setBlockState(pos, petal.withProperty(ModProps.BOTANIA_COLOR, EnumDyeColor.YELLOW));
                                stacks.add(0, ObjectHelper.getItemStackByName(ModNames.BOTANIA, "petal", 3, 4));
                                break;
                            case 5:
                                world.setBlockState(pos, petal.withProperty(ModProps.BOTANIA_COLOR, EnumDyeColor.LIME));
                                stacks.add(0, ObjectHelper.getItemStackByName(ModNames.BOTANIA, "petal", 3, 5));
                                break;
                            case 6:
                                world.setBlockState(pos, petal.withProperty(ModProps.BOTANIA_COLOR, EnumDyeColor.PINK));
                                stacks.add(0, ObjectHelper.getItemStackByName(ModNames.BOTANIA, "petal", 3, 6));
                                break;
                            case 7:
                                world.setBlockState(pos, petal.withProperty(ModProps.BOTANIA_COLOR, EnumDyeColor.GRAY));
                                stacks.add(0, ObjectHelper.getItemStackByName(ModNames.BOTANIA, "petal", 3, 7));
                                break;
                        }
                        break;
                    case "doubleflower2":
                        switch (blockState.getBlock().getMetaFromState(blockState)) {
                            case 0:
                                world.setBlockState(pos, petal.withProperty(ModProps.BOTANIA_COLOR, EnumDyeColor.SILVER));
                                stacks.add(0, ObjectHelper.getItemStackByName(ModNames.BOTANIA, "petal", 3, 8));
                                break;
                            case 1:
                                world.setBlockState(pos, petal.withProperty(ModProps.BOTANIA_COLOR, EnumDyeColor.CYAN));
                                stacks.add(0, ObjectHelper.getItemStackByName(ModNames.BOTANIA, "petal", 3, 9));
                                break;
                            case 2:
                                world.setBlockState(pos, petal.withProperty(ModProps.BOTANIA_COLOR, EnumDyeColor.PURPLE));
                                stacks.add(0, ObjectHelper.getItemStackByName(ModNames.BOTANIA, "petal", 3, 10));
                                break;
                            case 3:
                                world.setBlockState(pos, petal.withProperty(ModProps.BOTANIA_COLOR, EnumDyeColor.BLUE));
                                stacks.add(0, ObjectHelper.getItemStackByName(ModNames.BOTANIA, "petal", 3, 11));
                                break;
                            case 4:
                                world.setBlockState(pos, petal.withProperty(ModProps.BOTANIA_COLOR, EnumDyeColor.BROWN));
                                stacks.add(0, ObjectHelper.getItemStackByName(ModNames.BOTANIA, "petal", 3, 12));
                                break;
                            case 5:
                                world.setBlockState(pos, petal.withProperty(ModProps.BOTANIA_COLOR, EnumDyeColor.GREEN));
                                stacks.add(0, ObjectHelper.getItemStackByName(ModNames.BOTANIA, "petal", 3, 13));
                                break;
                            case 6:
                                world.setBlockState(pos, petal.withProperty(ModProps.BOTANIA_COLOR, EnumDyeColor.RED));
                                stacks.add(0, ObjectHelper.getItemStackByName(ModNames.BOTANIA, "petal", 3, 14));
                                break;
                            case 7:
                                world.setBlockState(pos, petal.withProperty(ModProps.BOTANIA_COLOR, EnumDyeColor.BLACK));
                                stacks.add(0, ObjectHelper.getItemStackByName(ModNames.BOTANIA, "petal", 3, 15));
                                break;
                        }
                        break;
                }
                return stacks;
            }

            @Override
            public boolean shouldCheckNextPlant(World world, BlockPos pos, IBlockState blockState) {
                return true;
            }

            @Override
            public List<String> getRecollectablesNames() {
                return Collections.singletonList(Reference.PLANT_TEXT + "botania_tall_mystical_flowers");
            }
        });
    }

}
