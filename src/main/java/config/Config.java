package config;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

public class Config {

    private static final ThreadLocal<AllureSelenide> ALLURE_SELENIDE_LISTENER = ThreadLocal.withInitial(AllureSelenide::new);


    public static final String ENVIRONMENT = PropertyReader.getEnvOrJvmOrFileProperty("KITABBAZAR_ENV", "kitabbazar.env", "kitabbazar.env");
    public static final String KITABBAZAR_APP_HOST = PropertyFileReader.getProperty("kitabbazar.app.host", ENVIRONMENT);
    public static final String USER_NAME = PropertyReader.getEnvOrJvmOrFileProperty("KITABBAZAR_USER_NAME","kitabbazar.user.name", "kitabbazar.user.name");
    public static final String USER_PASS = PropertyReader.getEnvOrJvmOrFileProperty("KITABBAZAR_PASS","kitabbazar.user.pass", "kitabbazar.user.pass");


    public static void suiteSetupForBrowser(String browser) {

        Configuration.browser = browser;
//        Configuration.remote = "http://localhost:4444/";
        Configuration.timeout = 30000;
        Configuration.headless = false;
        Configuration.browserSize = "1024x768";
        SelenideLogger.addListener("AllureSelenide", ALLURE_SELENIDE_LISTENER.get());
//        WebDriverRunner.getWebDriver().manage().window().maximize();

    }

}
