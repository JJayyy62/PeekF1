package com.jjayyy.peekf1.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.util.InputUtil;

public class PeekF1Client implements ClientModInitializer {
    public static KeyBinding showHudKeyBinding;

    @Override
    public void onInitializeClient() {
        showHudKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.peekf1.show_hud",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_LEFT_ALT,
                "category.peekf1"
        ));
    }
} 