package org.betterchristmaschests.mixin;

import net.minecraft.client.renderer.entity.DonkeyRenderer;
import net.minecraft.client.renderer.entity.state.DonkeyRenderState;
import net.minecraft.resources.ResourceLocation;
import org.betterchristmaschests.BetterChristmasChests;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Mixin class for the {@link DonkeyRenderer Donkey Entity Renderer} class
 */
@Mixin(DonkeyRenderer.class)
public final class DonkeyRendererMixin {

    /**
     * Render Christmas Chests on Llamas
     *
     * @param donkeyRenderState The {@link DonkeyRenderState Donkey Render State}
     * @param callbackInfoReturnable The {@link CallbackInfoReturnable<ResourceLocation> Resource Location Callback Info Returnable}
     */
    @Inject(at = @At(value = "RETURN"), method = "getTextureLocation(Lnet/minecraft/client/renderer/entity/state/DonkeyRenderState;)Lnet/minecraft/resources/ResourceLocation;", cancellable = true)
    private void getTextureLocation(final DonkeyRenderState donkeyRenderState, final CallbackInfoReturnable<ResourceLocation> callbackInfoReturnable) {
        if(BetterChristmasChests.isAroundChristmas()) {
            callbackInfoReturnable.setReturnValue(BetterChristmasChests.resourceLocation(callbackInfoReturnable.getReturnValue().getPath()));
        }
    }

}