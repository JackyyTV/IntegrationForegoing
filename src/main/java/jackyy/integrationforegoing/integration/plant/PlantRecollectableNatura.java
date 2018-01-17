package jackyy.integrationforegoing.integration.plant;

import com.buuz135.industrial.api.plant.PlantRecollectable;
import jackyy.integrationforegoing.config.Config;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;
import jackyy.integrationforegoing.util.Reference;
import net.minecraft.block.state.IBlockState;
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

@SuppressWarnings("null")
public class PlantRecollectableNatura {

    @SubscribeEvent
    public void register(RegistryEvent.Register<PlantRecollectable> event) {
        IForgeRegistry<PlantRecollectable> registry = event.getRegistry();
        registry.register(new PlantRecollectable("natura_berry_bush") {
            @Override
            public boolean canBeHarvested(World world, BlockPos pos, IBlockState blockState) {
                return blockState.getBlock().getMetaFromState(blockState) == 3
                        && blockState.getBlock().getRegistryName().getResourceDomain().equals(ModNames.NATURA)
                        && blockState.getBlock().getRegistryName().getResourcePath().contains("berrybush");
            }

            @Override
            public List<ItemStack> doHarvestOperation(World world, BlockPos pos, IBlockState blockState) {
                NonNullList<ItemStack> stacks = NonNullList.create();
                switch (blockState.getBlock().getRegistryName().getResourcePath()) {
                    case "overworld_berrybush_raspberry" :
                        stacks.add(0, ModUtils.getItemStackByObject(ModNames.NATURA, "edibles", 1, 2));
                        break;
                    case "overworld_berrybush_blueberry" :
                        stacks.add(0, ModUtils.getItemStackByObject(ModNames.NATURA, "edibles", 1, 3));
                        break;
                    case "overworld_berrybush_blackberry" :
                        stacks.add(0, ModUtils.getItemStackByObject(ModNames.NATURA, "edibles", 1, 4));
                        break;
                    case "overworld_berrybush_maloberry" :
                        stacks.add(0, ModUtils.getItemStackByObject(ModNames.NATURA, "edibles", 1, 5));
                        break;
                    case "nether_berrybush_blightberry" :
                        stacks.add(0, ModUtils.getItemStackByObject(ModNames.NATURA, "edibles", 1, 6));
                        break;
                    case "nether_berrybush_duskberry" :
                        stacks.add(0, ModUtils.getItemStackByObject(ModNames.NATURA, "edibles", 1, 7));
                        break;
                    case "nether_berrybush_skyberry" :
                        stacks.add(0, ModUtils.getItemStackByObject(ModNames.NATURA, "edibles", 1, 8));
                        break;
                    case "nether_berrybush_stingberry" :
                        stacks.add(0, ModUtils.getItemStackByObject(ModNames.NATURA, "edibles", 1, 9));
                        break;
                }
                world.setBlockState(pos, blockState.withProperty(Reference.NATURA_BERRIES_AGE, 2));
                return stacks;
            }

            @Override
            public boolean shouldCheckNextPlant(World world, BlockPos pos, IBlockState blockState) {
                return true;
            }

            @Override
            public List<String> getRecollectablesNames() {
                return Collections.singletonList(Reference.PLANT_TEXT + "natura_berry_bush");
            }
        });
        registry.register(new PlantRecollectable("natura_crops") {
            @Override
            public boolean canBeHarvested(World world, BlockPos pos, IBlockState blockState) {
                ResourceLocation regname = blockState.getBlock().getRegistryName();
                if (regname.getResourceDomain().equals(ModNames.NATURA) && regname.getResourcePath().equals("barley_crop")) {
                    return blockState.getBlock().getMetaFromState(blockState) == 3;
                } else if (regname.getResourceDomain().equals(ModNames.NATURA) && regname.getResourcePath().equals("cotton_crop")) {
                    return blockState.getBlock().getMetaFromState(blockState) == 4;
                }
                return false;
            }

            @Override
            public List<ItemStack> doHarvestOperation(World world, BlockPos pos, IBlockState blockState) {
                NonNullList<ItemStack> stacks = NonNullList.create();
                blockState.getBlock().getDrops(stacks, world, pos, blockState, 0);
                if (Config.naturaCropsReplant) {
                    world.setBlockToAir(pos);
                } else {
                    for (int i = 0; i < stacks.size(); i++) {
                        if (stacks.get(i).getItem() == ModUtils.getItemByObject(ModNames.NATURA, "overworld_seeds")) {
                            stacks.remove(i);
                        }
                    }
                    switch (blockState.getBlock().getRegistryName().getResourcePath()) {
                        case "barley_crop" :
                            world.setBlockState(pos, blockState.withProperty(Reference.NATURA_BARLEY_AGE, 1));
                            break;
                        case "cotton_crop" :
                            world.setBlockState(pos, blockState.withProperty(Reference.NATURA_COTTON_AGE, 2));
                            break;
                    }
                }
                return stacks;
            }

            @Override
            public boolean shouldCheckNextPlant(World world, BlockPos pos, IBlockState blockState) {
                return true;
            }

            @Override
            public List<String> getRecollectablesNames() {
                return Config.naturaCropsReplant ? Collections.singletonList(Reference.PLANT_TEXT + "natura_crops_replant") : Collections.singletonList(Reference.PLANT_TEXT + "natura_crops_no_replant");
            }
        });
    }

}
