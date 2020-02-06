package jackyy.integrationforegoing.integration.plant;

import com.buuz135.industrial.api.plant.PlantRecollectable;
import jackyy.gunpowderlib.helper.ObjectHelper;
import jackyy.integrationforegoing.util.ModConfig;
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

public class PlantRecollectableImmersiveEngineering {

    @SubscribeEvent
    public void register(RegistryEvent.Register<PlantRecollectable> event) {
        IForgeRegistry<PlantRecollectable> registry = event.getRegistry();
        registry.register(new PlantRecollectable("hemp") {
            @Override
            public boolean canBeHarvested(World world, BlockPos pos, IBlockState blockState) {
                return blockState.getBlock() == ObjectHelper.getBlockByName(ModNames.IE, "hemp")
                        && world.getBlockState(pos.up()).getBlock() == ObjectHelper.getBlockByName(ModNames.IE, "hemp")
                        && blockState.getBlock().getMetaFromState(blockState) == 4;
            }

            @Override
            public List<ItemStack> doHarvestOperation(World world, BlockPos pos, IBlockState blockState) {
                NonNullList<ItemStack> stacks = NonNullList.create();
                if (ModConfig.misc.immersiveEngineering.hempHarvestBothBlocks) {
                    blockState.getBlock().getDrops(stacks, world, pos.up(), blockState, 0);
                    blockState.getBlock().getDrops(stacks, world, pos, blockState, 0);
                    world.setBlockToAir(pos.up());
                    world.setBlockToAir(pos);
                } else {
                    blockState.getBlock().getDrops(stacks, world, pos.up(), blockState, 0);
                    world.setBlockToAir(pos.up());
                }
                return stacks;
            }

            @Override
            public boolean shouldCheckNextPlant(World world, BlockPos pos, IBlockState blockState) {
                return true;
            }

            @Override
            public List<String> getRecollectablesNames() {
                return ModConfig.misc.immersiveEngineering.hempHarvestBothBlocks ? Collections.singletonList(Reference.PLANT_TEXT + "hemp_replant") : Collections.singletonList(Reference.PLANT_TEXT + "hemp_no_replant");
            }
        });
    }

}
