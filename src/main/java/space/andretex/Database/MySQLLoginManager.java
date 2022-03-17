package space.andretex.Database;

import java.util.UUID;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class MySQLLoginManager {
    public static void isRegistred(UUID uuid) {
        ProxiedPlayer p= ProxyServer.getInstance().getPlayer(uuid);

    }

}
