package org.betterchristmaschests.config;

import me.shedaniel.clothconfig2.gui.entries.SelectionListEntry;
import org.jetbrains.annotations.NotNull;

/**
 * The Chest Textures Behavior
 */
public enum ChestTextureBehavior implements SelectionListEntry.Translatable {
    SHOW_ON_CHRISTMAS,
    ALWAYS_SHOW,
    NEVER_SHOW;

    /**
     * Get the {@link String Enum Translation Key}
     *
     * @return The {@link String Enum Translation Key}
     */
    @Override
    public @NotNull String getKey() {
        return "text.autoconfig.betterchristmaschests.value." + name();
    }
}