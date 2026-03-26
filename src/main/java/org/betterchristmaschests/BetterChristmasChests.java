package org.betterchristmaschests;

import net.minecraft.resources.Identifier;
import net.minecraft.util.SpecialDates;
import net.neoforged.fml.common.Mod;

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
     * Get a {@link Identifier modded Resource Location}
     *
     * @param resourceName The {@link String resource name}
     * @return The {@link Identifier modded Resource Location}
     */
    public static Identifier resourceLocation(final String resourceName) {
        return Identifier.fromNamespaceAndPath(MOD_ID, resourceName);
    }

    /**
     * Check whether is around Christmas
     *
     * @return {@link Boolean True if is around Christmas}
     */
    public static boolean isAroundChristmas() {
        return SpecialDates.isExtendedChristmas();
    }

}