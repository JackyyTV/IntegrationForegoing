package jackydev.integrationforegoing.handler.straw.thermalfoundation;

import com.buuz135.industrial.utils.strawhandlers.StrawHandlerBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

public class DrinkHandlerPetrotheum extends StrawHandlerBase {
    public DrinkHandlerPetrotheum() {
        super("petrotheum");
        setRegistryName("petrotheum");
    }
    @Override
    public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
        player.attackEntityFrom(new PetrotheumDamage(), 10);
        player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 300 * 20, 3));
        player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 300 * 20, 2));
    }
    private class PetrotheumDamage extends DamageSource {
        public PetrotheumDamage() {
            super("petrotheum");
            this.setDamageBypassesArmor();
            this.setDifficultyScaled();
        }
    }
}
