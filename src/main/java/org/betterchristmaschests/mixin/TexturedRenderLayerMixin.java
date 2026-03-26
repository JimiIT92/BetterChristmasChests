package org.betterchristmaschests.mixin;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SpriteMapper;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.betterchristmaschests.BetterChristmasChests;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Mixin class for the {@link Sheets Textured Render Layers} class
 */
@Mixin(Sheets.class)
public class TexturedRenderLayerMixin {

    @Shadow
    @Final
    public static SpriteMapper CHEST_MAPPER;

    /**
     * Render the Christmas Ender Chest Texture when it's Christmas
     *
     * @param variant The {@link ChestRenderState.ChestMaterialType Chest Variant}
     * @param type The {@link ChestType Chest Type}
     * @param callbackInfoReturnable The {@link CallbackInfoReturnable<SpriteId> Sprite Identifier Callback Info Returnable}
     */
    @Inject(at = @At(value = "RETURN"), method = "chooseSprite", cancellable = true)
    private static void chooseSprite(final ChestRenderState.ChestMaterialType variant, final ChestType type, final CallbackInfoReturnable<SpriteId> callbackInfoReturnable) {
        if(BetterChristmasChests.isChristmas()) {
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
     * Get the {@link SpriteId chest sprite identifier}
     *
     * @param name The {@link String base chest identifier name}
     * @param type The {@link ChestType chest type}
     * @return The {@link SpriteId chest sprite identifier}
     */
    @Unique
    private static SpriteId getChestId(final String name, final ChestType type) {
        final String suffix = switch (type) {
            case SINGLE -> "";
            case LEFT -> "_left";
            case RIGHT -> "_right";
        };
        return CHEST_MAPPER.apply(BetterChristmasChests.identifier(name + suffix));
    }

}