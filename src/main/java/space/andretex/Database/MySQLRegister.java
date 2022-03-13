package space.andretex.Database;

import space.andretex.Main;

import java.sql.Connection;
import java.util.UUID;

public class MySQLRegister {
    private final Connection mysql = Main.getInstance().SQL.getConnection();

    public void register(UUID uuid, String password) {

    }


}
