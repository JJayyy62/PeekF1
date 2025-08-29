package com.jjayyy.peekf1.client.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PeekF1Config {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("peekf1.json");

    private static PeekF1Config INSTANCE = new PeekF1Config();

    // 設定項目
    public boolean hideBlockOutlineInNoHud = true; // デフォルトで非表示

    public static PeekF1Config getInstance() {
        return INSTANCE;
    }

    public static void load() {
        if (Files.exists(CONFIG_PATH)) {
            try {
                String json = Files.readString(CONFIG_PATH);
                INSTANCE = GSON.fromJson(json, PeekF1Config.class);
                if (INSTANCE == null) {
                    INSTANCE = new PeekF1Config();
                }
            } catch (IOException e) {
                System.err.println("PeekF1: Failed to load config: " + e.getMessage());
                INSTANCE = new PeekF1Config();
            }
        }
    }

    public static void save() {
        try {
            Files.createDirectories(CONFIG_PATH.getParent());
            String json = GSON.toJson(INSTANCE);
            Files.writeString(CONFIG_PATH, json);
        } catch (IOException e) {
            System.err.println("PeekF1: Failed to save config: " + e.getMessage());
        }
    }

    public boolean shouldHideBlockOutlineInNoHud() {
        return hideBlockOutlineInNoHud;
    }

    public void setHideBlockOutlineInNoHud(boolean hide) {
        this.hideBlockOutlineInNoHud = hide;
        save();
    }
}