package jackyy.integrationforegoing.integration.straw;

import com.buuz135.industrial.api.straw.StrawHandler;
import com.buuz135.industrial.utils.strawhandlers.PotionStrawHandler;
import com.buuz135.industrial.utils.strawhandlers.StrawHandlerBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class StrawRegistryEnderIO {

    @SubscribeEvent
    public void register(RegistryEvent.Register<StrawHandler> event) {
        IForgeRegistry<StrawHandler> registry = event.getRegistry();
        registry.register(new StrawHandlerBase("nutrient_distillation") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.getFoodStats().addStats(5, 1.0F);
                player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 30 * 20, 0));
            }
        }.setRegistryName("nutrient_distillation"));
        registry.register(new PotionStrawHandler("ender_distillation")
                .addPotion(new PotionEffect(MobEffects.SATURATION, 10 * 20, 0))
                .addPotion(new PotionEffect(MobEffects.REGENERATION, 60 * 20, 0))
                .addPotion(new PotionEffect(MobEffects.SPEED, 60 * 20, 0))
                .setRegistryName("dew_of_the_void"));
        registry.register(new StrawHandlerBase("vapor_of_levity") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.extinguish();
                player.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 60 * 20, 0));
                player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 480 * 20, 0));
                player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 480 * 20, 0));
            }
        }.setRegistryName("vapor_of_levity"));
        registry.register(new PotionStrawHandler("hootch")
                .addPotion(new PotionEffect(MobEffects.NAUSEA, 60 * 20, 0))
                .setRegistryName("hootch"));
        registry.register(new PotionStrawHandler("rocket_fuel")
                .addPotion(new PotionEffect(MobEffects.JUMP_BOOST, 180 * 20, 3))
                .setRegistryName("rocket_fuel"));
        registry.register(new StrawHandlerBase("fire_water") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.setFire(30);
            }
        }.setRegistryName("fire_water"));
        registry.register(new PotionStrawHandler("liquid_sunshine")
                .addPotion(new PotionEffect(MobEffects.GLOWING, 120 * 20, 0))
                .addPotion(new PotionEffect(MobEffects.LEVITATION, 30 * 20, 0))
                .setRegistryName("liquid_sunshine"));
        registry.register(new PotionStrawHandler("cloud_seed")
                .addPotion(new PotionEffect(MobEffects.LEVITATION, 30 * 20, 0))
                .setRegistryName("cloud_seed"));
        registry.register(new PotionStrawHandler("cloud_seed_concentrated")
                .addPotion(new PotionEffect(MobEffects.LEVITATION, 60 * 20, 0))
                .addPotion(new PotionEffect(MobEffects.BLINDNESS, 60 * 20, 0))
                .setRegistryName("cloud_seed_concentrated"));
    }

}
