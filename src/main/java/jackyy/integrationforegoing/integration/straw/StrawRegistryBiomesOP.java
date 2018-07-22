package jackyy.integrationforegoing.integration.straw;

import com.buuz135.industrial.api.straw.StrawHandler;
import com.buuz135.industrial.utils.apihandlers.straw.PotionStrawHandler;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class StrawRegistryBiomesOP {

    @SubscribeEvent
    public void register(RegistryEvent.Register<StrawHandler> event) {
        IForgeRegistry<StrawHandler> registry = event.getRegistry();
        registry.register(new PotionStrawHandler("sand")
                .addPotion(new PotionEffect(MobEffects.SLOWNESS, 300 * 20, 5))
                .addPotion(new PotionEffect(MobEffects.MINING_FATIGUE, 300 * 20, 5))
                .addPotion(new PotionEffect(MobEffects.BLINDNESS, 300 * 20, 0))
                .setRegistryName("quicksand"));
        registry.register(new PotionStrawHandler("blood")
                .addPotion(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 1))
                .setRegistryName("bop_blood"));
        registry.register(new PotionStrawHandler("poison")
                .addPotion(new PotionEffect(MobEffects.POISON, 120 * 20, 0))
                .addPotion(new PotionEffect(MobEffects.HUNGER, 120 * 20, 0))
                .setRegistryName("poison"));
        registry.register(new PotionStrawHandler("hot_spring_water")
                .addPotion(new PotionEffect(MobEffects.REGENERATION, 120 * 20, 0))
                .setRegistryName("hot_spring_water"));
        registry.register(new PotionStrawHandler("honey")
                .addPotion(new PotionEffect(MobEffects.REGENERATION, 120 * 20, 1))
                .addPotion(new PotionEffect(MobEffects.SATURATION, 120 * 20, 0))
                .setRegistryName("bop_honey"));
    }

}
