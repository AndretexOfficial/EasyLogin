package space.andretex.Commands;


import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import space.andretex.Main;
import space.andretex.Utils.Message;

public class Help extends Command {

    private Configuration config = Main.getInstance().config;
    public Help(String commandName, String permission) {
        super(commandName, permission);
    }
    public Help(String commandName) {
        super(commandName);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            System.out.println(config.getString("messages.help.noplayer"));
        }else if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            try {
                Message.send(player, "messages.command.help");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
