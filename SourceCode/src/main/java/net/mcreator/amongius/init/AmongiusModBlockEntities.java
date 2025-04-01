
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.amongius.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.amongius.block.entity.AmongiusStorageContainerBlockEntity;
import net.mcreator.amongius.block.entity.AmongCraftingBlockEntity;
import net.mcreator.amongius.AmongiusMod;

public class AmongiusModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AmongiusMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> AMONG_CRAFTING = register("among_crafting", AmongiusModBlocks.AMONG_CRAFTING, AmongCraftingBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> AMONGIUS_STORAGE_CONTAINER = register("amongius_storage_container", AmongiusModBlocks.AMONGIUS_STORAGE_CONTAINER, AmongiusStorageContainerBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
