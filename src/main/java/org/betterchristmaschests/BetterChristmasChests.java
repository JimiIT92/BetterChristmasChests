package org.betterchristmaschests;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import org.betterchristmaschests.config.BCCConfig;

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
     * The {@link BCCConfig Mod Configuration}
     */
    private static BCCConfig CONFIG;

    /**
     * Initialize the mod
     */
    @Override
    public void onInitializeClient() {
        AutoConfig.register(BCCConfig.class, GsonConfigSerializer::new);
    }

    /**
     * Get the {@link BCCConfig Mod Configuration}
     *
     * @return The {@link #CONFIG Mod Configuration}
     */
    public static BCCConfig config() {
        if(CONFIG == null) {
            CONFIG = AutoConfig.getConfigHolder(BCCConfig.class).getConfig();
        }
        return CONFIG;
    }

}