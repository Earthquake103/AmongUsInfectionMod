
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.amongius.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.amongius.item.RawAmongiusItem;
import net.mcreator.amongius.item.FaceMaskItem;
import net.mcreator.amongius.item.AmongiusShaftItem;
import net.mcreator.amongius.item.AmongiusIngotItem;
import net.mcreator.amongius.item.AmongSwordItem;
import net.mcreator.amongius.item.AmongPickaxeItem;
import net.mcreator.amongius.item.AmongNuggetItem;
import net.mcreator.amongius.item.AmongMissileSummonerItem;
import net.mcreator.amongius.item.AmongLauncherItem;
import net.mcreator.amongius.item.AmongDiscItem;
import net.mcreator.amongius.item.AmongAppleItem;
import net.mcreator.amongius.AmongiusMod;

public class AmongiusModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, AmongiusMod.MODID);
	public static final RegistryObject<Item> H_TEST = block(AmongiusModBlocks.H_TEST);
	public static final RegistryObject<Item> AMONG_LEAVE = block(AmongiusModBlocks.AMONG_LEAVE);
	public static final RegistryObject<Item> BLUE_AMONG_LEAVE = block(AmongiusModBlocks.BLUE_AMONG_LEAVE);
	public static final RegistryObject<Item> AMONG_APPLE = REGISTRY.register("among_apple", () -> new AmongAppleItem());
	public static final RegistryObject<Item> AMONGLE_SPAWN_EGG = REGISTRY.register("amongle_spawn_egg", () -> new ForgeSpawnEggItem(AmongiusModEntities.AMONGLE, -3407872, -10027009, new Item.Properties()));
	public static final RegistryObject<Item> AMONGIUS_INGOT = REGISTRY.register("amongius_ingot", () -> new AmongiusIngotItem());
	public static final RegistryObject<Item> AMONGIUS_ORE = block(AmongiusModBlocks.AMONGIUS_ORE);
	public static final RegistryObject<Item> AMONGIUS_BLOCK = block(AmongiusModBlocks.AMONGIUS_BLOCK);
	public static final RegistryObject<Item> RAW_AMONGIUS = REGISTRY.register("raw_amongius", () -> new RawAmongiusItem());
	public static final RegistryObject<Item> AMONG_NUGGET = REGISTRY.register("among_nugget", () -> new AmongNuggetItem());
	public static final RegistryObject<Item> AMONG_CRAFTING = block(AmongiusModBlocks.AMONG_CRAFTING);
	public static final RegistryObject<Item> AMONG_WOOD_PLANK = block(AmongiusModBlocks.AMONG_WOOD_PLANK);
	public static final RegistryObject<Item> AMONGIUS_STORAGE_CONTAINER = block(AmongiusModBlocks.AMONGIUS_STORAGE_CONTAINER);
	public static final RegistryObject<Item> FACE_MASK_HELMET = REGISTRY.register("face_mask_helmet", () -> new FaceMaskItem.Helmet());
	public static final RegistryObject<Item> AMONG_LAUNCHER = REGISTRY.register("among_launcher", () -> new AmongLauncherItem());
	public static final RegistryObject<Item> AMONGIUS_SHAFT = REGISTRY.register("amongius_shaft", () -> new AmongiusShaftItem());
	public static final RegistryObject<Item> AMONG_DISC = REGISTRY.register("among_disc", () -> new AmongDiscItem());
	public static final RegistryObject<Item> AMONG_MISSILE_SUMMONER = REGISTRY.register("among_missile_summoner", () -> new AmongMissileSummonerItem());
	public static final RegistryObject<Item> AMONG_SWORD = REGISTRY.register("among_sword", () -> new AmongSwordItem());
	public static final RegistryObject<Item> AMONGWOODSTAIRS = block(AmongiusModBlocks.AMONGWOODSTAIRS);
	public static final RegistryObject<Item> AMONGWOOD_SLAB = block(AmongiusModBlocks.AMONGWOOD_SLAB);
	public static final RegistryObject<Item> AMONG_PICKAXE = REGISTRY.register("among_pickaxe", () -> new AmongPickaxeItem());
	public static final RegistryObject<Item> AMONGFENCE = block(AmongiusModBlocks.AMONGFENCE);
	public static final RegistryObject<Item> AMONG_CAR_SPAWN_EGG = REGISTRY.register("among_car_spawn_egg", () -> new ForgeSpawnEggItem(AmongiusModEntities.AMONG_CAR, -1, -1, new Item.Properties()));

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
