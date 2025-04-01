
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.amongius.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.amongius.client.model.Modeltherealface_Converted;
import net.mcreator.amongius.client.model.ModelmissileUp;
import net.mcreator.amongius.client.model.ModelmissileMiddle;
import net.mcreator.amongius.client.model.Modelamongle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class AmongiusModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelmissileMiddle.LAYER_LOCATION, ModelmissileMiddle::createBodyLayer);
		event.registerLayerDefinition(Modeltherealface_Converted.LAYER_LOCATION, Modeltherealface_Converted::createBodyLayer);
		event.registerLayerDefinition(Modelamongle.LAYER_LOCATION, Modelamongle::createBodyLayer);
		event.registerLayerDefinition(ModelmissileUp.LAYER_LOCATION, ModelmissileUp::createBodyLayer);
	}
}
