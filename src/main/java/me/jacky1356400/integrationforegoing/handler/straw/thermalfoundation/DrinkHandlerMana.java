package me.jacky1356400.integrationforegoing.handler.straw.thermalfoundation;

import com.buuz135.industrial.api.fluid.IFluidDrinkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

public class DrinkHandlerMana implements IFluidDrinkHandler {
    @Override
    public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
        player.attackEntityFrom(new ManaDamage(), 10);
        player.setFire(10);
        player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 60 * 20, 0));
    }
    private class ManaDamage extends DamageSource {
        public ManaDamage() {
            super("mana");
            this.setDamageBypassesArmor();
            this.setDifficultyScaled();
        }
    }
}
