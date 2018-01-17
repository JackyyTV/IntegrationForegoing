package jackyy.integrationforegoing.integration.straw;

import com.buuz135.industrial.api.straw.StrawHandler;
import com.buuz135.industrial.utils.strawhandlers.PotionStrawHandler;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class StrawRegistryIE {

    @SubscribeEvent
    public void register(RegistryEvent.Register<StrawHandler> event) {
        IForgeRegistry<StrawHandler> registry = event.getRegistry();
        registry.register(new PotionStrawHandler("biodiesel")
                .addPotion(new PotionEffect(ModUtils.getPotionByObject(ModNames.IE, "flammable"), 60 * 20, 1))
                .setRegistryName("biodiesel"));
        registry.register(new PotionStrawHandler("concrete")
                .addPotion(new PotionEffect(MobEffects.SLOWNESS, 60 * 20, 3))
                .addPotion(new PotionEffect(ModUtils.getPotionByObject(ModNames.IE, "concreteFeet"), 60 * 20, 0))
                .addPotion(new PotionEffect(MobEffects.MINING_FATIGUE, 60 * 20, 3))
                .setRegistryName("concrete"));
        registry.register(new PotionStrawHandler("creosote")
                .addPotion(new PotionEffect(ModUtils.getPotionByObject(ModNames.IE, "flammable"), 60 * 20, 0))
                .setRegistryName("creosote"));
        registry.register(new PotionStrawHandler("ethanol")
                .addPotion(new PotionEffect(MobEffects.NAUSEA, 60 * 20, 0))
                .setRegistryName("ethanol"));
        registry.register(new PotionStrawHandler("plantoil")
                .addPotion(new PotionEffect(ModUtils.getPotionByObject(ModNames.IE, "flammable"), 60 * 20, 0))
                .setRegistryName("plantoil"));
    }

}
