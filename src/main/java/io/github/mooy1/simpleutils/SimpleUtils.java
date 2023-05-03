package io.github.mooy1.simpleutils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPluginLoader;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.mooy1.infinitylib.metrics.bukkit.Metrics;
import io.github.mooy1.infinitylib.metrics.charts.SimplePie;
import io.github.mooy1.simpleutils.implementation.Items;
import org.mini2Dx.gettext.GetText;
import org.mini2Dx.gettext.PoFile;

public final class SimpleUtils extends AbstractAddon {

    public SimpleUtils(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file,
                "SlimeTraditionalTranslation", "SimpleUtils", "master", "auto-update");
    }

    public SimpleUtils() {
        super("SlimeTraditionalTranslation", "SimpleUtils", "master", "auto-update");
    }

    @Override
    protected void enable() {
        GetText.setLocale(java.util.Locale.TRADITIONAL_CHINESE);
        InputStream inputStream = getClass().getResourceAsStream("/translations/zh_tw.po");
        if (inputStream == null) {
            getLogger().warning("無法找到翻譯檔案！");
        } else {
            getLogger().info("載入繁體翻譯檔案...");
            try {
                PoFile poFile = new PoFile(java.util.Locale.TRADITIONAL_CHINESE, inputStream);
                GetText.add(poFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Items.setup(this);
        Metrics metrics = new Metrics(this, 10285);
        String ixInstalled = String.valueOf(getServer().getPluginManager().isPluginEnabled("InfinityExpansion"));
        String autoUpdates = String.valueOf(autoUpdatesEnabled());
        metrics.addCustomChart(new SimplePie("ix_installed", () -> ixInstalled));
        metrics.addCustomChart(new SimplePie("auto_updates", () -> autoUpdates));
    }

    @Override
    protected void disable() {

    }

}