package org.betterchristmaschests;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.common.Mod;

import java.util.Calendar;

/**
 * Better Christmas Chests.
 * Make all chests and containers have a special texture when it's Christmas
 */
@Mod(BetterChristmasChests.MOD_ID)
public final class BetterChristmasChests {

    /**
     * The {@link String Mod Id}
     */
    public static final String MOD_ID = "betterchristmaschests";

    /**
     * Get a {@link ResourceLocation modded Resource Location}
     *
     * @param resourceName The {@link String resource name}
     * @return The {@link ResourceLocation modded Resource Location}
     */
    public static ResourceLocation resourceLocation(final String resourceName) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, resourceName);
    }

    /**
     * Check whether is around Christmas
     *
     * @return {@link Boolean True if is around Christmas}
     */
    public static boolean isAroundChristmas() {
        final Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1 == 12 && calendar.get(Calendar.DATE) >= 24 && calendar.get(Calendar.DATE) <= 26;
    }

}