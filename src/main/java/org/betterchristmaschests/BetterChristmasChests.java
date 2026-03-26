package org.betterchristmaschests;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.SpecialDates;

/**
 * Better Christmas Chests.
 * Make all chests have a special texture when it's Christmas
 */
public final class BetterChristmasChests implements ClientModInitializer {

    /**
     * The {@link String Mod Id}
     */
    public static final String MOD_ID = "betterchristmaschests";

    /**
     * Initialize the mod
     */
    @Override
    public void onInitializeClient() {
    }

    /**
     * Get a {@link Identifier modded Identifier}
     *
     * @param resourceName The {@link String resource name}
     * @return The {@link Identifier modded Identifier}
     */
    public static Identifier identifier(final String resourceName) {
        return Identifier.fromNamespaceAndPath(MOD_ID, resourceName);
    }

    /**
     * Check whether is Christmas or not
     *
     * @return {@link Boolean True} if is Christmas
     */
    public static Boolean isChristmas() {
        return SpecialDates.isExtendedChristmas();
    }

}
