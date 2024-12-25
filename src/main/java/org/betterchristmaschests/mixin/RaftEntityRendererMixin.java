package org.betterchristmaschests.mixin;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.entity.RaftEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.BoatEntityRenderState;
import net.minecraft.util.Identifier;
import org.betterchristmaschests.BetterChristmasChests;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Mixin class for the {@link RaftEntityRenderer Raft Entity Renderer} class
 */
@Mixin(RaftEntityRenderer.class)
public final class RaftEntityRendererMixin {

    /**
     * The {@link EntityModel<BoatEntityRenderState> Raft Entity Model}
     */
    @Shadow @Final private EntityModel<BoatEntityRenderState> model;

    /**
     * The {@link Identifier Raft Texture}
     */
    @Shadow @Final private Identifier texture;

    /**
     * Render the Christmas Chest Texture on Rafts with Chests
     *
     * @param callbackInfoReturnable The {@link CallbackInfoReturnable<RenderLayer> Render Layer Callback Info Returnable}
     */
    @Inject(at = @At(value = "RETURN"), method = "getRenderLayer", cancellable = true)
    private void getRenderLayer(final CallbackInfoReturnable<RenderLayer> callbackInfoReturnable) {
        if(ChestBlockEntityRenderer.isAroundChristmas()) {
            callbackInfoReturnable.setReturnValue(this.model.getLayer(BetterChristmasChests.identifier(this.texture.getPath())));
        }
    }

}