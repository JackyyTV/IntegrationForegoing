package me.jacky1356400.integrationforegoing.handler.straw.thermalfoundation;

import com.buuz135.industrial.api.fluid.IFluidDrinkHandler;
import me.jacky1356400.integrationforegoing.entity.EntityFakeLightningBolt;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;

public class DrinkHandlerRedstone implements IFluidDrinkHandler {
    @Override
    public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
        ArrayList<PotionEffect> effects = new ArrayList<>(player.getActivePotionEffects());
        for (PotionEffect effect : effects) {
            amplifyEffect(player, effect);
        }
        player.setFire(2);
        EntityFakeLightningBolt bolt = new EntityFakeLightningBolt(world, pos.getX(), pos.getY(), pos.getZ());
        world.addWeatherEffect(bolt);
        world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, pos.getX(), pos.getY() + 1, pos.getZ(), 0.0D, 0.0D, 0.0D);
        world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }
    private boolean amplifyEffect(EntityLivingBase player, PotionEffect effect) {
        if (effect == null || effect.getIsAmbient()) {
            return false;
        }
        int amplifier = Math.min(effect.getAmplifier() + 1, 3);
        int duration = Math.min(effect.getDuration() * 2, 9600);
        player.addPotionEffect(new PotionEffect(effect.getPotion(), duration, amplifier));
        return true;
    }
}
