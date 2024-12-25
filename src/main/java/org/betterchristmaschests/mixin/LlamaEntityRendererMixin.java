package org.betterchristmaschests.mixin;

import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.entity.LlamaEntityRenderer;
import net.minecraft.client.render.entity.state.LlamaEntityRenderState;
import net.minecraft.util.Identifier;
import org.betterchristmaschests.BetterChristmasChests;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Mixin class for the {@link LlamaEntityRenderer Llama Entity Renderer} class
 */
@Mixin(LlamaEntityRenderer.class)
public final class LlamaEntityRendererMixin {

    /**
     * Render Christmas Chests on Llamas
     *
     * @param llamaEntityRenderState The {@link LlamaEntityRenderState Llama entity Render State}
     * @param callbackInfoReturnable The {@link CallbackInfoReturnable<Identifier> Identifier Callback Info Returnable}
     */
    @Inject(at = @At(value = "RETURN"), method = "getTexture(Lnet/minecraft/client/render/entity/state/LlamaEntityRenderState;)Lnet/minecraft/util/Identifier;", cancellable = true)
    private void getTexture(final LlamaEntityRenderState llamaEntityRenderState, final CallbackInfoReturnable<Identifier> callbackInfoReturnable) {
        if(ChestBlockEntityRenderer.isAroundChristmas()) {
            callbackInfoReturnable.setReturnValue(BetterChristmasChests.identifier(callbackInfoReturnable.getReturnValue().getPath()));
        }
    }

}