package org.betterchristmaschests.mixin;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.EnderChestBlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.betterchristmaschests.BetterChristmasChests;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Mixin class for the {@link Sheets Sheets} class
 */
@Mixin(Sheets.class)
public class SheetsMixin {

    /**
     * Render the Christmas Ender Chest Texture when it's Christmas
     *
     * @param variant The {@link ChestRenderState.ChestMaterialType Chest Variant}
     * @param type The {@link ChestType Chest Type}
     * @param callbackInfoReturnable The {@link CallbackInfoReturnable<Material> Material Callback Info Returnable}
     */
    @Inject(at = @At(value = "RETURN"), method = "chooseMaterial(Lnet/minecraft/client/renderer/blockentity/state/ChestRenderState$ChestMaterialType;Lnet/minecraft/world/level/block/state/properties/ChestType;)Lnet/minecraft/client/resources/model/Material;", cancellable = true)
    private static void chooseMaterial(final ChestRenderState.ChestMaterialType variant, final ChestType type, final CallbackInfoReturnable<Material> callbackInfoReturnable) {
        if(ChestRenderer.xmasTextures()) {
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
     * Get the {@link Material chest sprite identifier}
     *
     * @param name The {@link String base chest identifier name}
     * @param type The {@link ChestType chest type}
     * @return The {@link Material chest sprite identifier}
     */
    @Unique
    private static Material getChestId(final String name, final ChestType type) {
        final String suffix = switch (type) {
            case SINGLE -> "";
            case LEFT -> "_left";
            case RIGHT -> "_right";
        };
        return new Material(Sheets.CHEST_SHEET, BetterChristmasChests.resourceLocation("entity/chest/" + name + suffix));
    }

}