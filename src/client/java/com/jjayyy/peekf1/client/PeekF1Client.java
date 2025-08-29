package com.jjayyy.peekf1.client;

import com.jjayyy.peekf1.client.config.PeekF1Config;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.util.InputUtil;

public class PeekF1Client implements ClientModInitializer {
    public static KeyBinding showHudKeyBinding;

    @Override
    public void onInitializeClient() {
        // 設定ファイルを読み込み
        PeekF1Config.load();

        showHudKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.peekf1.show_hud",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_LEFT_ALT,
                "category.peekf1"
        ));

        // ブロックアウトラインハンドラーを登録
        BlockOutlineHandler.register();
    }
}