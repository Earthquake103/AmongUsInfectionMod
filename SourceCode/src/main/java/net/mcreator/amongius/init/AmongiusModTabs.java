
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.amongius.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.amongius.AmongiusMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AmongiusModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AmongiusMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(AmongiusModBlocks.H_TEST.get().asItem());
			tabData.accept(AmongiusModBlocks.AMONGIUS_ORE.get().asItem());
			tabData.accept(AmongiusModBlocks.AMONGIUS_BLOCK.get().asItem());
			tabData.accept(AmongiusModBlocks.AMONG_WOOD_PLANK.get().asItem());
			tabData.accept(AmongiusModBlocks.AMONGWOODSTAIRS.get().asItem());
			tabData.accept(AmongiusModBlocks.AMONGWOOD_SLAB.get().asItem());
			tabData.accept(AmongiusModBlocks.AMONGFENCE.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			tabData.accept(AmongiusModBlocks.AMONG_CRAFTING.get().asItem());
			tabData.accept(AmongiusModBlocks.AMONGIUS_STORAGE_CONTAINER.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(AmongiusModItems.FACE_MASK_HELMET.get());
			tabData.accept(AmongiusModItems.AMONG_LAUNCHER.get());
			tabData.accept(AmongiusModItems.AMONG_SWORD.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(AmongiusModItems.AMONGLE_SPAWN_EGG.get());
			tabData.accept(AmongiusModItems.AMONG_CAR_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(AmongiusModItems.AMONGIUS_INGOT.get());
			tabData.accept(AmongiusModItems.RAW_AMONGIUS.get());
			tabData.accept(AmongiusModItems.AMONG_NUGGET.get());
			tabData.accept(AmongiusModItems.AMONGIUS_SHAFT.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(AmongiusModBlocks.AMONG_LEAVE.get().asItem());
			tabData.accept(AmongiusModBlocks.BLUE_AMONG_LEAVE.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(AmongiusModItems.AMONG_APPLE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(AmongiusModItems.AMONG_DISC.get());
			tabData.accept(AmongiusModItems.AMONG_MISSILE_SUMMONER.get());
			tabData.accept(AmongiusModItems.AMONG_PICKAXE.get());
		}
	}
}
