package tests;

import config.Config;
import io.qameta.allure.selenide.AllureSelenide;
import listeners.UITestListener;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({ UITestListener.class})
public class BaseTest {

    private static final ThreadLocal<AllureSelenide> ALLURE_SELENIDE_LISTENER = ThreadLocal.withInitial(AllureSelenide::new);

    @BeforeSuite(alwaysRun = true)
    public void suiteSetUp() {
        Config.suiteSetupForBrowser("chrome");

    }



    public static void turnOnAllureSelenideLogs() {
        ALLURE_SELENIDE_LISTENER.get().includeSelenideSteps(true);
    }

    public static void turnOffAllureSelenideLogs() {
        ALLURE_SELENIDE_LISTENER.get().includeSelenideSteps(false);
    }




}
