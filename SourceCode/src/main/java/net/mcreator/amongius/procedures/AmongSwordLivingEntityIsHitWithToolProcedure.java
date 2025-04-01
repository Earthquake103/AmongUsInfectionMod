package net.mcreator.amongius.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.amongius.AmongiusMod;

import java.util.ArrayList;

public class AmongSwordLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean isPlayer = false;
		isPlayer = false;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("amongius:amogusidle")), SoundSource.BLOCKS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("amongius:amogusidle")), SoundSource.BLOCKS, 1, 1, false);
			}
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 60, 10));
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if ((entity.getDisplayName().getString()).equals(entityiterator.getDisplayName().getString())) {
				isPlayer = true;
				if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
					AmongiusMod.queueServerWork(60, () -> {
						if (world instanceof Level _level && !_level.isClientSide())
							_level.explode(null, (entity.getX()), (entity.getY()), (entity.getZ()), 4, Level.ExplosionInteraction.NONE);
					});
				}
			}
		}
		if (!isPlayer) {
			AmongiusMod.queueServerWork(60, () -> {
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, (entity.getX()), (entity.getY()), (entity.getZ()), 4, Level.ExplosionInteraction.NONE);
			});
		}
	}
}
