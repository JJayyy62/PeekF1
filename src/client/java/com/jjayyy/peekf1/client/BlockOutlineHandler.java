package com.jjayyy.peekf1.client;

import com.jjayyy.peekf1.client.config.PeekF1Config;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;

public class BlockOutlineHandler {

    public static void register() {
        // WorldRenderEvents.BEFORE_BLOCK_OUTLINE を使ってブロックアウトラインをキャンセル
        WorldRenderEvents.BEFORE_BLOCK_OUTLINE.register((worldRenderContext, hitResult) -> {
            // 設定でブロックアウトライン非表示が有効で、NO_HUD状態かつ一時表示キーが押されていない時は非表示
            return !PeekF1Config.getInstance().shouldHideBlockOutlineInNoHud() ||
                    !PeekF1.state.equals(HUDState.NO_HUD) ||
                    PeekF1.isTemporaryShowHud(); // ブロックアウトラインの描画をキャンセル
// 通常通り描画
        });
    }
}