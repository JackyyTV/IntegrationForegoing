package me.jacky1356400.integrationforegoing.handler.plant.mysticalagradditions;

import com.buuz135.industrial.api.plant.IPlantRecollectable;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Objects;

public class MysticalAgradditionsCropsPlantRecollectable implements IPlantRecollectable {

    @Override
    public boolean canBeHarvested(World world, BlockPos pos, IBlockState blockState) {
        return blockState.getBlock() instanceof BlockCrops
                && ((BlockCrops) blockState.getBlock()).isMaxAge(blockState)
                && Objects.equals(blockState.getBlock().getRegistryName().getResourceDomain(), "mysticalagradditions");
    }

    @Override
    public List<ItemStack> doHarvestOperation(World world, BlockPos pos, IBlockState blockState) {
        NonNullList<ItemStack> stacks = NonNullList.create();
        blockState.getBlock().getDrops(stacks, world, pos, blockState, 0);
        for (int i = 0; i < stacks.size(); i++) {
            if (stacks.get(i).getItem() instanceof ItemSeeds) {
                stacks.set(i, new ItemStack(stacks.get(i).getItem(), 1));
            }
        }
        world.setBlockToAir(pos);
        return stacks;
    }

    @Override
    public boolean shouldCheckNextPlant(World world, BlockPos pos, IBlockState blockState) {
        return true;
    }

}
