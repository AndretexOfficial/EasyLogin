package space.andretex.Utils;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import space.andretex.Main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class Config {
    private File file;
    private Configuration config;
    private final Main ss = Main.getInstance();

    public Config() {
        loadConfig();
    }

    public Configuration getConfig() {
        return config;
    }

    private void loadConfig() {
        ConfigurationProvider configurationProvider = ConfigurationProvider.getProvider(YamlConfiguration.class);

        if (!ss.getDataFolder().exists()) {
            ss.getDataFolder().mkdir();
        }

        file = new File(ss.getDataFolder(), "config.yml");

        if (!file.exists()) {
            try (InputStream in = ss.getResourceAsStream("config.yml")) {
                Files.copy(in, file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            config = configurationProvider.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
