
package net.mcreator.amongius.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AmongiusIngotItem extends Item {
	public AmongiusIngotItem() {
		super(new Item.Properties().stacksTo(63).rarity(Rarity.COMMON));
	}
}
