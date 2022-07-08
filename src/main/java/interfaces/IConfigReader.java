package interfaces;

public interface IConfigReader {
    public String getWebsite();
    public int getPageLoadTimeOut();
    public int getImplicitWait();
    public int getExplicitWait();
    public String getWaitTime();
    public String getExecutionEnv();
    public String getRemoteExecutionEnvURL();
    public String getImageDataFolderPath();
}
