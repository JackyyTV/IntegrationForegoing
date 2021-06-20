package jackyy.integrationforegoing.integration.plant;

import blusunrize.immersiveengineering.common.blocks.plant.EnumHempGrowth;
import blusunrize.immersiveengineering.common.blocks.plant.HempBlock;
import com.buuz135.industrial.api.plant.PlantRecollectable;
import jackyy.gunpowderlib.helper.ObjectHelper;
import jackyy.integrationforegoing.util.ModConfigs;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Collections;
import java.util.List;

public class PlantRecollectableImmersiveEngineering {

    @SubscribeEvent
    public void register(RegistryEvent.Register<PlantRecollectable> event) {
        IForgeRegistry<PlantRecollectable> registry = event.getRegistry();
        registry.register(new PlantRecollectable("hemp") {
            @Override
            public boolean canBeHarvested(World world, BlockPos pos, BlockState blockState) {
                return blockState.getBlock() == ObjectHelper.getBlockByName(ModNames.IE, "hemp")
                        && world.getBlockState(pos.up()).getBlock() == ObjectHelper.getBlockByName(ModNames.IE, "hemp")
                        && blockState.get(HempBlock.GROWTH) == EnumHempGrowth.TOP0;
            }

            @Override
            public List<ItemStack> doHarvestOperation(World world, BlockPos pos, BlockState blockState) {
                NonNullList<ItemStack> stacks = NonNullList.create();
                ServerWorld serverWorld = (ServerWorld) world;
                stacks.addAll(Block.getDrops(blockState, serverWorld, pos.up(), null));
                world.removeBlock(pos.up(), false);
                if (ModConfigs.CONFIG.hempHarvestBothBlocks.get()) {
                    stacks.addAll(Block.getDrops(blockState, serverWorld, pos, null));
                    world.removeBlock(pos, false);
                }
                return stacks;
            }

            @Override
            public boolean shouldCheckNextPlant(World world, BlockPos pos, BlockState blockState) {
                return true;
            }

            @Override
            public List<String> getRecollectablesNames() {
                return ModConfigs.CONFIG.hempHarvestBothBlocks.get() ? Collections.singletonList(Reference.PLANT_TEXT + "hemp_replant") : Collections.singletonList(Reference.PLANT_TEXT + "hemp_no_replant");
            }
        });
    }

}
