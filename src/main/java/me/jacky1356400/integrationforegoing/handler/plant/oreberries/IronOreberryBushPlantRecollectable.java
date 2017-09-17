package me.jacky1356400.integrationforegoing.handler.plant.oreberries;

import com.buuz135.industrial.api.plant.IPlantRecollectable;
import me.jacky1356400.integrationforegoing.util.ModUtils;
import me.jacky1356400.integrationforegoing.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class IronOreberryBushPlantRecollectable implements IPlantRecollectable {

    @Override
    public boolean canBeHarvested(World world, BlockPos pos, IBlockState blockState) {
        return blockState.getBlock() == ModUtils.getBlockByObject("oreberries", "iron_oreberry_bush")
                && blockState.getBlock().getMetaFromState(blockState) == 3;
    }

    @Override
    public List<ItemStack> doHarvestOperation(World world, BlockPos pos, IBlockState blockState) {
        NonNullList<ItemStack> stacks = NonNullList.create();
        stacks.add(0, ModUtils.getItemStackByObject("oreberries", "iron_oreberry", world.rand.nextInt(3) + 1, 0));
        world.setBlockState(pos, blockState.withProperty(Reference.OREBERRIES_AGE, 2));
        return stacks;
    }

    @Override
    public boolean shouldCheckNextPlant(World world, BlockPos pos, IBlockState blockState) {
        return true;
    }

}
