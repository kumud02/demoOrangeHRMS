package config;

public class PropertyReader {

    public static String getEnvOrJvmProperty(String envVarName, String jvmVarName) {
        String value = getEnvOrJvmPropertyWithoutAssert(envVarName, jvmVarName);
        return value;
    }

    public static String getEnvOrJvmOrFileProperty(String envVarName, String jvmVarName, String fileVarName) {
        String value = getEnvOrJvmPropertyWithoutAssert(envVarName, jvmVarName);
        if (value == null) {
            value = PropertyFileReader.getProperty(fileVarName);
        }
        return value;
    }

    private static String getEnvOrJvmPropertyWithoutAssert(String envVarName, String jvmVarName) {
        String jvmVarValue = System.getProperty(jvmVarName);
        if (jvmVarValue != null) {
            return jvmVarValue;
        }
        String envVarValue = System.getenv(envVarName);
        if (envVarValue != null) {
            return envVarValue;
        }
        return null;
    }
}
