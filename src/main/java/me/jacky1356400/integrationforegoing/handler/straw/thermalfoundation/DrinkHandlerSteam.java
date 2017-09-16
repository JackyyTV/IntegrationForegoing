package me.jacky1356400.integrationforegoing.handler.straw.thermalfoundation;

import com.buuz135.industrial.utils.strawhandlers.StrawHandlerBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

public class DrinkHandlerSteam extends StrawHandlerBase {
    public DrinkHandlerSteam() {
        super("steam");
        setRegistryName("steam");
    }
    @Override
    public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
        player.setFire(30);
        player.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 30 * 20, 0));
    }
}
