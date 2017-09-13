package me.jacky1356400.integrationforegoing.handler.straw.thermalfoundation;

import com.buuz135.industrial.api.fluid.IFluidDrinkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

public class DrinkHandlerGlowstone implements IFluidDrinkHandler {
    @Override
    public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
        player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 60 * 20, 2));
        player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 60 * 20, 2));
        player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 60 * 20, 0));
        player.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 30 * 20, 0));
    }
}
