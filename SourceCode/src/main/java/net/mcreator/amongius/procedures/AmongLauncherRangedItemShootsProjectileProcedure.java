package net.mcreator.amongius.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.amongius.network.AmongiusModVariables;

public class AmongLauncherRangedItemShootsProjectileProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean damage = false;
		{
			double _setval = 15;
			entity.getCapability(AmongiusModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.iFrames = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
