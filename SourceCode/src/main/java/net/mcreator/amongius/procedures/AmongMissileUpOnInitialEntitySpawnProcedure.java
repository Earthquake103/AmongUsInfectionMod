package net.mcreator.amongius.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.amongius.network.AmongiusModVariables;
import net.mcreator.amongius.entity.AmongMissileUpEntity;

import java.util.Comparator;
import java.util.ArrayList;

public class AmongMissileUpOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity target = null;
		Entity launcher = null;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("amongius:amongdeath")), SoundSource.BLOCKS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("amongius:amongdeath")), SoundSource.BLOCKS, 1, 1, false);
			}
		}
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if ((entityiterator.getDisplayName().getString()).equals((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getCapability(AmongiusModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AmongiusModVariables.PlayerVariables())).playerMissileTarget)) {
				target = entityiterator;
			}
		}
		if (entity instanceof AmongMissileUpEntity _datEntSetI)
			_datEntSetI.getEntityData().set(AmongMissileUpEntity.DATA_targeterX, (int) target.getX());
		if (entity instanceof AmongMissileUpEntity _datEntSetI)
			_datEntSetI.getEntityData().set(AmongMissileUpEntity.DATA_targeterY, (int) target.getY());
		if (entity instanceof AmongMissileUpEntity _datEntSetI)
			_datEntSetI.getEntityData().set(AmongMissileUpEntity.DATA_targeterZ, (int) target.getZ());
		if (entity instanceof AmongMissileUpEntity _datEntSetI)
			_datEntSetI.getEntityData().set(AmongMissileUpEntity.DATA_airTime, 0);
	}
}
