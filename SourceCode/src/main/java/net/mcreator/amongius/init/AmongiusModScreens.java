
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.amongius.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.amongius.client.gui.AmongStorageGUIScreen;
import net.mcreator.amongius.client.gui.AmongMissileGUIScreen;
import net.mcreator.amongius.client.gui.AmongCraftingGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AmongiusModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(AmongiusModMenus.AMONG_CRAFTING_GUI.get(), AmongCraftingGUIScreen::new);
			MenuScreens.register(AmongiusModMenus.AMONG_STORAGE_GUI.get(), AmongStorageGUIScreen::new);
			MenuScreens.register(AmongiusModMenus.AMONG_MISSILE_GUI.get(), AmongMissileGUIScreen::new);
		});
	}
}
