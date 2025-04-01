
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.amongius.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.amongius.AmongiusMod;

public class AmongiusModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AmongiusMod.MODID);
	public static final RegistryObject<SoundEvent> AMOGUSIDLE = REGISTRY.register("amogusidle", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("amongius", "amogusidle")));
	public static final RegistryObject<SoundEvent> AMONGDEATH = REGISTRY.register("amongdeath", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("amongius", "amongdeath")));
	public static final RegistryObject<SoundEvent> AMONGSTEP = REGISTRY.register("amongstep", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("amongius", "amongstep")));
	public static final RegistryObject<SoundEvent> ALARM = REGISTRY.register("alarm", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("amongius", "alarm")));
	public static final RegistryObject<SoundEvent> AMONGTRAP = REGISTRY.register("amongtrap", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("amongius", "amongtrap")));
}
