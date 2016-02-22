package com.realaicy.tna.modules.core.test.data;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by realaicy on 2016/2/22.
 */
public class TCWatcher implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("\n[Test Case starting] " + context.getName() + "\n");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("\n[Test Case finished] " + context.getName() + "\n");
    }
}
