//package space.andretex.Utils;
//
//import it.imperuscraft.ss.commands.FinishCommand;
//import it.imperuscraft.ss.commands.SSCommand;
//import it.imperuscraft.ss.utils.Config;
//import it.imperuscraft.ss.utils.Message;
//import net.md_5.bungee.api.plugin.Plugin;
//import net.md_5.bungee.config.Configuration;
//
//public final class SS extends Plugin {
//    private static SS instance;
//    public Configuration config;
//
//    @Override
//    public void onEnable() {
//        instance = this;
//        config = new Config().getConfig();
//
//        getCommands();
//
//        getLogger().info(Message.color("\n &6SS &aENABLE &r\n"));
//    }
//
//    @Override
//    public void onDisable() {
//        getLogger().info(Message.color("\n &6SS &cDISABLE &r\n"));
//    }
//
//    public void getCommands() {
//        String ssPerm = config.getString("commands.ss.permission");
//        String fnishPerm = config.getString("commands.finish.permission");
//
//        if (ssPerm != null) {
//            getProxy().getPluginManager().registerCommand(this, new SSCommand("ss", ssPerm));
//        } else {
//            getProxy().getPluginManager().registerCommand(this, new SSCommand("ss"));
//        }
//
//        if (fnishPerm != null) {
//            getProxy().getPluginManager().registerCommand(this, new FinishCommand("finish", fnishPerm));
//        } else {
//            getProxy().getPluginManager().registerCommand(this, new FinishCommand("finish"));
//        }
//    }
//
//    public static SS getInstance() {
//        return instance;
//    }
//}
//