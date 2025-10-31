package api.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static final Properties properties = new Properties();
    private static final String DEFAULT_ENV = "qa";

    static {
        String env = System.getProperty("env", DEFAULT_ENV);

        String configFileName = "config-" + env + ".properties";
        try (InputStream inputStream = ConfigManager.class.getClassLoader().getResourceAsStream(configFileName)) {
            if (inputStream == null) {
                throw new RuntimeException("Cannot find properties file: " + configFileName);
            }
            System.out.println("ENV = " + env);
            System.out.println("Successfully leaded " + configFileName + " file");
            properties.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties file: " + configFileName, e);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("api.base.url");
    }

    public static String getApiKey() {
        return properties.getProperty("api.key");
    }

    public static String getUsersEndpoint() {
        return properties.getProperty("api.users.endpoint");
    }
}
