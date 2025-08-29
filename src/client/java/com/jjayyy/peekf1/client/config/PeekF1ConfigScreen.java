package com.jjayyy.peekf1.client.config;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.GridWidget;
import net.minecraft.client.gui.widget.SimplePositioningWidget;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;

public class PeekF1ConfigScreen extends Screen {
    private final Screen parent;
    private final PeekF1Config config;

    public PeekF1ConfigScreen(Screen parent) {
        super(Text.translatable("peekf1.config.title"));
        this.parent = parent;
        this.config = PeekF1Config.getInstance();
    }

    @Override
    protected void init() {
        GridWidget gridWidget = new GridWidget();
        gridWidget.getMainPositioner().marginX(5).marginBottom(4).alignHorizontalCenter();
        GridWidget.Adder adder = gridWidget.createAdder(2);

        // ブロックアウトライン設定
        adder.add(ButtonWidget.builder(getBlockOutlineToggleText(), (button) -> {
            config.setHideBlockOutlineInNoHud(!config.shouldHideBlockOutlineInNoHud());
            button.setMessage(getBlockOutlineToggleText());
        }).width(200).build(), 2);

        adder.add(ButtonWidget.builder(ScreenTexts.DONE, (button) -> {
            this.client.setScreen(this.parent);
        }).width(200).build(), 2);

        gridWidget.refreshPositions();
        SimplePositioningWidget.setPos(gridWidget, 0, this.height / 6 - 12, this.width, this.height, 0.5f, 0.0f);
        gridWidget.forEachChild(this::addDrawableChild);
    }

    private Text getBlockOutlineToggleText() {
        return Text.translatable("peekf1.config.hideBlockOutline",
                config.shouldHideBlockOutlineInNoHud() ?
                        Text.translatable("peekf1.config.enabled") :
                        Text.translatable("peekf1.config.disabled"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 15, 0xFFFFFF);
    }

    @Override
    public void close() {
        this.client.setScreen(this.parent);
    }
}