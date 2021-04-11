package io.github.mooy1.simpleutils;

import io.github.mooy1.infinitylib.slimefun.presets.RecipePreset;
import io.github.mooy1.simpleutils.blocks.Sieve;
import io.github.mooy1.simpleutils.blocks.Workbench;
import io.github.mooy1.simpleutils.tools.MiningHammer;
import io.github.mooy1.simpleutils.tools.Wrench;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import javax.annotation.Nonnull;
import lombok.experimental.UtilityClass;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

@UtilityClass
public final class Items {
    
    public static final SlimefunItemStack WRENCH = new SlimefunItemStack(
            "SIMPLE_WRENCH",
            Material.IRON_HOE,
            "&6簡易扳手",
            "&e右鍵點擊快速拆除 物流, 電容, 和機器"
    );
    public static final SlimefunItemStack HAMMER_ROD = new SlimefunItemStack(
            "HAMMER_ROD",
            Material.BLAZE_ROD,
            "&6錘桿",
            "&7礦錘的核心組件"
    );
    public static final SlimefunItemStack SIEVE = new SlimefunItemStack(
            "SIMPLE_SIEVE",
            Material.COMPOSTER,
            "&6簡易篩網",
            "&7將礫石篩成粉和材料"
    );
    public static final SlimefunItemStack ELEVATOR = new SlimefunItemStack(
            "SIMPLE_ELEVATOR",
            Material.QUARTZ_BLOCK,
            "&f簡單電梯",
            "&7蹲下來下去, 跳躍來上去"
    );
    public static final SlimefunItemStack WORKBENCH = new SlimefunItemStack(
            "SIMPLE_WORKBENCH",
            Material.CRAFTING_TABLE,
            "&6簡單工作台",
            "&7可以製作原版和黏液科技的配方"
    );

    public static void setup(@Nonnull SimpleUtils plugin) {
        Category category = new Category(SimpleUtils.inst().getKey("main"), new CustomItem(Material.COMPOSTER, "&6簡單實用工具"), 0);

        // blocks
        new Workbench(category, Items.WORKBENCH, RecipeType.ENHANCED_CRAFTING_TABLE,
                RecipePreset.firstItem(new ItemStack(Material.CRAFTING_TABLE))
        ).register(plugin);
        new Sieve(category, Items.SIEVE, new ItemStack[] {
                null, null, null,
                null, new ItemStack(Material.OAK_TRAPDOOR), null,
                null, new ItemStack(Material.COMPOSTER), null
        }, BlockFace.SELF).register(plugin);

        // tools
        new Wrench(category, Items.WRENCH, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.ALUMINUM_INGOT, null, SlimefunItems.ALUMINUM_INGOT,
                null, SlimefunItems.SILVER_INGOT, null,
                null, SlimefunItems.ALUMINUM_INGOT, null
        }).register(plugin);
        new MiningHammer(category, Material.IRON_PICKAXE, SlimefunItems.COPPER_INGOT, "&6銅", 3, 1).register(plugin);
        new MiningHammer(category, Material.DIAMOND_PICKAXE, new ItemStack(Material.DIAMOND), "&b鑽石", 3, 2).register(plugin);
        new MiningHammer(category, Material.IRON_PICKAXE, SlimefunItems.REINFORCED_ALLOY_INGOT, "&7強化合金", 3, 3).register(plugin);
        new MiningHammer(category, Material.NETHERITE_PICKAXE, SlimefunItems.CARBONADO, "&8黑鑽石", 5, 4).register(plugin);

        // misc
        new SlimefunItem(category, Items.HAMMER_ROD, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_INGOT,
                SlimefunItems.STEEL_INGOT, new ItemStack(Material.BLAZE_ROD), SlimefunItems.STEEL_INGOT,
                SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_INGOT
        }).register(plugin);
    }
    
}
