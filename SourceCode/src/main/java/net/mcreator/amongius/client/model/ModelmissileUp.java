package net.mcreator.amongius.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelmissileUp<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("amongius", "modelmissile_up"), "main");
	public final ModelPart thewholething;

	public ModelmissileUp(ModelPart root) {
		this.thewholething = root.getChild("thewholething");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition thewholething = partdefinition
				.addOrReplaceChild(
						"thewholething", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -24.8889F, -3.0F, 6.0F, 32.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(32, 30).addBox(-5.0F, -3.8889F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
								.texOffs(32, 20).addBox(-7.0F, -1.8889F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 38).addBox(-2.0F, -25.8889F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 16.8889F, 0.0F));
		PartDefinition cube_r1 = thewholething.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(24, 10).addBox(-2.0F, -3.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(24, 0).addBox(0.0F, -5.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.1111F, 5.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition cube_r2 = thewholething.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(32, 10).addBox(0.0F, -5.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(32, 0).addBox(-2.0F, -3.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.1111F, -5.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition cube_r3 = thewholething.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(24, 30).addBox(-2.0F, -3.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(24, 20).addBox(0.0F, -5.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, 1.1111F, 0.0F, 0.0F, 3.1416F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		thewholething.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.thewholething.yRot = ageInTicks / 20.f;
	}
}
