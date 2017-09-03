package me.jacky1356400.integrationforegoing.straw.immersiveengineering;

import com.buuz135.industrial.api.fluid.IFluidDrinkHandler;
import me.jacky1356400.integrationforegoing.util.ModUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

public class DrinkHandlerConcrete implements IFluidDrinkHandler {
    @Override
    public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
        player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 60 * 20, 3));
        player.addPotionEffect(new PotionEffect(ModUtils.getPotionByObject("immersiveengineering", "concreteFeet"), 60 * 20, 0));
        player.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 60 * 20, 3));
    }
}
