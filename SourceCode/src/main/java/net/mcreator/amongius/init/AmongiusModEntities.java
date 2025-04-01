
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.amongius.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.amongius.entity.AmongleEntity;
import net.mcreator.amongius.entity.AmongProjectileEntity;
import net.mcreator.amongius.entity.AmongMissileUpEntity;
import net.mcreator.amongius.entity.AmongMissileDownEntity;
import net.mcreator.amongius.entity.AmongCarEntity;
import net.mcreator.amongius.AmongiusMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AmongiusModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AmongiusMod.MODID);
	public static final RegistryObject<EntityType<AmongleEntity>> AMONGLE = register("amongle",
			EntityType.Builder.<AmongleEntity>of(AmongleEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AmongleEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AmongProjectileEntity>> AMONG_PROJECTILE = register("among_projectile", EntityType.Builder.<AmongProjectileEntity>of(AmongProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(AmongProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AmongMissileUpEntity>> AMONG_MISSILE_UP = register("among_missile_up", EntityType.Builder.<AmongMissileUpEntity>of(AmongMissileUpEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AmongMissileUpEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AmongMissileDownEntity>> AMONG_MISSILE_DOWN = register("among_missile_down", EntityType.Builder.<AmongMissileDownEntity>of(AmongMissileDownEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AmongMissileDownEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AmongCarEntity>> AMONG_CAR = register("among_car",
			EntityType.Builder.<AmongCarEntity>of(AmongCarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AmongCarEntity::new)

					.sized(0.6f, 0.9f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			AmongleEntity.init();
			AmongMissileUpEntity.init();
			AmongMissileDownEntity.init();
			AmongCarEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(AMONGLE.get(), AmongleEntity.createAttributes().build());
		event.put(AMONG_MISSILE_UP.get(), AmongMissileUpEntity.createAttributes().build());
		event.put(AMONG_MISSILE_DOWN.get(), AmongMissileDownEntity.createAttributes().build());
		event.put(AMONG_CAR.get(), AmongCarEntity.createAttributes().build());
	}
}
