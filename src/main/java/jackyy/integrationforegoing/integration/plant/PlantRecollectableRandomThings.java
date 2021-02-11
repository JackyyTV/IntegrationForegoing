package jackyy.integrationforegoing.integration.plant;

import com.buuz135.industrial.api.plant.PlantRecollectable;
import jackyy.gunpowderlib.helper.ObjectHelper;
import jackyy.integrationforegoing.util.ModConfig;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;
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

public class PlantRecollectableRandomThings {

    @SubscribeEvent
    public void register(RegistryEvent.Register<PlantRecollectable> event) {
        IForgeRegistry<PlantRecollectable> registry = event.getRegistry();
        registry.register(new PlantRecollectable("randomthings_lotus") {
            @Override
            public boolean canBeHarvested(World world, BlockPos pos, IBlockState blockState) {
                return blockState.getBlock() == ObjectHelper.getBlockByName(ModNames.RANDOMTHINGS, "lotus")
                        && blockState.getBlock().getMetaFromState(blockState) == 3;
            }

            @Override
            public List<ItemStack> doHarvestOperation(World world, BlockPos pos, IBlockState blockState) {
                NonNullList<ItemStack> stacks = NonNullList.create();
                stacks.add(ObjectHelper.getItemStackByName(ModNames.RANDOMTHINGS, "ingredient", 1, 10));
                if (ModConfig.misc.randomThings.randomThingsLotusReplant) {
                    stacks.add(ObjectHelper.getItemStackByName(ModNames.RANDOMTHINGS, "lotusseeds", 1, 0));
                    world.setBlockToAir(pos);
                } else {
                    world.setBlockState(pos, blockState.withProperty(ModUtils.getGenericGrowthAge(3), 0));
                }
                return stacks;
            }

            @Override
            public boolean shouldCheckNextPlant(World world, BlockPos pos, IBlockState blockState) {
                return true;
            }

            @Override
            public List<String> getRecollectablesNames() {
                return ModConfig.misc.randomThings.randomThingsLotusReplant ? Collections.singletonList(Reference.PLANT_TEXT + "randomthings_lotus_replant") : Collections.singletonList(Reference.PLANT_TEXT + "randomthings_lotus_no_replant");
            }
        });
    }

}
