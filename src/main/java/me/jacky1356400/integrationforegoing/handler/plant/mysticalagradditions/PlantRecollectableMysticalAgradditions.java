package me.jacky1356400.integrationforegoing.handler.plant.mysticalagradditions;

import com.buuz135.industrial.api.plant.PlantRecollectable;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.List;

public class PlantRecollectableMysticalAgradditions {

    @SubscribeEvent
    public void register(RegistryEvent.Register<PlantRecollectable> event) {
        IForgeRegistry<PlantRecollectable> registry = event.getRegistry();
        registry.register(new PlantRecollectable("mysticalagradditions_crops") {
            private static final String MA_ID = "mysticalagradditions";

            @Override
            public boolean canBeHarvested(World world, BlockPos pos, IBlockState blockState) {
                return !world.isRemote
                        && blockState.getBlock().getRegistryName().getResourceDomain().equals(MA_ID)
                        && blockState.getBlock() instanceof BlockCrops
                        && ((BlockCrops) blockState.getBlock()).isMaxAge(blockState);
            }

            @Override @SuppressWarnings("deprecation")
            public List<ItemStack> doHarvestOperation(World world, BlockPos pos, IBlockState state) {
                List<ItemStack> stacks = state.getBlock().getDrops(world, pos, state, 0);
                world.setBlockToAir(pos);
                return stacks;
            }


            @Override
            public boolean shouldCheckNextPlant(World world, BlockPos pos, IBlockState blockState) {
                return true;
            }
        });
    }

}
