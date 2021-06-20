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

public class StrawRegistryThermal {

    @SubscribeEvent
    public void register(RegistryEvent.Register<StrawHandler> event) {
        IForgeRegistry<StrawHandler> registry = event.getRegistry();
        registry.register(new PotionStrawHandler(ModUtils.getFluidByName(ModNames.THERMAL, "sap"))
                .addPotion(new EffectInstance(Effects.SLOWNESS, 60 * 20, 0))
                .addPotion(new EffectInstance(Effects.NAUSEA, 30 * 20, 0))
                .setRegistryName("sap"));
        registry.register(new PotionStrawHandler(ModUtils.getFluidByName(ModNames.THERMAL, "syrup"))
                .addPotion(new EffectInstance(Effects.SPEED, 60 * 20, 0))
                .addPotion(new EffectInstance(Effects.REGENERATION, 60 * 20, 0))
                .setRegistryName("syrup"));
        registry.register(new PotionStrawHandler(ModUtils.getFluidByName(ModNames.THERMAL, "resin"))
                .addPotion(new EffectInstance(Effects.SLOWNESS, 60 * 20, 0))
                .setRegistryName("resin"));
        registry.register(new PotionStrawHandler(ModUtils.getFluidByName(ModNames.THERMAL, "tree_oil"))
                .addPotion(new EffectInstance(Effects.SLOWNESS, 60 * 20, 0))
                .addPotion(new EffectInstance(Effects.POISON, 60 * 20, 0))
                .setRegistryName("tree_oil"));
        registry.register(new PotionStrawHandler(ModUtils.getFluidByName(ModNames.THERMAL, "latex"))
                .addPotion(new EffectInstance(Effects.POISON, 50 * 20, 2))
                .addPotion(new EffectInstance(Effects.SLOWNESS, 50 * 20, 2))
                .setRegistryName("thermal_latex"));
        registry.register(new StrawHandlerBase(() -> ModUtils.getFluidByName(ModNames.THERMAL, "creosote")) {
            @Override
            public void onDrink(World world, BlockPos pos, Fluid fluid, PlayerEntity player, boolean fromFluidContainer) {
                player.setFire(15);
            }
        }.setRegistryName("creosote"));
        registry.register(new PotionStrawHandler(ModUtils.getFluidByName(ModNames.THERMAL, "crude_oil"))
                .addPotion(new EffectInstance(Effects.SLOWNESS, 60 * 20, 2))
                .setRegistryName("crude_oil"));
        registry.register(new PotionStrawHandler(ModUtils.getFluidByName(ModNames.THERMAL, "heavy_oil"))
                .addPotion(new EffectInstance(Effects.SLOWNESS, 60 * 20, 2))
                .addPotion(new EffectInstance(Effects.NAUSEA, 60 * 20, 0))
                .setRegistryName("heavy_oil"));
        registry.register(new PotionStrawHandler(ModUtils.getFluidByName(ModNames.THERMAL, "light_oil"))
                .addPotion(new EffectInstance(Effects.SLOWNESS, 60 * 20, 1))
                .addPotion(new EffectInstance(Effects.NAUSEA, 30 * 20, 0))
                .setRegistryName("light_oil"));
        registry.register(new StrawHandlerBase(() -> ModUtils.getFluidByName(ModNames.IP, "refined_fuel")) {
            @Override
            public void onDrink(World world, BlockPos pos, Fluid fluid, PlayerEntity player, boolean fromFluidContainer) {
                player.setFire(20);
                player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 60 * 20, 0));
            }
        }.setRegistryName("refined_fuel"));
    }

}
