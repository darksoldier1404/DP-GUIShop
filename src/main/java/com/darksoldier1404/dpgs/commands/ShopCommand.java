package com.darksoldier1404.dpgs.commands;

import com.darksoldier1404.dpgs.functions.CommonFunction;
import com.darksoldier1404.dpgs.functions.ShopFunction;
import com.darksoldier1404.dppc.builder.command.CommandBuilder;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;

import static com.darksoldier1404.dpgs.GUIShop.*;

public class ShopCommand {
    private final CommandBuilder builder = new CommandBuilder(prefix);

    public ShopCommand() {
        builder.addSubCommand("create", "dpgs.admin", lang.get("cashshop_cmd_create"), true, (p, args) -> {
            if (args.length == 4) {
                ShopFunction.createShop((Player) p, args[1], args[2]);
            } else {
                p.sendMessage(prefix + lang.get("cashshop_cmd_create_usage"));
            }
        });
        builder.addSubCommand("items", "dpgs.admin", lang.get("cashshop_cmd_items"), true, (p, args) -> {
            if (args.length == 2) {
                ShopFunction.openShopItemSetting((Player) p, args[1]);
            } else {
                p.sendMessage(prefix + lang.get("cashshop_cmd_items_usage"));
            }
        });
        builder.addSubCommand("price", "dpgs.admin", lang.get("cashshop_cmd_price"), true, (p, args) -> {
            if (args.length == 2) {
                ShopFunction.openShopPriceSetting((Player) p, args[1]);
            } else {
                p.sendMessage(prefix + lang.get("cashshop_cmd_price_usage"));
            }
        });
        builder.addSubCommand("maxpage", "dpgs.admin", lang.get("cashshop_cmd_maxpage"), true, (p, args) -> {
            if (args.length == 3) {
                ShopFunction.setShopMaxPage((Player) p, args[1], args[2]);
            } else {
                p.sendMessage(prefix + lang.get("cashshop_cmd_maxpage_usage"));
            }
        });
        // delete
        builder.addSubCommand("delete", "dpgs.admin", lang.get("cashshop_cmd_delete"), true, (p, args) -> {
            if (args.length == 2) {
                ShopFunction.deleteShop((Player) p, args[1]);
            } else {
                p.sendMessage(prefix + lang.get("cashshop_cmd_delete_usage"));
            }
        });
        builder.addSubCommand("reload", "dpgs.admin", lang.get("cashshop_cmd_reload"), (p, args) -> {
            if (args.length == 1) {
                CommonFunction.init();
            } else {
                p.sendMessage(prefix + lang.get("cashshop_cmd_reload_usage"));
            }
        });
        builder.addSubCommand("open", "dpgs.user", lang.get("cashshop_cmd_open"), true, (p, args) -> {
            if (args.length == 2) {
                ShopFunction.openShop((Player) p, args[1]);
            } else {
                p.sendMessage(prefix + lang.get("cashshop_cmd_open_usage"));
            }
        });
        builder.addSubCommand("migration", "dpgs.admin", lang.get("cashshop_cmd_migration"), true, (p, args) -> {
            if (args.length == 1) {
                CommonFunction.migration();
            }
        });

        builder.addSubCommand("enable", "dpgs.admin", lang.get("cashshop_cmd_enable"), true, (p, args) -> {
            if (args.length == 2) {
                ShopFunction.setShopEnable((Player) p, args[1]);
            } else {
                p.sendMessage(prefix + lang.get("cashshop_cmd_enable_usage"));
            }
        });

        builder.addSubCommand("disable", "dpgs.admin", lang.get("cashshop_cmd_disable"), true, (p, args) -> {
            if (args.length == 2) {
                ShopFunction.setShopDisable((Player) p, args[1]);
            } else {
                p.sendMessage(prefix + lang.get("cashshop_cmd_disable_usage"));
            }
        });
        builder.addSubCommand("permission", "dpgs.admin", lang.get("cashshop_cmd_permission"), true, (p, args) -> {
            if (args.length == 3) {
                ShopFunction.setShopPermission((Player) p, args[1], args[2]);
            } else {
                p.sendMessage(prefix + lang.get("cashshop_cmd_permission_usage"));
            }
        });
        builder.addSubCommand("removepermission", "dpgs.admin", lang.get("cashshop_cmd_removepermission"), true, (p, args) -> {
            if (args.length == 2) {
                ShopFunction.removeShopPermission((Player) p, args[1]);
            } else {
                p.sendMessage(prefix + lang.get("cashshop_cmd_removepermission_usage"));
            }
        });
        for (String c : builder.getSubCommandNames()) {
            builder.addTabCompletion(c, (sender, args) -> {
                if (args.length == 1) {
                    return builder.getSubCommandNames();
                }
                if (args.length == 2 && builder.getSubCommandNames().contains(args[0].toLowerCase())) {
                    return new ArrayList<>(shops.keySet());
                }
                if (args.length == 3 && args[0].equalsIgnoreCase("create")) {
                    return Arrays.asList("2", "3", "4", "5", "6");
                }
                return null;
            });
        }
    }

    public CommandBuilder getExecutor() {
        return builder;
    }
}