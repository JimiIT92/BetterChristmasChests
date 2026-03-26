package org.betterchristmaschests.mixin;

import net.minecraft.client.renderer.entity.LlamaRenderer;
import net.minecraft.client.renderer.entity.state.LlamaRenderState;
import net.minecraft.resources.Identifier;
import org.betterchristmaschests.BetterChristmasChests;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Mixin class for the {@link LlamaRenderer Llama Entity Renderer} class
 */
@Mixin(LlamaRenderer.class)
public final class LlamaEntityRendererMixin {

    /**
     * Render Christmas Chests on Llamas
     *
     * @param llamaEntityRenderState The {@link LlamaRenderer Llama entity Render State}
     * @param callbackInfoReturnable The {@link CallbackInfoReturnable<Identifier> Identifier Callback Info Returnable}
     */
    @Inject(at = @At(value = "RETURN"), method = "getTextureLocation(Lnet/minecraft/client/renderer/entity/state/LlamaRenderState;)Lnet/minecraft/resources/Identifier;", cancellable = true)
    private void getTexture(final LlamaRenderState llamaEntityRenderState, final CallbackInfoReturnable<Identifier> callbackInfoReturnable) {
        if(BetterChristmasChests.isChristmas()) {
            callbackInfoReturnable.setReturnValue(BetterChristmasChests.identifier(callbackInfoReturnable.getReturnValue().getPath()));
        }
    }

}