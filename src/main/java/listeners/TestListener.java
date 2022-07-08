package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.annotation.Annotation;

public class TestListener implements ITestListener {

    public void onStart(ITestContext iTestContext) {
    }

    public void onTestSuccess(ITestResult iTestResult) {
    }

    public void onTestFailure(ITestResult iTestResult) {
    }

    public void onTestStart(ITestResult iTestResult) {
        setCurrentTestName(iTestResult);
        System.out.println("Test [" + iTestResult.getMethod().getMethodName() + "] has been started.");
    }

    public void setCurrentTestName(ITestResult iTestResult) {
        Annotation annotation = iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestId.class);
        if (annotation != null) {
            TestId test = (TestId) annotation;
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    public void onFinish(ITestContext iTestContext) {
    }
}