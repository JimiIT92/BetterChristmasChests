package org.betterchristmaschests;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.util.Identifier;

/**
 * Better Christmas Chests.
 * Make all chests and containers have a special texture when it's Christmas
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
        return Identifier.of(MOD_ID, resourceName);
    }

}