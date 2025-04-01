
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.amongius.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.amongius.client.renderer.AmongleRenderer;
import net.mcreator.amongius.client.renderer.AmongProjectileRenderer;
import net.mcreator.amongius.client.renderer.AmongMissileUpRenderer;
import net.mcreator.amongius.client.renderer.AmongMissileDownRenderer;
import net.mcreator.amongius.client.renderer.AmongCarRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AmongiusModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(AmongiusModEntities.AMONGLE.get(), AmongleRenderer::new);
		event.registerEntityRenderer(AmongiusModEntities.AMONG_PROJECTILE.get(), AmongProjectileRenderer::new);
		event.registerEntityRenderer(AmongiusModEntities.AMONG_MISSILE_UP.get(), AmongMissileUpRenderer::new);
		event.registerEntityRenderer(AmongiusModEntities.AMONG_MISSILE_DOWN.get(), AmongMissileDownRenderer::new);
		event.registerEntityRenderer(AmongiusModEntities.AMONG_CAR.get(), AmongCarRenderer::new);
	}
}
