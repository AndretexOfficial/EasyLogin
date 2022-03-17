package space.andretex.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import space.andretex.Main;
import space.andretex.Utils.Message;

public class Register {
    private Configuration config = Main.getInstance().config;

    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            System.out.println("&8&l[&eEasyLogin]&8");
            System.out.println(config.getString("messages.console.you-are-not-a-player"));
        }else if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            try {
                Message.send(player, "&8&l[&eEasyLogin]&8" + "\n" + "messages.command.help");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
