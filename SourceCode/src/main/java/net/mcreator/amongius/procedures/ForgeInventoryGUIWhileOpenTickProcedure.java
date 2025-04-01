package net.mcreator.amongius.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class ForgeInventoryGUIWhileOpenTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			((Slot) _slots.get(9)).remove(new Object() {
				public int getAmount(int sltid) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
						if (stack != null)
							return stack.getCount();
					}
					return 0;
				}
			}.getAmount(9));
			_player.containerMenu.broadcastChanges();
		}
		AmongAppleRecipeProcedure.execute(entity);
		AmongiusBlockRecipeProcedure.execute(entity);
		AmongiusBlockConversionRecipeProcedure.execute(entity);
		AmogiusIngotRecipeProcedure.execute(entity);
		AmogiusIngotConversionRecipeProcedure.execute(entity);
		AmongiusStorageRecipeProcedure.execute(entity);
		AmongusRodRecipeProcedure.execute(entity);
		AmongiusShaftRecipeProcedure.execute(entity);
		AmongiusRocketRecipeProcedure.execute(entity);
		AmongDiscRecipeProcedure.execute(entity);
		AmongSwordRecipeProcedure.execute(entity);
		AmongPickRecipeProcedure.execute(entity);
		AmongEggRecipeProcedure.execute(entity);
	}
}
