
package net.mcreator.amongius.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.amongius.entity.AmongMissileDownEntity;
import net.mcreator.amongius.client.model.ModelmissileMiddle;

public class AmongMissileDownRenderer extends MobRenderer<AmongMissileDownEntity, ModelmissileMiddle<AmongMissileDownEntity>> {
	public AmongMissileDownRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelmissileMiddle(context.bakeLayer(ModelmissileMiddle.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AmongMissileDownEntity entity) {
		return new ResourceLocation("amongius:textures/entities/missileuptexture.png");
	}
}
