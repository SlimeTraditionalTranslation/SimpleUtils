package io.github.mooy1.simpleutils.implementation;

import java.util.Arrays;

import javax.annotation.Nonnull;

import lombok.experimental.UtilityClass;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

import io.github.mooy1.simpleutils.SimpleUtils;
import io.github.mooy1.simpleutils.implementation.blocks.Elevator;
import io.github.mooy1.simpleutils.implementation.blocks.Sieve;
import io.github.mooy1.simpleutils.implementation.blocks.Workbench;
import io.github.mooy1.simpleutils.implementation.tools.Wrench;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

@UtilityClass
public final class Items {

    public static final SlimefunItemStack WRENCH = new SlimefunItemStack(
            "SIMPLE_WRENCH",
            Material.IRON_HOE,
            "${simpleutils.simple_wrench.name}",
            "${simpleutils.simple_wrench.lore}"
    );
    public static final SlimefunItemStack SIEVE = new SlimefunItemStack(
            "SIMPLE_SIEVE",
            Material.COMPOSTER,
            "${simpleutils.simple_sieve.name}",
            "${simpleutils.simple_sieve.lore}"
    );
    public static final SlimefunItemStack ELEVATOR = new SlimefunItemStack(
            "SIMPLE_ELEVATOR",
            Material.QUARTZ_BLOCK,
            "${simpleutils.simple_elevator.name}",
            "${simpleutils.simple_elevator.lore}"
    );
    public static final SlimefunItemStack WORKBENCH = new SlimefunItemStack(
            "SIMPLE_WORKBENCH",
            Material.CRAFTING_TABLE,
            "${simpleutils.simple_workbench.name}",
            "${simpleutils.simple_workbench.lore}"
    );

    public static void setup(@Nonnull SimpleUtils plugin) {
        ItemGroup category = new ItemGroup(SimpleUtils.createKey("main"),
                new CustomItemStack(Material.COMPOSTER, "${simpleutils.itemgroup.name}"), 0);

        new Workbench(category, WORKBENCH, RecipeType.ENHANCED_CRAFTING_TABLE,
                Arrays.copyOf(new ItemStack[] {new ItemStack(Material.CRAFTING_TABLE)}, 9)
        ).register(plugin);

        new Sieve(category, SIEVE, new ItemStack[] {
                null, null, null,
                null, new ItemStack(Material.OAK_TRAPDOOR), null,
                null, new ItemStack(Material.COMPOSTER), null
        }, BlockFace.SELF).register(plugin);

        new Elevator(category, ELEVATOR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(Material.QUARTZ_BLOCK), new ItemStack(Material.QUARTZ_BLOCK), new ItemStack(Material.QUARTZ_BLOCK),
                new ItemStack(Material.QUARTZ_BLOCK), new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.QUARTZ_BLOCK),
                new ItemStack(Material.QUARTZ_BLOCK), new ItemStack(Material.QUARTZ_BLOCK), new ItemStack(Material.QUARTZ_BLOCK)
        }).register(plugin);

        new Wrench(category, WRENCH, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.ALUMINUM_INGOT, null, SlimefunItems.ALUMINUM_INGOT,
                null, SlimefunItems.SILVER_INGOT, null,
                null, SlimefunItems.ALUMINUM_INGOT, null
        }).register(plugin);
    }

}
