package me.jacky1356400.integrationforegoing.handler.straw.immersiveengineering;

import com.buuz135.industrial.api.fluid.IFluidDrinkHandler;
import me.jacky1356400.integrationforegoing.util.ModUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

public class DrinkHandlerBiodiesel implements IFluidDrinkHandler {
    @Override
    public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
        player.addPotionEffect(new PotionEffect(ModUtils.getPotionByObject("immersiveengineering", "flammable"), 60 * 20, 1));
    }
}
