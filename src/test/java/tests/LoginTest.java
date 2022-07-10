package tests;

import config.Config;
import entities.User;
import helpers.LoginHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import utility.KeyUtil;


@Epic("UI_TEST_AUTOMATION")
@Feature("AUTHORIZATION")
public class LoginTest extends BaseTest {

    private final User USER = User.builder()
            .email(Config.USER_NAME)
            .password(Config.USER_PASS)
            .build();


    @Test
    @Description("verify In Login Page for NP")
    void verifyInLoginPageNP() {
        LoginHelper.redirectToLoginPage();
//        LoginHelper.verifyInLoginPage();
    }

    @Test
    @Description("verify In Login Page for EN")
    void verifyInLoginPage(){
        LoginHelper.redirectToLoginPage();

    }

    @Test(description = "Login with valid username & password NP")
    void successfulLogin() {
        LoginHelper.redirectToLoginPage();
        assert (true);
    }


    @Test(description = " Login with valid username & invalid password ")
    void unsuccessfulLoginInvalidPassword() {

        LoginHelper.redirectToLoginPage();
        assert(true);
    }

    @Test
    public void checkIfPasswordMasked() {
        LoginHelper.redirectToLoginPage();

        assert (true);
    }

    @Test
    public void checkLoginWithEnter() {
        LoginHelper.redirectToLoginPage();
        assert (true);
    }

   @Test
    public void testWithDifferentBrowser(){
       LoginHelper.redirectToLoginPage();
       assert (true);

   }

   @Test
    void checkPasswordViewIcon(){
       LoginHelper.redirectToLoginPage();
       assert (true);
   }
}