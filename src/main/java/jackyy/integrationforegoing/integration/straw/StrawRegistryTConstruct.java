package jackyy.integrationforegoing.integration.straw;

import com.buuz135.industrial.api.straw.StrawHandler;
import com.buuz135.industrial.utils.strawhandlers.PotionStrawHandler;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class StrawRegistryTConstruct {

    @SubscribeEvent
    public void register(RegistryEvent.Register<StrawHandler> event) {
        IForgeRegistry<StrawHandler> registry = event.getRegistry();
        registry.register(new PotionStrawHandler("blood")
                .addPotion(new PotionEffect(MobEffects.POISON, 30 * 20, 0))
                .addPotion(new PotionEffect(MobEffects.REGENERATION, 30 * 20, 0))
                .addPotion(new PotionEffect(MobEffects.HEALTH_BOOST, 30 * 20, 0))
                .setRegistryName("tcon_blood"));
        registry.register(new PotionStrawHandler("blueslime")
                .addPotion(new PotionEffect(MobEffects.SLOWNESS, 60 * 20, 2))
                .addPotion(new PotionEffect(MobEffects.JUMP_BOOST, 60 * 20, 2))
                .setRegistryName("blueslime"));
        registry.register(new PotionStrawHandler("purpleslime")
                .addPotion(new PotionEffect(MobEffects.SLOWNESS, 60 * 20, 2))
                .addPotion(new PotionEffect(MobEffects.JUMP_BOOST, 60 * 20, 2))
                .setRegistryName("purpleslime"));
    }

}
