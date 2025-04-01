package net.mcreator.amongius.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.amongius.AmongiusMod;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Comparator;

public class AmongiusStorageProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double slotNum = 0;
		slotNum = 0;
		for (int index0 = 0; index0 < 43; index0++) {
			if (new Object() {
				public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
					return _retval.get();
				}
			}.getAmount(world, BlockPos.containing(x, y, z), (int) slotNum) >= 64) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("amongius:amongstep")), SoundSource.BLOCKS, 1, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("amongius:amongstep")), SoundSource.BLOCKS, 1, (float) 0.8, false);
					}
				}
				AmongiusMod.queueServerWork(10, () -> {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null))
							.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("amongius:among_us")))), 50);
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null, x, y, z, 6, Level.ExplosionInteraction.TNT);
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null, x, y, z, 12, Level.ExplosionInteraction.TNT);
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null, x, (y - 5), z, 12, Level.ExplosionInteraction.TNT);
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				});
			}
			slotNum = 1 + slotNum;
		}
	}
}
