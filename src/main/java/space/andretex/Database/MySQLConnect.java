package space.andretex.Database;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.config.Configuration;
import space.andretex.Main;
import java.sql.Statement;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

import static java.text.Collator.PRIMARY;

public class MySQLConnect {
   //private String host = "localhost";
   //private String port = "3306";
   //private String database = "easyloginpl";
   //private String username = "root";
   //private String password = "";
    private Configuration config = Main.getInstance().config;
    private String host = config.getString("database.db-host");
    private String port = config.getString("database.db-port");
    private String database = config.getString("database.db-database");
    private String username = config.getString("database.db-username");
    private String password = config.getString("database.db-password");

    private Connection connection;

    public boolean isConnected() {
        return (connection == null ? false : true);
    }

    public void connect() throws ClassNotFoundException, SQLException {
        if (!isConnected()) {
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false", username, password);


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
