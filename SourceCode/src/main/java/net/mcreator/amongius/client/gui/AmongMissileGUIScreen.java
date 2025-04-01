package net.mcreator.amongius.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.amongius.world.inventory.AmongMissileGUIMenu;
import net.mcreator.amongius.network.AmongMissileGUIButtonMessage;
import net.mcreator.amongius.AmongiusMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AmongMissileGUIScreen extends AbstractContainerScreen<AmongMissileGUIMenu> {
	private final static HashMap<String, Object> guistate = AmongMissileGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	public static EditBox nameEnter;
	Button button_confirm_name;

	public AmongMissileGUIScreen(AmongMissileGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 174;
		this.imageHeight = 90;
	}

	private static final ResourceLocation texture = new ResourceLocation("amongius:textures/screens/among_missile_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		nameEnter.render(guiGraphics, mouseX, mouseY, partialTicks);
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

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (nameEnter.isFocused())
			return nameEnter.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		nameEnter.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String nameEnterValue = nameEnter.getValue();
		super.resize(minecraft, width, height);
		nameEnter.setValue(nameEnterValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.amongius.among_missile_gui.label_enter_victim_name_here"), 30, 15, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		nameEnter = new EditBox(this.font, this.leftPos + 28, this.topPos + 33, 118, 18, Component.translatable("gui.amongius.among_missile_gui.nameEnter")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.amongius.among_missile_gui.nameEnter").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.amongius.among_missile_gui.nameEnter").getString());
				else
					setSuggestion(null);
			}
		};
		nameEnter.setSuggestion(Component.translatable("gui.amongius.among_missile_gui.nameEnter").getString());
		nameEnter.setMaxLength(32767);
		guistate.put("text:nameEnter", nameEnter);
		this.addWidget(this.nameEnter);
		button_confirm_name = Button.builder(Component.translatable("gui.amongius.among_missile_gui.button_confirm_name"), e -> {
			if (true) {
				textstate.put("textin:nameEnter", nameEnter.getValue());
				AmongiusMod.PACKET_HANDLER.sendToServer(new AmongMissileGUIButtonMessage(0, x, y, z, textstate));
				AmongMissileGUIButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		}).bounds(this.leftPos + 44, this.topPos + 58, 87, 20).build();
		guistate.put("button:button_confirm_name", button_confirm_name);
		this.addRenderableWidget(button_confirm_name);
	}
}
