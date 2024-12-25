package org.betterchristmaschests.mixin;

import net.minecraft.client.renderer.entity.LlamaRenderer;
import net.minecraft.client.renderer.entity.state.LlamaRenderState;
import net.minecraft.resources.ResourceLocation;
import org.betterchristmaschests.BetterChristmasChests;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Mixin class for the {@link LlamaRenderer Llama Entity Renderer} class
 */
@Mixin(LlamaRenderer.class)
public final class LlamaRendererMixin {

    /**
     * Render Christmas Chests on Llamas
     *
     * @param llamaRenderState The {@link LlamaRenderState Llama Render State}
     * @param callbackInfoReturnable The {@link CallbackInfoReturnable<ResourceLocation> Resource Location Callback Info Returnable}
     */
    @Inject(at = @At(value = "RETURN"), method = "getTextureLocation(Lnet/minecraft/client/renderer/entity/state/LlamaRenderState;)Lnet/minecraft/resources/ResourceLocation;", cancellable = true)
    private void getTextureLocation(final LlamaRenderState llamaRenderState, final CallbackInfoReturnable<ResourceLocation> callbackInfoReturnable) {
        if(BetterChristmasChests.isAroundChristmas()) {
            callbackInfoReturnable.setReturnValue(BetterChristmasChests.resourceLocation(callbackInfoReturnable.getReturnValue().getPath()));
        }
    }

}