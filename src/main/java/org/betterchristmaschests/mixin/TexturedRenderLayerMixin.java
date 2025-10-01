package org.betterchristmaschests.mixin;

import com.mojang.datafixers.types.templates.Check;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.block.entity.state.ChestBlockEntityRenderState;
import net.minecraft.client.util.SpriteIdentifier;
import org.betterchristmaschests.BetterChristmasChests;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
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
     * @param variant The {@link BlockEntity Chest Variant}
     * @param type The {@link ChestType Chest Type}
     * @param callbackInfoReturnable The {@link CallbackInfoReturnable<SpriteIdentifier> Sprite Identifier Callback Info Returnable}
     */
    @Inject(at = @At(value = "RETURN"), method = "getChestTextureId(Lnet/minecraft/client/render/block/entity/state/ChestBlockEntityRenderState$Variant;Lnet/minecraft/block/enums/ChestType;)Lnet/minecraft/client/util/SpriteIdentifier;", cancellable = true)
    private static void getChestTextureId(final ChestBlockEntityRenderState.Variant variant, final ChestType type, final CallbackInfoReturnable<SpriteIdentifier> callbackInfoReturnable) {
        if(ChestBlockEntityRenderer.isAroundChristmas()) {
            switch (variant) {
                case ENDER_CHEST -> callbackInfoReturnable.setReturnValue(getChestId("ender", type));
                case COPPER_UNAFFECTED -> callbackInfoReturnable.setReturnValue(getChestId("copper", type));
                case COPPER_WEATHERED -> callbackInfoReturnable.setReturnValue(getChestId("copper_weathered", type));
                case COPPER_EXPOSED -> callbackInfoReturnable.setReturnValue(getChestId("copper_exposed", type));
                case COPPER_OXIDIZED -> callbackInfoReturnable.setReturnValue(getChestId("copper_oxidized", type));
                default -> callbackInfoReturnable.setReturnValue(callbackInfoReturnable.getReturnValue());
            }
        }
    }

    /**
     * Get the {@link SpriteIdentifier chest sprite identifier}
     *
     * @param name The {@link String base chest identifier name}
     * @param type The {@link ChestType chest type}
     * @return The {@link SpriteIdentifier chest sprite identifier}
     */
    @Unique
    private static SpriteIdentifier getChestId(final String name, final ChestType type) {
        final String suffix = switch (type) {
            case SINGLE -> "";
            case LEFT -> "_left";
            case RIGHT -> "_right";
        };
        return new SpriteIdentifier(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, BetterChristmasChests.identifier("entity/chest/" + name + suffix));
    }

}