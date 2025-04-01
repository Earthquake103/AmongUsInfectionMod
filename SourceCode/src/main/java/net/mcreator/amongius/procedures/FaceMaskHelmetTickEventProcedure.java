package net.mcreator.amongius.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.amongius.network.AmongiusModVariables;
import net.mcreator.amongius.AmongiusMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FaceMaskHelmetTickEventProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(AmongiusModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AmongiusModVariables.PlayerVariables())).hasWornHenryMask && Mth.nextInt(RandomSource.create(), 1, 300000) == 1) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"title @a title {\"text\":\"Uh Oh\",\"bold\":true,\"color\":\"dark_red\"}");
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("amongius:alarm")), SoundSource.NEUTRAL, (float) 0.3, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("amongius:alarm")), SoundSource.NEUTRAL, (float) 0.3, 1, false);
				}
			}
			AmongiusMod.queueServerWork(50, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"title @p title {\"text\":\"Self-Destruction\",\"bold\":true,\"color\":\"dark_red\"}");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"title @p subtitle {\"text\":\"Imminent\",\"bold\":true,\"color\":\"dark_red\"}");
				AmongiusMod.queueServerWork(100, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"title @a title {\"text\":\"5\",\"bold\":true,\"color\":\"dark_red\"}");
					AmongiusMod.queueServerWork(30, () -> {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"title @a title {\"text\":\"4\",\"bold\":true,\"color\":\"dark_red\"}");
						AmongiusMod.queueServerWork(30, () -> {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"title @a title {\"text\":\"3\",\"bold\":true,\"color\":\"dark_red\"}");
							AmongiusMod.queueServerWork(30, () -> {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"title @a title {\"text\":\"2\",\"bold\":true,\"color\":\"dark_red\"}");
								AmongiusMod.queueServerWork(30, () -> {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"title @a title {\"text\":\"1\",\"bold\":true,\"color\":\"dark_red\"}");
									AmongiusMod.queueServerWork(50, () -> {
										{
											boolean _setval = false;
											entity.getCapability(AmongiusModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.hasWornHenryMask = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											Entity _entity = entity;
											if (_entity instanceof Player _player) {
												_player.getInventory().armor.set(3, ItemStack.EMPTY);
												_player.getInventory().setChanged();
											} else if (_entity instanceof LivingEntity _living) {
												_living.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
											}
										}
										if (world instanceof Level _level && !_level.isClientSide())
											_level.explode(null, (entity.getX()), (entity.getY()), (entity.getZ()), 15, Level.ExplosionInteraction.NONE);
									});
								});
							});
						});
					});
				});
			});
		}
	}
}
