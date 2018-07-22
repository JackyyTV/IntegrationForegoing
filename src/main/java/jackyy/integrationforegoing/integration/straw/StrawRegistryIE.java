package jackyy.integrationforegoing.integration.straw;

import com.buuz135.industrial.api.straw.StrawHandler;
import com.buuz135.industrial.utils.apihandlers.straw.PotionStrawHandler;
import com.buuz135.industrial.utils.apihandlers.straw.StrawHandlerBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class StrawRegistryIE {

    @SubscribeEvent
    public void register(RegistryEvent.Register<StrawHandler> event) {
        IForgeRegistry<StrawHandler> registry = event.getRegistry();
        registry.register(new StrawHandlerBase("biodiesel") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.setFire(10);
            }
        }.setRegistryName("biodiesel"));
        registry.register(new PotionStrawHandler("concrete")
                .addPotion(new PotionEffect(MobEffects.SLOWNESS, 60 * 20, 3))
                .addPotion(new PotionEffect(MobEffects.MINING_FATIGUE, 60 * 20, 3))
                .setRegistryName("concrete"));
        registry.register(new StrawHandlerBase("creosote") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.setFire(15);
            }
        }.setRegistryName("creosote"));
        registry.register(new PotionStrawHandler("ethanol")
                .addPotion(new PotionEffect(MobEffects.NAUSEA, 60 * 20, 0))
                .setRegistryName("ethanol"));
        registry.register(new StrawHandlerBase("plantoil") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.setFire(15);
            }
        }.setRegistryName("plantoil"));
    }

}
