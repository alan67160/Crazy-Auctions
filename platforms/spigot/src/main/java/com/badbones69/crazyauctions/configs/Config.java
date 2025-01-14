package com.badbones69.crazyauctions.configs;

import com.badbones69.crazyauctions.CrazyAuctions;
import com.badbones69.crazyauctions.api.interfaces.Universal;
import net.dehya.ruby.common.annotations.FileBuilder;
import net.dehya.ruby.common.annotations.yaml.BlockType;
import net.dehya.ruby.common.annotations.yaml.Comment;
import net.dehya.ruby.common.annotations.yaml.Key;
import net.dehya.ruby.common.enums.FileType;
import net.dehya.ruby.files.FileExtension;
import net.dehya.ruby.files.FileManager;
import org.simpleyaml.configuration.file.YamlFile;
import java.io.IOException;

@FileBuilder(isLogging = true, isAsync = false, isData = false, fileType = FileType.YAML)
public class Config extends FileExtension implements Universal {

    @Key("settings.prefix")
    @Comment("The prefix used in front of messages.")
    public static String PREFIX = "&8[&bCrazyAuctions&8]: ";

    @Key("settings.locale-file")
    @Comment("The language file to use from the locale folder. Supported languages are English(en).")
    @BlockType
    public static String LOCALE_FILE = "locale-en.yml";

    @Key("settings.update-checker")
    @Comment("Whether you want to be notified when an update is published to Modrinth.")
    public static boolean UPDATE_CHECKER = true;

    @Key("settings.toggle-metrics")
    @Comment("Whether you want your server statistics to be sent to https://bstats.org/ ( Requires a restart! )")
    public static boolean TOGGLE_METRICS = true;

    @Key("settings.config-version")
    @Comment("DO NOT TOUCH THIS: We use this to identify if your configs are outdated.")
    public static double CONFIG_VERSION = 1.0;

    @Key("settings.data-storage.storage-method")
    @Comment("The only available type at the moment is JSON")
    public static String STORAGE_TYPE = "JSON";

    public Config() {
        super("config.yml");
    }

    public static void reload() {
        plugin.getSpigotFileManager().addFile(new Config());
    }

    public static YamlFile getConfiguration(FileManager fileManager) {
        try {
            return fileManager.getFileConfiguration(new Config());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}