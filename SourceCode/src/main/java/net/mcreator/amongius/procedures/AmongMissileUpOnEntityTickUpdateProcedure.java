package net.mcreator.amongius.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.amongius.init.AmongiusModEntities;
import net.mcreator.amongius.entity.AmongMissileUpEntity;

import java.util.Comparator;

public class AmongMissileUpOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean hasTarget = false;
		double airTime = 0;
		Entity launcher = null;
		Entity target = null;
		world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, ((Math.random() - 0.5) / 10), 0, ((Math.random() - 0.5) / 10));
		world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, ((Math.random() - 0.5) / 7), 0, ((Math.random() - 0.5) / 7));
		world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, ((Math.random() - 0.5) / 4), 0, ((Math.random() - 0.5) / 4));
		if (!world.isEmptyBlock(BlockPos.containing(x, y + 2, z))) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 10, Level.ExplosionInteraction.TNT);
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if ((entity instanceof AmongMissileUpEntity _datEntI ? _datEntI.getEntityData().get(AmongMissileUpEntity.DATA_airTime) : 0) > 115) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = AmongiusModEntities.AMONG_MISSILE_DOWN.get().spawn(_level, BlockPos.containing(entity instanceof AmongMissileUpEntity _datEntI ? _datEntI.getEntityData().get(AmongMissileUpEntity.DATA_targeterX) : 0, y,
						entity instanceof AmongMissileUpEntity _datEntI ? _datEntI.getEntityData().get(AmongMissileUpEntity.DATA_targeterZ) : 0), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		} else {
			entity.setDeltaMovement(new Vec3(0, (0.05 * Math.pow(1.045, entity instanceof AmongMissileUpEntity _datEntI ? _datEntI.getEntityData().get(AmongMissileUpEntity.DATA_airTime) : 0)), 0));
		}
		if (entity instanceof AmongMissileUpEntity _datEntSetI)
			_datEntSetI.getEntityData().set(AmongMissileUpEntity.DATA_airTime, (int) (1 + (entity instanceof AmongMissileUpEntity _datEntI ? _datEntI.getEntityData().get(AmongMissileUpEntity.DATA_airTime) : 0)));
		if (!world.getEntitiesOfClass(Player.class,
				AABB.ofSize(new Vec3((entity instanceof AmongMissileUpEntity _datEntI ? _datEntI.getEntityData().get(AmongMissileUpEntity.DATA_targeterX) : 0),
						(entity instanceof AmongMissileUpEntity _datEntI ? _datEntI.getEntityData().get(AmongMissileUpEntity.DATA_targeterY) : 0),
						(entity instanceof AmongMissileUpEntity _datEntI ? _datEntI.getEntityData().get(AmongMissileUpEntity.DATA_targeterZ) : 0)), 6, 6, 6),
				e -> true).isEmpty()) {
			target = (Entity) world.getEntitiesOfClass(Player.class,
					AABB.ofSize(new Vec3((entity instanceof AmongMissileUpEntity _datEntI ? _datEntI.getEntityData().get(AmongMissileUpEntity.DATA_targeterX) : 0),
							(entity instanceof AmongMissileUpEntity _datEntI ? _datEntI.getEntityData().get(AmongMissileUpEntity.DATA_targeterY) : 0),
							(entity instanceof AmongMissileUpEntity _datEntI ? _datEntI.getEntityData().get(AmongMissileUpEntity.DATA_targeterZ) : 0)), 6, 6, 6),
					e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((entity instanceof AmongMissileUpEntity _datEntI ? _datEntI.getEntityData().get(AmongMissileUpEntity.DATA_targeterX) : 0),
							(entity instanceof AmongMissileUpEntity _datEntI ? _datEntI.getEntityData().get(AmongMissileUpEntity.DATA_targeterY) : 0),
							(entity instanceof AmongMissileUpEntity _datEntI ? _datEntI.getEntityData().get(AmongMissileUpEntity.DATA_targeterZ) : 0)))
					.findFirst().orElse(null);
			if (entity instanceof AmongMissileUpEntity _datEntSetI)
				_datEntSetI.getEntityData().set(AmongMissileUpEntity.DATA_targeterX, (int) target.getX());
			if (entity instanceof AmongMissileUpEntity _datEntSetI)
				_datEntSetI.getEntityData().set(AmongMissileUpEntity.DATA_targeterY, (int) target.getY());
			if (entity instanceof AmongMissileUpEntity _datEntSetI)
				_datEntSetI.getEntityData().set(AmongMissileUpEntity.DATA_targeterZ, (int) target.getZ());
		}
	}
}
