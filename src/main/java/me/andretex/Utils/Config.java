package me.andretex.Utils;

import me.andretex.Main;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Config {
    private File file;
    private Configuration config;
    private final Main main = Main.getInstance();

    public Config() {
        this.loadConfig();
    }

    public Configuration getConfig() {
        return this.config;
    }

    private void loadConfig() {
        ConfigurationProvider configurationProvider = ConfigurationProvider.getProvider(YamlConfiguration.class);
        if (!this.main.getDataFolder().exists()) {
            this.main.getDataFolder().mkdir();
        }

        this.file = new File(this.main.getDataFolder(), "config.yml");
        if (!this.file.exists()) {
            try {
                InputStream in = this.main.getResourceAsStream("config.yml");
                Throwable var3 = null;

                try {
                    Files.copy(in, this.file.toPath(), new CopyOption[0]);
                } catch (Throwable var15) {
                    var3 = var15;
                    throw var15;
                } finally {
                    if (in != null) {
                        if (var3 != null) {
                            try {
                                in.close();
                            } catch (Throwable var14) {
                                var3.addSuppressed(var14);
                            }
                        } else {
                            in.close();
                        }
                    }

                }
            } catch (IOException var17) {
                var17.printStackTrace();
            }
        }

        try {
            this.config = configurationProvider.load(this.file);
        } catch (IOException var13) {
            var13.printStackTrace();
        }

    }
}
