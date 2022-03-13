package space.andretex.Utils;

import space.andretex.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.config.Configuration;

public class Message {
    private static Configuration config;

    public Message() {
    }

    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static void send(ProxiedPlayer player, String configPath) {
        config = Main.getInstance().config;
        String msg = config.getString(configPath);
        if (msg != null) {
            msg = color(msg);
            player.sendMessage(msg);
        }

    }

    public static void send(ProxiedPlayer player, String configPath, String itemToReplace, String replaceWith) {
        config = Main.getInstance().config;
        String msg = config.getString(configPath);
        if (msg != null) {
            msg = msg.replaceAll(itemToReplace, replaceWith);
            msg = color(msg);
            player.sendMessage(msg);
        }

    }

    public static void send(CommandSender sender, String configPath) {
        config = Main.getInstance().config;
        String msg = config.getString(configPath);
        if (msg != null) {
            msg = color(msg);
            sender.sendMessage(msg);
        }

    }

    static {
        config = Main.getInstance().config;
    }
}
