package jackyy.integrationforegoing.integration.straw;

import com.buuz135.industrial.api.straw.StrawHandler;
import com.buuz135.industrial.utils.apihandlers.straw.PotionStrawHandler;
import jackyy.integrationforegoing.util.ModNames;
import jackyy.integrationforegoing.util.ModUtils;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class StrawRegistryExNihiloSequentia {

    @SubscribeEvent
    public void register(RegistryEvent.Register<StrawHandler> event) {
        IForgeRegistry<StrawHandler> registry = event.getRegistry();
        registry.register(new PotionStrawHandler(ModUtils.getFluidByName(ModNames.EXNIHILOSEQUENTIA, "witchwater"))
                .addPotion(new EffectInstance(Effects.BLINDNESS, 60 * 20, 0))
                .addPotion(new EffectInstance(Effects.WITHER, 30 * 20, 0))
                .addPotion(new EffectInstance(Effects.WEAKNESS, 30 * 20, 2))
                .addPotion(new EffectInstance(Effects.SLOWNESS, 60 * 20, 0))
                .setRegistryName("witchwater"));
        registry.register(new PotionStrawHandler(ModUtils.getFluidByName(ModNames.EXNIHILOSEQUENTIA, "sea_water"))
                .addPotion(new EffectInstance(Effects.WATER_BREATHING, 60 * 20, 2))
                .setRegistryName("sea_water"));
    }

}
