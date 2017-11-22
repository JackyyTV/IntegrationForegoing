package jackydev.integrationforegoing.handler.straw.thermalfoundation;

import com.buuz135.industrial.api.straw.StrawHandler;
import com.buuz135.industrial.utils.strawhandlers.PotionStrawHandler;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class StrawRegistryTF {

    @SubscribeEvent
    public void register(RegistryEvent.Register<StrawHandler> event) {
        IForgeRegistry<StrawHandler> registry = event.getRegistry();
        registry.registerAll(
                new DrinkHandlerCryotheum(), new DrinkHandlerEnder(), new DrinkHandlerMana(), new DrinkHandlerPetrotheum(),
                new DrinkHandlerPyrotheum(), new DrinkHandlerRedstone(), new DrinkHandlerSteam()
        );
        registry.register(new PotionStrawHandler("aerotheum")
                .addPotion(new PotionEffect(MobEffects.WATER_BREATHING, 240 * 20, 0))
                .addPotion(new PotionEffect(MobEffects.INVISIBILITY, 60 * 20, 0))
                .addPotion(new PotionEffect(MobEffects.LEVITATION, 30 * 20, 0))
                .setRegistryName("aerotheum"));
        registry.register(new PotionStrawHandler("coal")
                .addPotion(new PotionEffect(MobEffects.HASTE, 60 * 20, 0))
                .addPotion(new PotionEffect(MobEffects.BLINDNESS, 10 * 20, 0))
                .setRegistryName("coal"));
        registry.register(new PotionStrawHandler("crude_oil")
                .addPotion(new PotionEffect(MobEffects.SLOWNESS, 60 * 20, 2))
                .addPotion(new PotionEffect(MobEffects.BLINDNESS, 60 * 20, 0))
                .setRegistryName("crude_oil"));
        registry.register(new PotionStrawHandler("glowstone")
                .addPotion(new PotionEffect(MobEffects.SPEED, 60 * 20, 2))
                .addPotion(new PotionEffect(MobEffects.JUMP_BOOST, 60 * 20, 2))
                .addPotion(new PotionEffect(MobEffects.NIGHT_VISION, 60 * 20, 0))
                .addPotion(new PotionEffect(MobEffects.LEVITATION, 30 * 20, 0))
                .setRegistryName("glowstone"));
    }

}
