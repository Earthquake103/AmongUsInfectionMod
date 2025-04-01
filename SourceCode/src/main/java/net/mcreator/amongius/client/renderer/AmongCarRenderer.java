
package net.mcreator.amongius.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.amongius.entity.AmongCarEntity;
import net.mcreator.amongius.client.model.Modelamongle;

public class AmongCarRenderer extends MobRenderer<AmongCarEntity, Modelamongle<AmongCarEntity>> {
	public AmongCarRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelamongle(context.bakeLayer(Modelamongle.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AmongCarEntity entity) {
		return new ResourceLocation("amongius:textures/entities/amoigle.png");
	}
}
