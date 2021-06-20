package jackyy.integrationforegoing.integration.plant;

import com.buuz135.industrial.api.plant.PlantRecollectable;
import jackyy.gunpowderlib.helper.ObjectHelper;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.Reference;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Collections;
import java.util.List;

public class PlantRecollectableBotania {

    @SubscribeEvent
    public void register(RegistryEvent.Register<PlantRecollectable> event) {
        IForgeRegistry<PlantRecollectable> registry = event.getRegistry();
        registry.register(new PlantRecollectable("botania_tall_mystical_flowers") {
            @Override
            public boolean canBeHarvested(World world, BlockPos pos, BlockState blockState) {
                ResourceLocation registryName = blockState.getBlock().getRegistryName();
                ResourceLocation registryName2 = world.getBlockState(pos.up()).getBlock().getRegistryName();
                return registryName.getNamespace().equals(ModNames.BOTANIA)
                        && registryName.getPath().contains("double_flower")
                        && registryName2.getNamespace().equals(ModNames.BOTANIA)
                        && registryName2.getPath().contains("double_flower");
            }

            @Override
            public List<ItemStack> doHarvestOperation(World world, BlockPos pos, BlockState blockState) {
                NonNullList<ItemStack> stacks = NonNullList.create();
                String color = blockState.getBlock().getRegistryName().getPath().replaceAll("_double_flower", "");
                BlockState petal = ObjectHelper.getBlockByName(ModNames.BOTANIA, color + "_buried_petals").getDefaultState();
                world.removeBlock(pos.up(), false);
                world.setBlockState(pos, petal);
                stacks.add(0, ObjectHelper.getItemStackByName(ModNames.BOTANIA, color + "_petal", 3));
                return stacks;
            }

            @Override
            public boolean shouldCheckNextPlant(World world, BlockPos pos, BlockState blockState) {
                return true;
            }

            @Override
            public List<String> getRecollectablesNames() {
                return Collections.singletonList(Reference.PLANT_TEXT + "botania_tall_mystical_flowers");
            }
        });
    }

}
