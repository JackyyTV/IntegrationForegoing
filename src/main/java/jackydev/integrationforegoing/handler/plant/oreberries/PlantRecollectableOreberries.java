package jackydev.integrationforegoing.handler.plant.oreberries;

import com.buuz135.industrial.api.plant.PlantRecollectable;
import jackydev.integrationforegoing.util.ModUtils;
import jackydev.integrationforegoing.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.List;

public class PlantRecollectableOreberries {

    @SubscribeEvent
    public void register(RegistryEvent.Register<PlantRecollectable> event) {
        IForgeRegistry<PlantRecollectable> registry = event.getRegistry();
        registry.register(new PlantRecollectable("oreberries") {
            @Override
            public boolean canBeHarvested(World world, BlockPos pos, IBlockState blockState) {
                Block block = blockState.getBlock();
                if (block.getMetaFromState(blockState) != 3) return false;
                ResourceLocation registryName = block.getRegistryName();
                return registryName.getResourceDomain().equals("oreberries")
                        && registryName.getResourcePath().endsWith("_oreberry_bush");
            }

            @Override
            public List<ItemStack> doHarvestOperation(World world, BlockPos pos, IBlockState blockState) {
                NonNullList<ItemStack> stacks = NonNullList.create();
                String name = blockState.getBlock().getRegistryName().getResourcePath();
                stacks.add(0, ModUtils.getItemStackByObject("oreberries", name.substring(0, name.length() - 5), world.rand.nextInt(3) + 1, 0));
                world.setBlockState(pos, blockState.withProperty(Reference.OREBERRIES_AGE, 2));
                return stacks;
            }

            @Override
            public boolean shouldCheckNextPlant(World world, BlockPos pos, IBlockState blockState) {
                return true;
            }
        });
    }

}
