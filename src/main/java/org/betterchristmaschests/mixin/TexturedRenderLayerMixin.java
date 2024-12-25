package org.betterchristmaschests.mixin;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import org.betterchristmaschests.BetterChristmasChests;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Mixin class for the {@link TexturedRenderLayers Textured Render Layers} class
 */
@Mixin(TexturedRenderLayers.class)
public class TexturedRenderLayerMixin {

    /**
     * Render the Christmas Ender Chest Texture when it's Christmas
     *
     * @param blockEntity The {@link BlockEntity Chest Block Entity}
     * @param type The {@link ChestType Chest Type}
     * @param christmas {@link Boolean Whether it's Christmas}
     * @param callbackInfoReturnable The {@link CallbackInfoReturnable<SpriteIdentifier> Sprite Identifier Callback Info Returnable}
     */
    @Inject(at = @At(value = "RETURN"), method = "getChestTextureId(Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/block/enums/ChestType;Z)Lnet/minecraft/client/util/SpriteIdentifier;", cancellable = true)
    private static void getChestTextureId(final BlockEntity blockEntity, final ChestType type, final boolean christmas, final CallbackInfoReturnable<SpriteIdentifier> callbackInfoReturnable) {
        if(christmas) {
            if (blockEntity instanceof EnderChestBlockEntity) {
                callbackInfoReturnable.setReturnValue(new SpriteIdentifier(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, BetterChristmasChests.identifier("entity/chest/ender")));
            }
        }
    }

}