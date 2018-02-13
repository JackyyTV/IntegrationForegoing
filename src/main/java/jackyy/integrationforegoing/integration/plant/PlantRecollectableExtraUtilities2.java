package jackyy.integrationforegoing.integration.plant;

import com.buuz135.industrial.api.plant.PlantRecollectable;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;
import jackyy.integrationforegoing.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Collections;
import java.util.List;

public class PlantRecollectableExtraUtilities2 {

    @SubscribeEvent
    public void register(RegistryEvent.Register<PlantRecollectable> event) {
        IForgeRegistry<PlantRecollectable> registry = event.getRegistry();
        registry.register(new PlantRecollectable("ender_lilly") {
            @Override
            public boolean canBeHarvested(World world, BlockPos pos, IBlockState blockState) {
                return blockState.getBlock() == ModUtils.getBlockByName(ModNames.XU2, "enderlilly")
                        && blockState.getBlock().getMetaFromState(blockState) == 7;
            }

            @Override @SuppressWarnings("deprecation")
            public List<ItemStack> doHarvestOperation(World world, BlockPos pos, IBlockState blockState) {
                List<ItemStack> stacks = blockState.getBlock().getDrops(world, pos, blockState, 0);
                for (int i = 0; i < stacks.size(); i++) {
                    if (stacks.get(i).getItem() == ModUtils.getItemByName(ModNames.XU2, "enderlilly")) {
                        stacks.remove(i);
                    }
                }
                world.setBlockState(pos, blockState.withProperty(Reference.ENDERLILLY_AGE, 0));
                return stacks;
            }

            @Override
            public boolean shouldCheckNextPlant(World world, BlockPos pos, IBlockState blockState) {
                return true;
            }

            @Override
            public List<String> getRecollectablesNames() {
                return Collections.singletonList(Reference.PLANT_TEXT + "ender_lilly");
            }
        });
        registry.register(new PlantRecollectable("red_orchid") {
            @Override
            public boolean canBeHarvested(World world, BlockPos pos, IBlockState blockState) {
                return blockState.getBlock() == ModUtils.getBlockByName(ModNames.XU2, "redorchid")
                        && blockState.getBlock().getMetaFromState(blockState) == 6;
            }

            @Override @SuppressWarnings("deprecation")
            public List<ItemStack> doHarvestOperation(World world, BlockPos pos, IBlockState blockState) {
                List<ItemStack> stacks = blockState.getBlock().getDrops(world, pos, blockState, 0);
                for (int i = 0; i < stacks.size(); i++) {
                    if (stacks.get(i).getItem() == ModUtils.getItemByName(ModNames.XU2, "redorchid")) {
                        stacks.remove(i);
                    }
                }
                world.setBlockState(pos, blockState.withProperty(Reference.REDORCHID_AGE, 0));
                return stacks;
            }

            @Override
            public boolean shouldCheckNextPlant(World world, BlockPos pos, IBlockState blockState) {
                return true;
            }

            @Override
            public List<String> getRecollectablesNames() {
                return Collections.singletonList(Reference.PLANT_TEXT + "red_orchid");
            }
        });
    }

}
