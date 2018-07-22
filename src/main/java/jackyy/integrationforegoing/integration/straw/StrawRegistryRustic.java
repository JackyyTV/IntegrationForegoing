package jackyy.integrationforegoing.integration.straw;

import com.buuz135.industrial.api.straw.StrawHandler;
import com.buuz135.industrial.utils.apihandlers.straw.StrawHandlerBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class StrawRegistryRustic {

    @SubscribeEvent
    public void register(RegistryEvent.Register<StrawHandler> event) {
        IForgeRegistry<StrawHandler> registry = event.getRegistry();
        registry.register(new StrawHandlerBase("oliveoil") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.getFoodStats().addStats(1, 0.4F);
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 600, 1));
            }
        }.setRegistryName("oliveoil"));
        registry.register(new StrawHandlerBase("ironberryjuice") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.getFoodStats().addStats(1, 0.8F);
                player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 600, 15, false, false));
                player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 600, 15, false, false));
                player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 600, 15, false, false));
                player.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 600, 15, false, false));
                player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 600, 15, false, false));
                player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 600, 250, false, false));
            }
        }.setRegistryName("ironberryjuice"));
        registry.register(new StrawHandlerBase("wildberryjuice") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.getFoodStats().addStats(1, 1F);
                if (player.getRNG().nextFloat() < 0.2F) {
                    player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 75));
                }
                if (player.getRNG().nextFloat() < 0.1F) {
                    player.addPotionEffect(new PotionEffect(MobEffects.POISON, 200));
                }
            }
        }.setRegistryName("wildberryjuice"));
        registry.register(new StrawHandlerBase("grapejuice") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.getFoodStats().addStats(1, 0.9F);
            }
        }.setRegistryName("grapejuice"));
        registry.register(new StrawHandlerBase("applejuice") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.getFoodStats().addStats(1, 1.2F);
            }
        }.setRegistryName("applejuice"));
        registry.register(new StrawHandlerBase("alewort") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.getFoodStats().addStats(1, 2F);
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 400, 1));
            }
        }.setRegistryName("alewort"));
        registry.register(new StrawHandlerBase("honey") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.getFoodStats().addStats(3, 0.4F);
                if (player.getRNG().nextFloat() < 0.6F) {
                    player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 75));
                }
            }
        }.setRegistryName("rustic_honey"));
    }

}
