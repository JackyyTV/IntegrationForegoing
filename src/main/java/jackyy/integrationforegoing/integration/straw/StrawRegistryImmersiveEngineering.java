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

public class StrawRegistryImmersiveEngineering {

    @SubscribeEvent
    public void register(RegistryEvent.Register<StrawHandler> event) {
        IForgeRegistry<StrawHandler> registry = event.getRegistry();
        registry.register(new StrawHandlerBase(() -> ModUtils.getFluidByName(ModNames.IE, "biodiesel")) {
            @Override
            public void onDrink(World world, BlockPos pos, Fluid fluid, PlayerEntity player, boolean fromFluidContainer) {
                player.setFire(10);
            }
        }.setRegistryName("biodiesel"));
        registry.register(new PotionStrawHandler(ModUtils.getFluidByName(ModNames.IE, "concrete"))
                .addPotion(new EffectInstance(Effects.SLOWNESS, 60 * 20, 3))
                .addPotion(new EffectInstance(Effects.MINING_FATIGUE, 60 * 20, 3))
                .setRegistryName("concrete"));
        registry.register(new StrawHandlerBase(() -> ModUtils.getFluidByName(ModNames.IE, "creosote")) {
            @Override
            public void onDrink(World world, BlockPos pos, Fluid fluid, PlayerEntity player, boolean fromFluidContainer) {
                player.setFire(15);
            }
        }.setRegistryName("creosote"));
        registry.register(new PotionStrawHandler(ModUtils.getFluidByName(ModNames.IE, "ethanol"))
                .addPotion(new EffectInstance(Effects.NAUSEA, 60 * 20, 0))
                .setRegistryName("ethanol"));
        registry.register(new PotionStrawHandler(ModUtils.getFluidByName(ModNames.IE, "herbicide"))
                .addPotion(new EffectInstance(Effects.NAUSEA, 60 * 20, 0))
                .addPotion(new EffectInstance(Effects.POISON, 60 * 20, 0))
                .addPotion(new EffectInstance(Effects.SPEED, 60 * 20, 1))
                .setRegistryName("herbicide"));
        registry.register(new StrawHandlerBase(() -> ModUtils.getFluidByName(ModNames.IE, "plantoil")) {
            @Override
            public void onDrink(World world, BlockPos pos, Fluid fluid, PlayerEntity player, boolean fromFluidContainer) {
                player.setFire(15);
            }
        }.setRegistryName("plantoil"));
    }

}
