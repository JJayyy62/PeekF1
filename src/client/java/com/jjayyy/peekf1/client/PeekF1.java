package com.jjayyy.peekf1.client;

public class PeekF1 {
    public static HUDState state = HUDState.ALL_VISIBLE;

    public static boolean isTemporaryShowHud() {
        return com.jjayyy.peekf1.client.PeekF1Client.showHudKeyBinding != null &&
               com.jjayyy.peekf1.client.PeekF1Client.showHudKeyBinding.isPressed();
    }
}
