package config;



import utility.ResourceHelper;

import java.util.Properties;


public class PropertyFileReader {

    public static Properties properties;

    public PropertyFileReader() {
        initPropertyReader();
    }

    public static String getProperty(String property) {
        return initPropertyReader().getProperty(property);
    }

    public static String getProperty(String property, String environment) {
        return initPropertyReader().getProperty(property).replace("{env}", environment);
    }

    private static Properties initPropertyReader() {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(ResourceHelper.getResourcePathInputStream("config.properties"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

}
