package utility;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Report {
    static Report report;

    public static void log(Status status, String message) {
        Allure.step(message, status);
    }

    public static Report getInstance() {
        if (report == null)
            report = new Report();
        return report;
    }

    public static void logScreenshot(String message) {
        InputStream stream = new ByteArrayInputStream(((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES));
        Allure.addAttachment(message, stream);
    }

    public static void logFailScreenshot(Status status, String message) {
        InputStream stream = new ByteArrayInputStream(((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES));
        Allure.addAttachment(message, stream);
    }

    public static void logPassScreenshot(String message) {
        InputStream stream = new ByteArrayInputStream(((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES));
        Allure.addAttachment(message, stream);
    }

}
