package jackyy.integrationforegoing.integration.plant;

import com.buuz135.industrial.api.plant.PlantRecollectable;
import com.infinityraider.agricraft.blocks.BlockCrop;
import com.infinityraider.agricraft.tiles.TileEntityCrop;
import jackyy.integrationforegoing.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Collections;
import java.util.List;

public class PlantRecollectableAgriCraft {

    @SubscribeEvent
    public void register(RegistryEvent.Register<PlantRecollectable> event) {
        IForgeRegistry<PlantRecollectable> registry = event.getRegistry();
        registry.register(new PlantRecollectable("agricraft_crops") {
            @Override
            public boolean canBeHarvested(World world, BlockPos pos, IBlockState blockState) {
                return blockState.getBlock() instanceof BlockCrop && ((BlockCrop)blockState.getBlock()).isMature(world, pos);
            }

            @Override
            public List<ItemStack> doHarvestOperation(World world, BlockPos pos, IBlockState blockState) {
                NonNullList<ItemStack> stacks = NonNullList.create();
                TileEntity tile = world.getTileEntity(pos);
                if (tile instanceof TileEntityCrop) {
                    TileEntityCrop cropTile = (TileEntityCrop)tile;
                    if (cropTile.isMature())
                        cropTile.onHarvest(stacks::add, null);
                }
                return stacks;
            }

            @Override
            public boolean shouldCheckNextPlant(World world, BlockPos pos, IBlockState blockState) {
                return true;
            }

            @Override
            public List<String> getRecollectablesNames() {
                return Collections.singletonList(Reference.PLANT_TEXT + "agricraft_crops");
            }
        });
    }

}
