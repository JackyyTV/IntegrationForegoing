package me.jacky1356400.integrationforegoing.handler.straw.thermalfoundation;

import com.buuz135.industrial.api.fluid.IFluidDrinkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

public class DrinkHandlerCryotheum implements IFluidDrinkHandler {
    @Override
    public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
        player.attackEntityFrom(new CryotheumDamage(), 15);
        player.extinguish();
        player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 480 * 20, 0));
    }
    private class CryotheumDamage extends DamageSource {
        public CryotheumDamage() {
            super("cryotheum");
            this.setDamageBypassesArmor();
            this.setMagicDamage();
            this.setDifficultyScaled();
        }
    }
}
