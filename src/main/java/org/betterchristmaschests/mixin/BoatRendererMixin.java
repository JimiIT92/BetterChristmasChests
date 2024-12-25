package org.betterchristmaschests.mixin;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.state.BoatRenderState;
import net.minecraft.resources.ResourceLocation;
import org.betterchristmaschests.BetterChristmasChests;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Mixin class for the {@link BoatRenderer Boat Entity Renderer} class
 */
@Mixin(BoatRenderer.class)
public final class BoatRendererMixin {

    /**
     * The {@link EntityModel<BoatRenderState> Boat Entity Model}
     */
    @Shadow @Final private EntityModel<BoatRenderState> model;

    /**
     * The {@link ResourceLocation Boat Texture}
     */
    @Shadow @Final private ResourceLocation texture;

    /**
     * Render the Christmas Chest Texture on Boats with Chests
     *
     * @param callbackInfoReturnable The {@link CallbackInfoReturnable<RenderType> Render Type Callback Info Returnable}
     */
    @Inject(at = @At(value = "RETURN"), method = "renderType", cancellable = true)
    private void renderType(final CallbackInfoReturnable<RenderType> callbackInfoReturnable) {
        if(BetterChristmasChests.isAroundChristmas()) {
            callbackInfoReturnable.setReturnValue(this.model.renderType(BetterChristmasChests.resourceLocation(this.texture.getPath())));
        }
    }

}