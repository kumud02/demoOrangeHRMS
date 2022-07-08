package helpers;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.Config;
import entities.User;
import entities.common.OrangeHRMSConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import pages.LoginPage;
import tests.BaseTest;

import static com.codeborne.selenide.Condition.exactText;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginHelper {


    @Step
    @Description("Redirect to Login Page")
    public static void redirectToLoginPage() {
        Selenide.open(Config.KITABBAZAR_APP_HOST+"/login/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Step
    @Description("Fill Login form")
    public static void fillLoginForm(User user) {
        LoginPage.inputUserName().sendKeys(user.getEmail());
        BaseTest.turnOffAllureSelenideLogs();
        LoginPage.inputPassword().sendKeys(user.getPassword());
        BaseTest.turnOnAllureSelenideLogs();

    }

    @Step
    @Description("Click Login Button")
    public static void clickLoginButton() {
        LoginPage.btnLogIn().click();
    }



    @Step
    @Description("User Login the Application")
    public static void login(User user) {

        redirectToLoginPage();
        fillLoginForm(user);
        clickLoginButton();
    }

    @Step
    @Description("Check for Successful Login")
    public static void successfulLogin(User user) {
        login(user);
        checkIsLoginSuccessful();
    }

    @Step

    @Description("Check for Unsuccessful Header Content")
    public static void checkIsLoginSuccessful() {
    }

    @Step
    @Description("Check for Unsuccessful Login")
    public static void checkIsLoginUnsuccessful() {

    }



    @Step
    @Description("Verify is the password is masked")
    public static void checkIfPasswordMasked(User user) {
        fillLoginForm(user);
        assertThat(LoginPage.inputPassword().getAttribute("type")).isEqualTo("password");


    }



    @Step
    public static void checkIsLoginSuccessfulWithChrome(User user) {
        Config.suiteSetupForBrowser("chrome");
        login(user);
        checkIsLoginSuccessful();
        Selenide.closeWebDriver();
    }

    @Step
    public static void checkIsLoginSuccessfulWithFirefox(User user) {
        Config.suiteSetupForBrowser("firefox");
        login(user);
        checkIsLoginSuccessful();
        Selenide.closeWebDriver();
    }

    @Step
    public static void checkIsLoginSuccessfulWithSafari(User user) {
        Config.suiteSetupForBrowser("safari");
        login(user);
        checkIsLoginSuccessful();
        Selenide.closeWebDriver();
    }

    @Step
    public static void verifyInLoginPage() {
        LoginPage.inputPassword().isDisplayed();
        LoginPage.inputPassword().isDisplayed();
        LoginPage.btnLogIn().isDisplayed();

    }

    public static void verifyPasswordIconFunctional(String password) {

    }

}
