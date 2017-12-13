package jackyy.integrationforegoing.handler.plant.immersiveengineering;

import com.buuz135.industrial.api.plant.PlantRecollectable;
import jackyy.integrationforegoing.config.Config;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.List;

public class PlantRecollectableIE {

    @SubscribeEvent
    public void register(RegistryEvent.Register<PlantRecollectable> event) {
        IForgeRegistry<PlantRecollectable> registry = event.getRegistry();
        registry.register(new PlantRecollectable("hemp") {
            @Override
            public boolean canBeHarvested(World world, BlockPos pos, IBlockState blockState) {
                return blockState.getBlock() == ModUtils.getBlockByObject(ModNames.IE, "hemp")
                        && world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock() == ModUtils.getBlockByObject(ModNames.IE, "hemp")
                        && blockState.getBlock().getMetaFromState(blockState) == 4;
            }

            @Override
            public List<ItemStack> doHarvestOperation(World world, BlockPos pos, IBlockState blockState) {
                NonNullList<ItemStack> stacks = NonNullList.create();
                if (Config.hempHarvestBothBlocks) {
                    blockState.getBlock().getDrops(stacks, world, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), blockState, 0);
                    blockState.getBlock().getDrops(stacks, world, pos, blockState, 0);
                    world.setBlockToAir(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()));
                    world.setBlockToAir(pos);
                } else {
                    blockState.getBlock().getDrops(stacks, world, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), blockState, 0);
                    world.setBlockToAir(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()));
                }
                return stacks;
            }

            @Override
            public boolean shouldCheckNextPlant(World world, BlockPos pos, IBlockState blockState) {
                return true;
            }
        });
    }

}
