package jackyy.integrationforegoing.integration.straw;

import com.buuz135.industrial.api.straw.StrawHandler;
import com.buuz135.industrial.utils.strawhandlers.PotionStrawHandler;
import com.buuz135.industrial.utils.strawhandlers.StrawHandlerBase;
import jackyy.integrationforegoing.config.Config;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class StrawRegistryThermalFoundation {

    @SubscribeEvent
    public void register(RegistryEvent.Register<StrawHandler> event) {
        IForgeRegistry<StrawHandler> registry = event.getRegistry();
        registry.register(new StrawHandlerBase("cryotheum") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.attackEntityFrom(new CryotheumDamage(), 15);
                player.extinguish();
                player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 480 * 20, 0));
            }
            class CryotheumDamage extends DamageSource {
                CryotheumDamage() {
                    super("cryotheum");
                    this.setDamageBypassesArmor();
                    this.setMagicDamage();
                    this.setDifficultyScaled();
                }
            }
        }.setRegistryName("cryotheum"));
        registry.register(new StrawHandlerBase("ender") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                if (!world.isRemote) {
                    double x = player.posX - MathHelper.clamp(Config.strawEnderRange, 8, 65536) + player.world.rand.nextInt(MathHelper.clamp(Config.strawEnderRange, 8, 65536) * 2);
                    double y = player.posY + player.world.rand.nextInt(8);
                    double z = player.posZ - MathHelper.clamp(Config.strawEnderRange, 8, 65536) + player.world.rand.nextInt(MathHelper.clamp(Config.strawEnderRange, 8, 65536) * 2);
                    EnderTeleportEvent event = new EnderTeleportEvent(player, x, y, z, 0);

                    if (!player.world.getBlockState(new BlockPos(x, y, z)).getMaterial().isSolid()) {
                        player.setPositionAndUpdate(event.getTargetX(), event.getTargetY(), event.getTargetZ());
                        player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
                        player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 60));
                    } else {
                        for (int i = 0; i < 1 + player.world.rand.nextInt(3); i++) {
                            player.entityDropItem(new ItemStack(Items.ENDER_PEARL), 0);
                        }
                    }
                }
            }
        }.setRegistryName("ender"));
        registry.register(new StrawHandlerBase("mana") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.attackEntityFrom(new ManaDamage(), 10);
                player.setFire(10);
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 60 * 20, 0));
            }
            class ManaDamage extends DamageSource {
                ManaDamage() {
                    super("mana");
                    this.setDamageBypassesArmor();
                    this.setDifficultyScaled();
                }
            }
        }.setRegistryName("mana"));
        registry.register(new StrawHandlerBase("petrotheum") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.attackEntityFrom(new PetrotheumDamage(), 10);
                player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 300 * 20, 3));
                player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 300 * 20, 2));
            }
            class PetrotheumDamage extends DamageSource {
                PetrotheumDamage() {
                    super("petrotheum");
                    this.setDamageBypassesArmor();
                    this.setDifficultyScaled();
                }
            }
        }.setRegistryName("petrotheum"));
        registry.register(new StrawHandlerBase("pyrotheum") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.attackEntityFrom(new PyrotheumDamage(), 15);
                player.setFire(60);
                NBTTagCompound tag = player.getEntityData();
                tag.setLong("drankLavaTime", player.world.getTotalWorldTime());
            }
            class PyrotheumDamage extends DamageSource {
                PyrotheumDamage() {
                    super("pyrotheum");
                    this.setDamageBypassesArmor();
                    this.setFireDamage();
                    this.setDifficultyScaled();
                }
            }
        }.setRegistryName("pyrotheum"));
        registry.register(new StrawHandlerBase("redstone") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                ArrayList<PotionEffect> effects = new ArrayList<>(player.getActivePotionEffects());
                for (PotionEffect effect : effects) {
                    amplifyEffect(player, effect);
                }
                player.setFire(2);
                EntityLightningBolt bolt = new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), false);
                world.addWeatherEffect(bolt);
                world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, pos.getX(), pos.getY() + 1, pos.getZ(), 0.0D, 0.0D, 0.0D);
                world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
            private boolean amplifyEffect(EntityLivingBase player, PotionEffect effect) {
                if (effect == null || effect.getIsAmbient()) {
                    return false;
                }
                int amplifier = Math.min(effect.getAmplifier() + 1, 3);
                int duration = Math.min(effect.getDuration() * 2, 9600);
                player.addPotionEffect(new PotionEffect(effect.getPotion(), duration, amplifier));
                return true;
            }
        }.setRegistryName("redstone"));
        registry.register(new StrawHandlerBase("steam") {
            @Override
            public void onDrink(World world, BlockPos pos, FluidStack stack, EntityPlayer player, boolean fromFluidContainer) {
                player.setFire(30);
                player.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 30 * 20, 0));
            }
        }.setRegistryName("steam"));
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
