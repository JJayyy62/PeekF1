package com.jjayyy.peekf1.client.compat;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.jjayyy.peekf1.client.config.PeekF1ConfigScreen;

// ModMenuが利用可能な場合のみ使用される
public class ModMenuIntegration implements com.terraformersmc.modmenu.api.ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return PeekF1ConfigScreen::new;
    }
}