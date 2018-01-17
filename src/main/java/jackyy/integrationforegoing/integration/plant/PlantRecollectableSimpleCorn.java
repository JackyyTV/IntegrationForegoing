package jackyy.integrationforegoing.integration.plant;

import com.buuz135.industrial.api.plant.PlantRecollectable;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Collections;
import java.util.List;

public class PlantRecollectableSimpleCorn {

    @SubscribeEvent
    public void register(RegistryEvent.Register<PlantRecollectable> event) {
        IForgeRegistry<PlantRecollectable> registry = event.getRegistry();
        registry.register(new PlantRecollectable("simple_corn") {
            @Override
            public boolean canBeHarvested(World world, BlockPos pos, IBlockState blockState) {
                return world.getBlockState(pos.up(2)).getBlock().getRegistryName().getResourceDomain().equals(ModNames.SIMPLECORN)
                        && world.getBlockState(pos.up(2)).getBlock().getMetaFromState(world.getBlockState(pos.up(2))) == 11;
            }

            @Override
            public List<ItemStack> doHarvestOperation(World world, BlockPos pos, IBlockState blockState) {
                NonNullList<ItemStack> stacks = NonNullList.create();
                blockState.getBlock().getDrops(stacks, world, pos.up(2), blockState, 0);
                blockState.getBlock().getDrops(stacks, world, pos.up(), blockState, 0);
                blockState.getBlock().getDrops(stacks, world, pos, blockState, 0);
                world.setBlockToAir(pos.up(2));
                world.setBlockToAir(pos.up());
                world.setBlockToAir(pos);
                return stacks;
            }

            @Override
            public boolean shouldCheckNextPlant(World world, BlockPos pos, IBlockState blockState) {
                return true;
            }

            @Override
            public List<String> getRecollectablesNames() {
                return Collections.singletonList(Reference.PLANT_TEXT + "simple_corn");
            }
        });
    }

}
