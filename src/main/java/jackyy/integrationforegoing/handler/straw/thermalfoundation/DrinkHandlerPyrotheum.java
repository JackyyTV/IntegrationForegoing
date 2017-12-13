package jackyy.integrationforegoing.handler.straw.thermalfoundation;

import com.buuz135.industrial.utils.strawhandlers.StrawHandlerBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

public class DrinkHandlerPyrotheum extends StrawHandlerBase {
    public DrinkHandlerPyrotheum() {
        super("pyrotheum");
        setRegistryName("pyrotheum");
    }
    @Override
    public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
        player.attackEntityFrom(new PyrotheumDamage(), 15);
        player.setFire(60);
        NBTTagCompound tag = player.getEntityData();
        tag.setLong("drankLavaTime", player.world.getTotalWorldTime());
    }
    private class PyrotheumDamage extends DamageSource {
        public PyrotheumDamage() {
            super("pyrotheum");
            this.setDamageBypassesArmor();
            this.setFireDamage();
            this.setDifficultyScaled();
        }
    }
}
