package net.mcreator.amongius.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.amongius.network.AmongiusModVariables;

import java.util.HashMap;
import java.util.ArrayList;

public class MissileGUIButtonClickProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		{
			String _setval = "";
			entity.getCapability(AmongiusModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.playerMissileTarget = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = guistate.containsKey("textin:nameEnter") ? (String) guistate.get("textin:nameEnter") : "";
			entity.getCapability(AmongiusModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.targetName = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if ((entityiterator.getDisplayName().getString()).equals((entity.getCapability(AmongiusModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AmongiusModVariables.PlayerVariables())).targetName)) {
				{
					String _setval = (entity.getCapability(AmongiusModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AmongiusModVariables.PlayerVariables())).targetName;
					entity.getCapability(AmongiusModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.playerMissileTarget = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("Target: " + ((entity.getCapability(AmongiusModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AmongiusModVariables.PlayerVariables())).playerMissileTarget + " Confirmed"))),
							true);
			}
		}
		if (((entity.getCapability(AmongiusModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AmongiusModVariables.PlayerVariables())).playerMissileTarget).equals("")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Cannot Find Target"), true);
		}
	}
}
