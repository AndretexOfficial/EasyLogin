package me.andretex.Database;

import me.andretex.Main;
import net.md_5.bungee.config.Configuration;
import me.andretex.Utils.Message;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
   //private String host = "localhost";
   //private String port = "3306";
   //private String database = "easyloginpl";
   //private String username = "root";
   //private String password = "";

    private String host = Main.plugin.getConfig().getString("Database.dbHost");
    private String port = Main.plugin.getConfig().getString("Database.dbPort");
    private String database = Main.plugin.getConfig().getString("Database.dbDatabase");
    private String username = Main.plugin.getConfig().getString("Database.dbUsername");
    private String password = Main.plugin.getConfig().getString("Database.dbPassword");

    private Connection connection;

    public boolean isConnected() {
        return (connection == null ? false : true);
    }

    public void connect() throws ClassNotFoundException, SQLException {
        if (!isConnected()) {
            connection = DriverManager.getConnection("jdbc:mysql://" +
                            host + ":" + port + "/" + database + "?useSSL=false",
                    username, password);
        }
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
