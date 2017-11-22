package jackydev.integrationforegoing.handler.straw.thermalfoundation;

import com.buuz135.industrial.utils.strawhandlers.StrawHandlerBase;
import jackydev.integrationforegoing.Config;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.fluids.FluidStack;

public class DrinkHandlerEnder extends StrawHandlerBase {
    public DrinkHandlerEnder() {
        super("ender");
        setRegistryName("ender");
    }
    @Override
    public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
        if (!world.isRemote) {
            double x = player.posX - MathHelper.clamp(Config.strawEnderRange, 8, 65536) + player.world.rand.nextInt(MathHelper.clamp(Config.strawEnderRange, 8, 65536) * 2);
            double y = player.posY + player.world.rand.nextInt(8);
            double z = player.posZ - MathHelper.clamp(Config.strawEnderRange, 8, 65536) + player.world.rand.nextInt(MathHelper.clamp(Config.strawEnderRange, 8, 65536) * 2);
            EnderTeleportEvent event = new EnderTeleportEvent(player, x, y, z, 0);

            if (!player.world.getBlockState(new BlockPos(x, y, z)).getMaterial().isSolid()) {
                player.setPositionAndUpdate(event.getTargetX(), event.getTargetY(), event.getTargetZ());
                player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 60));
            } else {
                for (int i = 0; i < 1 + player.world.rand.nextInt(3); i++) {
                    player.entityDropItem(new ItemStack(Items.ENDER_PEARL), 0);
                }
            }
        }
    }
}
