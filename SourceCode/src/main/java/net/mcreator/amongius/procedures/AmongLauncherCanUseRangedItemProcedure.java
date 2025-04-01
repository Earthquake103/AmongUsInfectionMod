package net.mcreator.amongius.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.amongius.init.AmongiusModItems;

public class AmongLauncherCanUseRangedItemProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(AmongiusModItems.AMONG_NUGGET.get())) : false) {
			return true;
		}
		return false;
	}
}
