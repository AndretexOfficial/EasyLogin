package me.andretex;

import me.andretex.Database.MySQL;
import net.md_5.bungee.api.plugin.Plugin;
import me.andretex.Utils.*;
import net.md_5.bungee.config.Configuration;

import java.sql.SQLException;

public final class Main extends Plugin {
/*
    private static Main istance;
    public Configuration config;

    public MySQL SQL;

    public Main() {
    }

    @Override
    public void onEnable() {
        instance = this;
        this.config = (new Config()).getConfig();

        this.SQL = new MySQL();

        try {
            SQL.connect();
        } catch (ClassNotFoundException | SQLException e) {

            System.out.println("Database not connected");
        }

        if (SQL.isConnected()) {
            System.out.println("Database connected");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return instance;
    }

 */

    private static Main instance;
    public Configuration config;

    public MySQL SQL;

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
    }

    private void getCommands() {
    }

    public void onDisable() {
        this.getLogger().info(Message.color("\n &6EasyLogin &cDISABLE &r\n"));
    }

    /*public void getCommands() {
        String ssPerm = this.config.getString("commands.ss.permission");
        String fnishPerm = this.config.getString("commands.finish.permission");
        if (ssPerm != null) {
            this.getProxy().getPluginManager().registerCommand(this, new SSCommand("ss", ssPerm));
        } else {
            this.getProxy().getPluginManager().registerCommand(this, new SSCommand("ss"));
        }

        if (fnishPerm != null) {
            this.getProxy().getPluginManager().registerCommand(this, new FinishCommand("finish", fnishPerm));
        } else {
            this.getProxy().getPluginManager().registerCommand(this, new FinishCommand("finish"));
        }

    }*/

    public static Main getInstance() {
        return instance;
    }
}
