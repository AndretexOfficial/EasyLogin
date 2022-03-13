//package space.andretex.Utils;
//
//import it.imperuscraft.ss.SS;
//import it.imperuscraft.ss.utils.Message;
//import net.md_5.bungee.api.CommandSender;
//import net.md_5.bungee.api.config.ServerInfo;
//import net.md_5.bungee.api.connection.ProxiedPlayer;
//import net.md_5.bungee.api.plugin.Command;
//import net.md_5.bungee.config.Configuration;
//
//import static it.imperuscraft.ss.commands.SSCommand.staffersTargets;
//
//public class FinishCommand extends Command {
//    private final SS ss = SS.getInstance();
//    private final Configuration config = ss.config;
//
//    public FinishCommand(String commandName, String permission) {
//        super(commandName, permission);
//    }
//
//    public FinishCommand(String commandName) {
//        super(commandName);
//    }
//
//    @Override
//    public void execute(CommandSender sender, String[] args) {
//        if (sender instanceof ProxiedPlayer) {
//            ProxiedPlayer player = (ProxiedPlayer) sender;
//            ServerInfo hubServer;
//            ProxiedPlayer target;
//
//            try {
//                String hubName = config.getString("servers.hub");
//                hubServer = ss.getProxy().getServerInfo(hubName);
//            } catch (Exception error) {
//                error.printStackTrace();
//                Message.send(player, "commands.fnish.messages.server-not-found");
//                return;
//            }
//
//            try {
//                target = ss.getProxy().getPlayer(staffersTargets.get(player.getUniqueId()));
//            } catch (Exception error) {
//                error.printStackTrace();
//                Message.send(player, "commands.finish.messages.player-not-found");
//                return;
//            }
//
//            try {
//                target.connect(hubServer);
//                Message.send(target, "commands.finish.messages.target.msg");
//                player.connect(hubServer);
//                Message.send(player, "commands.finish.messages.player.msg");
//                staffersTargets.remove(player.getUniqueId());
//            } catch (Exception error) {
//                error.printStackTrace();
//            }
//        } else {
//            Message.send(sender, "commands.console-perform-error");
//        }
//    }
//}
//