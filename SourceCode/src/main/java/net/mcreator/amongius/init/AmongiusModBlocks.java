
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.amongius.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.amongius.block.HTestBlock;
import net.mcreator.amongius.block.BlueAmongLeaveBlock;
import net.mcreator.amongius.block.AmongwoodstairsBlock;
import net.mcreator.amongius.block.AmongwoodSlabBlock;
import net.mcreator.amongius.block.AmongiusStorageContainerBlock;
import net.mcreator.amongius.block.AmongiusOreBlock;
import net.mcreator.amongius.block.AmongiusBlockBlock;
import net.mcreator.amongius.block.AmongfenceBlock;
import net.mcreator.amongius.block.AmongWoodPlankBlock;
import net.mcreator.amongius.block.AmongLeaveBlock;
import net.mcreator.amongius.block.AmongCraftingBlock;
import net.mcreator.amongius.AmongiusMod;

public class AmongiusModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, AmongiusMod.MODID);
	public static final RegistryObject<Block> H_TEST = REGISTRY.register("h_test", () -> new HTestBlock());
	public static final RegistryObject<Block> AMONG_LEAVE = REGISTRY.register("among_leave", () -> new AmongLeaveBlock());
	public static final RegistryObject<Block> BLUE_AMONG_LEAVE = REGISTRY.register("blue_among_leave", () -> new BlueAmongLeaveBlock());
	public static final RegistryObject<Block> AMONGIUS_ORE = REGISTRY.register("amongius_ore", () -> new AmongiusOreBlock());
	public static final RegistryObject<Block> AMONGIUS_BLOCK = REGISTRY.register("amongius_block", () -> new AmongiusBlockBlock());
	public static final RegistryObject<Block> AMONG_CRAFTING = REGISTRY.register("among_crafting", () -> new AmongCraftingBlock());
	public static final RegistryObject<Block> AMONG_WOOD_PLANK = REGISTRY.register("among_wood_plank", () -> new AmongWoodPlankBlock());
	public static final RegistryObject<Block> AMONGIUS_STORAGE_CONTAINER = REGISTRY.register("amongius_storage_container", () -> new AmongiusStorageContainerBlock());
	public static final RegistryObject<Block> AMONGWOODSTAIRS = REGISTRY.register("amongwoodstairs", () -> new AmongwoodstairsBlock());
	public static final RegistryObject<Block> AMONGWOOD_SLAB = REGISTRY.register("amongwood_slab", () -> new AmongwoodSlabBlock());
	public static final RegistryObject<Block> AMONGFENCE = REGISTRY.register("amongfence", () -> new AmongfenceBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
