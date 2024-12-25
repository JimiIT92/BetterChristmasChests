package org.betterchristmaschests.mixin;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.EnderChestBlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.betterchristmaschests.BetterChristmasChests;
import org.spongepowered.asm.mixin.Mixin;
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
     * @param blockEntity The {@link BlockEntity Chest Block Entity}
     * @param chestType The {@link ChestType Chest Type}
     * @param holiday {@link Boolean Whether it's Christmas}
     * @param callbackInfoReturnable The {@link CallbackInfoReturnable<Material> Material Callback Info Returnable}
     */
    @Inject(at = @At(value = "RETURN"), method = "chooseMaterial(Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/level/block/state/properties/ChestType;Z)Lnet/minecraft/client/resources/model/Material;", cancellable = true)
    private static void chooseMaterial(final BlockEntity blockEntity, final ChestType chestType, final boolean holiday, final CallbackInfoReturnable<Material> callbackInfoReturnable) {
        if(holiday) {
            if (blockEntity instanceof EnderChestBlockEntity) {
                callbackInfoReturnable.setReturnValue(new Material(Sheets.CHEST_SHEET, BetterChristmasChests.resourceLocation("entity/chest/ender")));
            }
        }
    }

}