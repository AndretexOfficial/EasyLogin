package me.andretex;

import me.andretex.Database.MySQL;
import net.md_5.bungee.api.plugin.Plugin;
import me.andretex.Utils.*;
import net.md_5.bungee.config.Configuration;

import java.sql.SQLException;

public final class Main extends Plugin {


    private static Main instance;
    public Configuration config;

    public MySQL SQL;
    public static Main plugin;

    public void onEnable() {
        instance = this;
        this.config = (new Config()).getConfig();
        this.getCommands();
        this.getLogger().info(Message.color("\n &6EasyLogin &aENABLE &r\n"));

        this.SQL = new MySQL();

        try {
            SQL.connect();
        } catch (ClassNotFoundException | SQLException e) {

            System.out.println("Database not connected");
        }

        if (SQL.isConnected()) {
            System.out.println("Database connected");
        }
        plugin = this;
    }

    private void getCommands() {
    }

    public void onDisable() {
        this.getLogger().info(Message.color("\n &6EasyLogin &cDISABLE &r\n"));
    }



    public static Main getInstance() {
        return instance;
    }

    public Configuration getConfig() {
        return null;
    }
}
