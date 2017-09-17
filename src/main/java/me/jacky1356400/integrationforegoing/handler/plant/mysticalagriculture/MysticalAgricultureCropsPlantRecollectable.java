package me.jacky1356400.integrationforegoing.handler.plant.mysticalagriculture;

import com.buuz135.industrial.api.plant.IPlantRecollectable;
import me.jacky1356400.integrationforegoing.IntegrationForegoing;
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

public class MysticalAgricultureCropsPlantRecollectable implements IPlantRecollectable {

    private static final String MA_ID = "mysticalagriculture";

    private HashMap<Block, MysticalAgricultureSeedHandler> seedHandlerHashMap;

    public MysticalAgricultureCropsPlantRecollectable() {
        seedHandlerHashMap = new HashMap<>();
        Item essence = ModUtils.getItemByObject(MA_ID, "crafting");
        if (essence != null) {
            for (int i = 1; i <= 5; ++i) {
                seedHandlerHashMap.put(ModUtils.getBlockByObject(MA_ID, "tier" + i + "_inferium_crop"), new MysticalAgricultureSeedHandler(new ItemStack(essence, i), new ItemStack(ModUtils.getItemByObject(MA_ID, "tier" + i + "_inferium_seeds"))));
            }
        }
        try {
            Class seed_types = Class.forName("com.blakebr0.mysticalagriculture.lib.CropType$Type");
            if (seed_types != null) {
                Method enabled = seed_types.getMethod("isEnabled");
                if (enabled != null) {
                    for (Object type : seed_types.getEnumConstants()) {
                        if ((Boolean) enabled.invoke(type)) {
                            String name = ((IStringSerializable) type).getName();
                            addType(seedHandlerHashMap, name, MA_ID);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        seedHandlerHashMap.forEach((block, mysticalAgricultureSeedHandler) -> IntegrationForegoing.logger.info("Registered Mystical Agriculture Type: [B]" + block.getRegistryName().getResourcePath() + " [S]" + mysticalAgricultureSeedHandler.getSeed().getItem().getRegistryName().getResourcePath() + " [D]" + mysticalAgricultureSeedHandler.getDrop().getItem().getRegistryName().getResourcePath()));
    }

    @Override
    public boolean canBeHarvested(World world, BlockPos pos, IBlockState blockState) {
        return seedHandlerHashMap.containsKey(blockState.getBlock()) && blockState.getBlock() instanceof BlockCrops && ((BlockCrops) blockState.getBlock()).isMaxAge(blockState);
    }

    @Override
    public List<ItemStack> doHarvestOperation(World world, BlockPos pos, IBlockState blockState) {
        NonNullList<ItemStack> stacks = NonNullList.create();
        MysticalAgricultureSeedHandler handler = seedHandlerHashMap.get(blockState.getBlock());
        stacks.add(handler.getDrop().copy());
        stacks.add(handler.getSeed().copy());
        world.setBlockToAir(pos);
        return stacks;
    }


    @Override
    public boolean shouldCheckNextPlant(World world, BlockPos pos, IBlockState blockState) {
        return true;
    }

    public static void addType(HashMap<Block, MysticalAgricultureSeedHandler> seedHandlerHashMap, String typeName, String modID) {
        Item seed = ModUtils.getItemByObject(modID, typeName + "_seeds");
        Item essence = ModUtils.getItemByObject(modID, typeName + "_essence");
        Block crop = ModUtils.getBlockByObject(modID, typeName + "_crop");
        if (seed != null && essence != null && crop != null)
            seedHandlerHashMap.put(crop, new MysticalAgricultureSeedHandler(new ItemStack(essence), new ItemStack(seed)));
    }

    public static class MysticalAgricultureSeedHandler {

        private ItemStack drop;
        private ItemStack seed;

        public MysticalAgricultureSeedHandler(ItemStack drop, ItemStack seed) {
            this.drop = drop;
            this.seed = seed;
        }

        public ItemStack getDrop() {
            return drop;
        }

        public ItemStack getSeed() {
            return seed;
        }

    }
}
