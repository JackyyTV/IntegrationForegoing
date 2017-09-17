package me.jacky1356400.integrationforegoing.handler.plant.mysticalagradditions;

import com.buuz135.industrial.api.plant.IPlantRecollectable;
import me.jacky1356400.integrationforegoing.IntegrationForegoing;
import me.jacky1356400.integrationforegoing.handler.plant.mysticalagriculture.MysticalAgricultureCropsPlantRecollectable;
import me.jacky1356400.integrationforegoing.util.ModUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class MysticalAgradditionsCropsPlantRecollectable implements IPlantRecollectable {

    private static final String MA_ID = "mysticalagradditions";

    private HashMap<Block, MysticalAgricultureCropsPlantRecollectable.MysticalAgricultureSeedHandler> seedHandlerHashMap;

    public MysticalAgradditionsCropsPlantRecollectable() {
        seedHandlerHashMap = new HashMap<>();
        Item essence = ModUtils.getItemByObject("mysticalagriculture", "crafting");
        seedHandlerHashMap.put(ModUtils.getBlockByObject(MA_ID, "tier" + 6 + "_inferium_crop"), new MysticalAgricultureCropsPlantRecollectable.MysticalAgricultureSeedHandler(new ItemStack(essence, 6), new ItemStack(ModUtils.getItemByObject(MA_ID, "tier" + 6 + "_inferium_seeds"))));
        try {
            Class seed_types = Class.forName("com.blakebr0.mysticalagradditions.lib.CropType$Type");
            if (seed_types != null) {
                Method enabled = seed_types.getMethod("isEnabled");
                if (enabled != null) {
                    for (Object type : seed_types.getEnumConstants()) {
                        if ((Boolean) enabled.invoke(type)) {
                            String name = ((IStringSerializable) type).getName();
                            MysticalAgricultureCropsPlantRecollectable.addType(seedHandlerHashMap, name, MA_ID);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        seedHandlerHashMap.forEach((block, mysticalAgricultureSeedHandler) -> IntegrationForegoing.logger.info("Registered Mystical Agradditions Type: [B]" + block.getRegistryName().getResourcePath() + " [S]" + mysticalAgricultureSeedHandler.getSeed().getItem().getRegistryName().getResourcePath() + " [D]" + mysticalAgricultureSeedHandler.getDrop().getItem().getRegistryName().getResourcePath()));

    }

    @Override
    public boolean canBeHarvested(World world, BlockPos pos, IBlockState blockState) {
        return seedHandlerHashMap.containsKey(blockState.getBlock()) && blockState.getBlock() instanceof BlockCrops && ((BlockCrops) blockState.getBlock()).isMaxAge(blockState);
    }

    @Override
    public List<ItemStack> doHarvestOperation(World world, BlockPos pos, IBlockState blockState) {
        NonNullList<ItemStack> stacks = NonNullList.create();
        MysticalAgricultureCropsPlantRecollectable.MysticalAgricultureSeedHandler handler = seedHandlerHashMap.get(blockState.getBlock());
        stacks.add(handler.getDrop().copy());
        stacks.add(handler.getSeed().copy());
        world.setBlockToAir(pos);
        return stacks;
    }

    @Override
    public boolean shouldCheckNextPlant(World world, BlockPos pos, IBlockState blockState) {
        return true;
    }

}
