package org.betterchristmaschests.mixin;

import net.minecraft.client.renderer.entity.DonkeyRenderer;
import net.minecraft.client.renderer.entity.state.DonkeyRenderState;
import net.minecraft.resources.Identifier;
import org.betterchristmaschests.BetterChristmasChests;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Mixin class for the {@link DonkeyRenderer Donkey Entity Renderer} class
 */
@Mixin(DonkeyRenderer.class)
public final class DonkeyEntityRendererMixin {

    /**
     * Render Christmas Chests on Llamas
     *
     * @param donkeyEntityRenderState The {@link DonkeyRenderer Donkey entity Render State}
     * @param callbackInfoReturnable The {@link CallbackInfoReturnable<Identifier> Identifier Callback Info Returnable}
     */
    @Inject(at = @At(value = "RETURN"), method = "getTextureLocation(Lnet/minecraft/client/renderer/entity/state/DonkeyRenderState;)Lnet/minecraft/resources/Identifier;", cancellable = true)
    private void getTexture(final DonkeyRenderState donkeyEntityRenderState, final CallbackInfoReturnable<Identifier> callbackInfoReturnable) {
        if(BetterChristmasChests.isChristmas()) {
            callbackInfoReturnable.setReturnValue(BetterChristmasChests.identifier(callbackInfoReturnable.getReturnValue().getPath()));
        }
    }

}