package jackyy.integrationforegoing.integration.straw;

import com.buuz135.industrial.api.straw.StrawHandler;
import com.buuz135.industrial.utils.apihandlers.straw.PotionStrawHandler;
import com.buuz135.industrial.utils.apihandlers.straw.StrawHandlerBase;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class StrawRegistryImmersivePetroleum {

    @SubscribeEvent
    public void register(RegistryEvent.Register<StrawHandler> event) {
        IForgeRegistry<StrawHandler> registry = event.getRegistry();
        registry.register(new PotionStrawHandler(ModUtils.getFluidByName(ModNames.IP, "oil"))
                .addPotion(new EffectInstance(Effects.SLOWNESS, 60 * 20, 2))
                .setRegistryName("ip_crude_oil"));
        registry.register(new StrawHandlerBase(() -> ModUtils.getFluidByName(ModNames.IP, "diesel")) {
            @Override
            public void onDrink(World world, BlockPos pos, Fluid fluid, PlayerEntity player, boolean fromFluidContainer) {
                player.setFire(10);
            }
        }.setRegistryName("ip_diesel"));
        registry.register(new PotionStrawHandler(ModUtils.getFluidByName(ModNames.IP, "lubricant"))
                .addPotion(new EffectInstance(Effects.SPEED, 60 * 20, 5))
                .setRegistryName("ip_lubricant"));
        registry.register(new StrawHandlerBase(() -> ModUtils.getFluidByName(ModNames.IP, "gasoline")) {
            @Override
            public void onDrink(World world, BlockPos pos, Fluid fluid, PlayerEntity player, boolean fromFluidContainer) {
                player.setFire(20);
            }
        }.setRegistryName("ip_gasoline"));
        registry.register(new StrawHandlerBase(() -> ModUtils.getFluidByName(ModNames.IP, "napalm")) {
            @Override
            public void onDrink(World world, BlockPos pos, Fluid fluid, PlayerEntity player, boolean fromFluidContainer) {
                player.setFire(20);
            }
        }.setRegistryName("ip_napalm"));
    }

}
