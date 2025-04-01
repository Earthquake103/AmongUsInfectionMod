// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modeltherealface_Converted<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "therealface_converted"), "main");
	private final ModelPart allofit;

	public Modeltherealface_Converted(ModelPart root) {
		this.allofit = root.getChild("allofit");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition allofit = partdefinition.addOrReplaceChild("allofit",
				CubeListBuilder.create().texOffs(19, 30)
						.addBox(-4.0F, -9.0F, -5.0F, 8.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 21)
						.addBox(4.0F, -5.0F, -4.0F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 12)
						.addBox(-4.0F, -5.0F, 4.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(25, 0)
						.addBox(-5.0F, -5.0F, -4.0F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(8.0F, 24.0F, -8.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		allofit.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}