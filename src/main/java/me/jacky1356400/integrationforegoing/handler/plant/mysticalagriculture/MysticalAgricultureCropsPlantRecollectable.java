package me.jacky1356400.integrationforegoing.handler.plant.mysticalagriculture;

import com.buuz135.industrial.api.plant.IPlantRecollectable;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class MysticalAgricultureCropsPlantRecollectable implements IPlantRecollectable {

	private static final String MA_ID = "mysticalagriculture";
	
    @Override
    public boolean canBeHarvested(World world, BlockPos pos, IBlockState blockState) {
    	if(world.isRemote || !blockState.getBlock().getRegistryName().getResourceDomain().equals(MA_ID)) return false;
        return blockState.getBlock() instanceof BlockCrops && ((BlockCrops) blockState.getBlock()).isMaxAge(blockState);
    }

    @Override
    @SuppressWarnings("deprecation")
    public List<ItemStack> doHarvestOperation(World world, BlockPos pos, IBlockState state) {
		List<ItemStack> stacks = state.getBlock().getDrops(world, pos, state, 0);
        world.setBlockToAir(pos);
        return stacks;
    }


    @Override
    public boolean shouldCheckNextPlant(World world, BlockPos pos, IBlockState blockState) {
        return true;
    }

}
