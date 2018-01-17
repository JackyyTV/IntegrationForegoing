package jackyy.integrationforegoing.integration.straw;

import com.buuz135.industrial.api.straw.StrawHandler;
import com.buuz135.industrial.utils.strawhandlers.PotionStrawHandler;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class StrawRegistryExNihiloCreatio {

    @SubscribeEvent
    public void register(RegistryEvent.Register<StrawHandler> event) {
        IForgeRegistry<StrawHandler> registry = event.getRegistry();
        registry.register(new PotionStrawHandler("witchwater")
                .addPotion(new PotionEffect(MobEffects.BLINDNESS, 60 * 20, 0))
                .addPotion(new PotionEffect(MobEffects.WITHER, 30 * 20, 0))
                .addPotion(new PotionEffect(MobEffects.WEAKNESS, 30 * 20, 2))
                .addPotion(new PotionEffect(MobEffects.SLOWNESS, 60 * 20, 0))
                .setRegistryName("witchwater"));
    }

}
