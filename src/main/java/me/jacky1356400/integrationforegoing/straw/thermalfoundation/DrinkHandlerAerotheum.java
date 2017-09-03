package me.jacky1356400.integrationforegoing.straw.thermalfoundation;

import com.buuz135.industrial.api.fluid.IFluidDrinkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

public class DrinkHandlerAerotheum implements IFluidDrinkHandler {
    @Override
    public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
        player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 240 * 20, 0));
        player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 60 * 20, 0));
        player.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 30 * 20, 0));
    }
}
