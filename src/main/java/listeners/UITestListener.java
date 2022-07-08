package listeners;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;
import utility.ScreenshotHelper;

import java.lang.annotation.Annotation;

public class UITestListener extends ExitCodeListener {
    public UITestListener() {
    }

    public void onTestStart(ITestResult iTestResult) {
        setCurrentTestName(iTestResult);
        System.out.println("Test [" + iTestResult.getMethod().getMethodName() + "] has been started.");
    }

    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        ScreenshotHelper.allureAttachScreenshot();
        WebDriverRunner.closeWebDriver();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        super.onTestFailedButWithinSuccessPercentage(result);
        ScreenshotHelper.allureAttachScreenshot();
        WebDriverRunner.closeWebDriver();
    }

    public void onTestSuccess(ITestResult result) {
        super.onTestSuccess(result);
        ScreenshotHelper.allureAttachScreenshot();
        WebDriverRunner.closeWebDriver();
    }

    public void onConfigurationFailure(ITestResult result) {
        super.onConfigurationFailure(result);
        ScreenshotHelper.allureAttachScreenshot();
        WebDriverRunner.closeWebDriver();
    }

    public void setCurrentTestName(ITestResult iTestResult) {
        Annotation annotation = iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestId.class);
        if (annotation != null) {
            TestId test = (TestId) annotation;
            //DataGeneratorUtil.setTestId(test.id());
        }
    }
}
