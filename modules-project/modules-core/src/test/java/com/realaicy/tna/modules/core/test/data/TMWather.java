package com.realaicy.tna.modules.core.test.data;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * Created by realaicy on 2016/2/22.
 */
public class TMWather implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("\n[Test Method starting] " + method.getTestMethod().getMethodName() + "\n");

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("\n[Test Method finished] " + method.getTestMethod().getMethodName() + "\n");

    }
}
