package org.betterchristmaschests.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.betterchristmaschests.BetterChristmasChests;

/**
 * {@link BetterChristmasChests Better Christmas Chests} {@link BCCConfig Configuration} {@link ModMenuApi Mod Menu integration}
 */
@Environment(EnvType.CLIENT)
public final class BCCModMenuIntegration implements ModMenuApi {

    /**
     * Get the {@link BetterChristmasChests Better Christmas Chests} {@link BCCConfig Configuration} screen
     *
     * @return The {@link BetterChristmasChests Better Christmas Chests} {@link BCCConfig Configuration} screen
     */
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutoConfig.getConfigScreen(BCCConfig.class, parent).get();
    }

}