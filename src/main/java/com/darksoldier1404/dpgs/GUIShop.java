package com.darksoldier1404.dpgs;

import com.darksoldier1404.dpgs.commands.ShopCommand;
import com.darksoldier1404.dpgs.events.DPGSEvent;
import com.darksoldier1404.dpgs.functions.CommonFunction;
import com.darksoldier1404.dpgs.obj.Shop;
import com.darksoldier1404.dppc.api.inventory.DInventory;
import com.darksoldier1404.dppc.lang.DLang;
import com.darksoldier1404.dppc.utils.PluginUtil;
import com.darksoldier1404.dppc.utils.Tuple;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GUIShop extends JavaPlugin {
    public static GUIShop plugin;
    public static YamlConfiguration config;
    public static DLang lang;
    public static String prefix;
    public static final Map<String, Shop> shops = new HashMap<>();
    public static final Map<UUID, Tuple<Integer, DInventory>> currentEdit = new HashMap<>();

    @Override
    public void onLoad() {
        plugin = this;
        PluginUtil.addPlugin(this, 26579);
    }

    @Override
    public void onEnable() {
        CommonFunction.init();
        getServer().getPluginManager().registerEvents(new DPGSEvent(), plugin);
        getCommand("dpgs").setExecutor(new ShopCommand().getExecutor());
    }

    @Override
    public void onDisable() {
        CommonFunction.saveConfig();
    }
}
