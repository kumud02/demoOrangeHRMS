package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    public static SelenideElement inputUserName(){ return $(By.name("txtUsername")); }
    public static SelenideElement inputPassword(){ return $(By.name("txtPassword")); }
    public static SelenideElement btnLogIn(){ return $x("//button[@type='submit']"); }

}
