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

public class StrawRegistryIP {

    @SubscribeEvent
    public void register(RegistryEvent.Register<StrawHandler> event) {
        IForgeRegistry<StrawHandler> registry = event.getRegistry();
        registry.register(new StrawHandlerBase("oil") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 60 * 20, 2));
            }
        }.setRegistryName("ip_crude_oil"));
        registry.register(new StrawHandlerBase("diesel") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.setFire(10);
            }
        }.setRegistryName("ip_diesel"));
        registry.register(new PotionStrawHandler("lubricant")
                .addPotion(new PotionEffect(MobEffects.SPEED, 60 * 20, 5))
                .setRegistryName("ip_lubricant"));
        registry.register(new StrawHandlerBase("gasoline") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.setFire(20);
            }
        }.setRegistryName("ip_gasoline"));
        registry.register(new StrawHandlerBase("napalm") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.setFire(20);
            }
        }.setRegistryName("ip_napalm"));
    }

}
