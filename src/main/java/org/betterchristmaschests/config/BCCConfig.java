package org.betterchristmaschests.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import org.betterchristmaschests.BetterChristmasChests;

/**
 * {@link BetterChristmasChests Better Christmas Chests} {@link ConfigData Configuration class}
 */
@Config(name = BetterChristmasChests.MOD_ID)
public final class BCCConfig implements ConfigData {

    public ChestTextureBehavior CHESTS = ChestTextureBehavior.SHOW_ON_CHRISTMAS;
    public ChestTextureBehavior TRAPPED_CHESTS = ChestTextureBehavior.SHOW_ON_CHRISTMAS;
    public ChestTextureBehavior ENDER_CHESTS = ChestTextureBehavior.SHOW_ON_CHRISTMAS;
    public ChestTextureBehavior BARRELS = ChestTextureBehavior.SHOW_ON_CHRISTMAS;
    public ChestTextureBehavior SHULKER_BOXES = ChestTextureBehavior.SHOW_ON_CHRISTMAS;
    public ChestTextureBehavior CHEST_BOATS = ChestTextureBehavior.SHOW_ON_CHRISTMAS;
    public ChestTextureBehavior CHEST_MINECARTS = ChestTextureBehavior.SHOW_ON_CHRISTMAS;
    public ChestTextureBehavior LLAMA_CHESTS = ChestTextureBehavior.SHOW_ON_CHRISTMAS;
    public ChestTextureBehavior DONKEY_CHESTS = ChestTextureBehavior.SHOW_ON_CHRISTMAS;
    public ChestTextureBehavior MULE_CHESTS = ChestTextureBehavior.SHOW_ON_CHRISTMAS;

}