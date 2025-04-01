
package net.mcreator.amongius.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.amongius.entity.AmongMissileUpEntity;
import net.mcreator.amongius.client.model.ModelmissileUp;

public class AmongMissileUpRenderer extends MobRenderer<AmongMissileUpEntity, ModelmissileUp<AmongMissileUpEntity>> {
	public AmongMissileUpRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelmissileUp(context.bakeLayer(ModelmissileUp.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AmongMissileUpEntity entity) {
		return new ResourceLocation("amongius:textures/entities/missileuptexture.png");
	}
}
