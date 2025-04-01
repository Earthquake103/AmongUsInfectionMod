
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.amongius.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.amongius.world.inventory.AmongStorageGUIMenu;
import net.mcreator.amongius.world.inventory.AmongMissileGUIMenu;
import net.mcreator.amongius.world.inventory.AmongCraftingGUIMenu;
import net.mcreator.amongius.AmongiusMod;

public class AmongiusModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, AmongiusMod.MODID);
	public static final RegistryObject<MenuType<AmongCraftingGUIMenu>> AMONG_CRAFTING_GUI = REGISTRY.register("among_crafting_gui", () -> IForgeMenuType.create(AmongCraftingGUIMenu::new));
	public static final RegistryObject<MenuType<AmongStorageGUIMenu>> AMONG_STORAGE_GUI = REGISTRY.register("among_storage_gui", () -> IForgeMenuType.create(AmongStorageGUIMenu::new));
	public static final RegistryObject<MenuType<AmongMissileGUIMenu>> AMONG_MISSILE_GUI = REGISTRY.register("among_missile_gui", () -> IForgeMenuType.create(AmongMissileGUIMenu::new));
}
