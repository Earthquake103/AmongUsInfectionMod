package net.mcreator.amongius.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.amongius.network.AmongiusModVariables;
import net.mcreator.amongius.init.AmongiusModEntities;

import java.util.ArrayList;

public class AmongMissileSummonerRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double airCheckIterator = 0;
		boolean airCheckGood = false;
		boolean playerCheckGood = false;
		airCheckGood = true;
		airCheckIterator = y;
		for (int index0 = 0; index0 < (int) (320 - y); index0++) {
			airCheckIterator = 1 + airCheckIterator;
			if (!world.isEmptyBlock(BlockPos.containing(x, airCheckIterator, z))) {
				airCheckGood = false;
			}
		}
		playerCheckGood = false;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if ((entityiterator.getDisplayName().getString()).equals((entity.getCapability(AmongiusModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AmongiusModVariables.PlayerVariables())).playerMissileTarget)) {
				playerCheckGood = true;
			}
		}
		if (airCheckGood) {
			if (playerCheckGood) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = AmongiusModEntities.AMONG_MISSILE_UP.get().spawn(_level, BlockPos.containing(x, 1 + y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				itemstack.setCount(0);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Cannot find target"), true);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Missile cannot be placed there"), true);
		}
	}
}
