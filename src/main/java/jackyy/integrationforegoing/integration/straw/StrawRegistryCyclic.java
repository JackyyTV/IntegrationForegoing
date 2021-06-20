package jackyy.integrationforegoing.integration.straw;

import com.buuz135.industrial.api.straw.StrawHandler;
import com.buuz135.industrial.utils.apihandlers.straw.PotionStrawHandler;
import com.buuz135.industrial.utils.apihandlers.straw.StrawHandlerBase;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;
import net.minecraft.entity.item.ExperienceBottleEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class StrawRegistryCyclic {

    @SubscribeEvent
    public void register(RegistryEvent.Register<StrawHandler> event) {
        IForgeRegistry<StrawHandler> registry = event.getRegistry();
        registry.register(new PotionStrawHandler(ModUtils.getFluidByName(ModNames.CYCLIC, "biomass"))
                .addPotion(new EffectInstance(Effects.NAUSEA, 60 * 20, 0))
                .addPotion(new EffectInstance(Effects.POISON, 60 * 20, 0))
                .setRegistryName("biomass"));
        registry.register(new PotionStrawHandler(ModUtils.getFluidByName(ModNames.CYCLIC, "honey"))
                .addPotion(new EffectInstance(Effects.REGENERATION, 60 * 20, 1))
                .addPotion(new EffectInstance(Effects.SPEED, 60 * 20, 0))
                .addPotion(new EffectInstance(Effects.HASTE, 60 * 20, 0))
                .setRegistryName("honey"));
        registry.register(new StrawHandlerBase(() -> ModUtils.getFluidByName(ModNames.CYCLIC, "magma")) {
            @Override
            public void onDrink(World world, BlockPos pos, Fluid fluid, PlayerEntity player, boolean fromFluidContainer) {
                player.setFire(30);
            }
        }.setRegistryName("magma"));
        registry.register(new PotionStrawHandler(ModUtils.getFluidByName(ModNames.CYCLIC, "slime"))
                .addPotion(new EffectInstance(Effects.SLOWNESS, 60 * 20, 3))
                .setRegistryName("slime"));
        registry.register(new StrawHandlerBase(() -> ModUtils.getFluidByName(ModNames.CYCLIC, "xpjuice")) {
            @Override
            public void onDrink(World world, BlockPos pos, Fluid fluid, PlayerEntity player, boolean fromFluidContainer) {
                int i = 100 + world.rand.nextInt(50);
                while (i > 0) {
                    int j = ExperienceOrbEntity.getXPSplit(i);
                    i -= j;
                    world.addEntity(new ExperienceOrbEntity(world, player.getPosX(), player.getPosY(), player.getPosZ(), j));
                }
            }
        }.setRegistryName("cyclic_experience"));
    }

}
