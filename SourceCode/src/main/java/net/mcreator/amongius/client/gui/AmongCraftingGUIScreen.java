package net.mcreator.amongius.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.amongius.world.inventory.AmongCraftingGUIMenu;
import net.mcreator.amongius.network.AmongCraftingGUIButtonMessage;
import net.mcreator.amongius.AmongiusMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AmongCraftingGUIScreen extends AbstractContainerScreen<AmongCraftingGUIMenu> {
	private final static HashMap<String, Object> guistate = AmongCraftingGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	Button button_forge;

	public AmongCraftingGUIScreen(AmongCraftingGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 176;
	}

	private static final ResourceLocation texture = new ResourceLocation("amongius:textures/screens/among_crafting_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	public static HashMap<String, String> getTextboxValues() {
		return textstate;
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		AmongiusMod.PACKET_HANDLER.sendToServer(new AmongCraftingGUIMenu.AmongCraftingGUIOtherMessage(0, x, y, z, textstate));
		AmongCraftingGUIMenu.AmongCraftingGUIOtherMessage.handleOtherAction(entity, 0, x, y, z, textstate);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.amongius.among_crafting_gui.label_among_us_crafting"), 15, 12, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.amongius.among_crafting_gui.label_result"), 114, 21, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_forge = Button.builder(Component.translatable("gui.amongius.among_crafting_gui.button_forge"), e -> {
			if (true) {
				AmongiusMod.PACKET_HANDLER.sendToServer(new AmongCraftingGUIButtonMessage(0, x, y, z, textstate));
				AmongCraftingGUIButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		}).bounds(this.leftPos + 105, this.topPos + 66, 51, 20).build();
		guistate.put("button:button_forge", button_forge);
		this.addRenderableWidget(button_forge);
	}
}
