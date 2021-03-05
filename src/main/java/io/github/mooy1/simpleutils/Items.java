package io.github.mooy1.simpleutils;

import io.github.mooy1.infinitylib.PluginUtils;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Material;

import java.util.Locale;

@UtilityClass
public final class Items {

    public static final Category CATEGORY = new Category(PluginUtils.getKey("main"), new CustomItem(Material.COMPOSTER, "&6簡單實用工具"), 0);
    
    // dusts
    public static final SlimefunItemStack NICKEL_DUST = dust(Material.SUGAR, "&7鎳");
    public static final SlimefunItemStack COBALT_DUST = dust(Material.SUGAR, "&9鈷");

    private static SlimefunItemStack dust(Material material, String  name) {
        return new SlimefunItemStack(
                name.substring(2).toUpperCase(Locale.ROOT) + "_DUST",
                material,
                name + "粉"
        );
    }
    
    // misc
    public static final SlimefunItemStack AUTOMATON_CORE = new SlimefunItemStack(
      "AUTOMATON_CORE",
      Material.POLISHED_GRANITE,
      "&6自動核心",
      "&7簡單自動化機器的核心組件"
    );
    
    public static final SlimefunItemStack HAMMER_ROD = new SlimefunItemStack(
            "HAMMER_ROD",
            Material.STICK,
            "&6錘桿",
            "&7礦錘的核心組件"
    );
    
}
