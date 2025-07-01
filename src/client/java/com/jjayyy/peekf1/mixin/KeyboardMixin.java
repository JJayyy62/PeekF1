package com.jjayyy.peekf1.mixin;

import com.jjayyy.peekf1.client.PeekF1;
import com.jjayyy.peekf1.client.HUDState;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class KeyboardMixin {
    @Shadow
    @Final
    private MinecraftClient client;

    @Inject(method = "onKey", at = @At(value = "FIELD",
            target = "Lnet/minecraft/client/option/GameOptions;hudHidden:Z"), cancellable = true)
    public void onF1Key(CallbackInfo ci) {
        // 一時表示キーが押されている間は状態遷移しない
        if (PeekF1.isTemporaryShowHud()) {
            return;
        }
        PeekF1.state = PeekF1.state.next();

        // Seems most safe
        client.options.hudHidden = !PeekF1.state.equals(HUDState.ALL_VISIBLE);
        ci.cancel();
    }
}