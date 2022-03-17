package space.andretex;

import space.andretex.Database.MySQLConnect;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import space.andretex.Utils.Config;
import space.andretex.Utils.Message;
import space.andretex.Commands.Help;

import java.sql.SQLException;

public final class Main extends Plugin {


    private static Main instance;
    public Configuration config;
    public Configuration lang;

    public MySQLConnect SQL;
    public static Main plugin;

    public void onEnable() {
        instance = this;

        Config configmanager = new Config();
        this.config = configmanager.getConfig();

        this.getCommands();

        this.getLogger().info(Message.color("&6EasyLogin &aENABLE &r"));

        this.SQL = new MySQLConnect();

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

    public void getCommands() {


        String helpPerm = config.getString("commands.help.permission");
        if (helpPerm != null) {
            getProxy().getPluginManager().registerCommand(this, new Help("easyhelp"));
        } else {
            getProxy().getPluginManager().registerCommand(this, new Help("easyhelp"));
        }


        String loginPerm = config.getString("commands.login.permission");
        if (loginPerm != null) {
            getProxy().getPluginManager().registerCommand(this, new Help("login"));
        } else {
            getProxy().getPluginManager().registerCommand(this, new Help("login"));
        }


        String registerPerm = config.getString("commands.register.permission");
        if (registerPerm != null) {
            getProxy().getPluginManager().registerCommand(this, new Help("register"));
        } else {
            getProxy().getPluginManager().registerCommand(this, new Help("register"));
        }
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
