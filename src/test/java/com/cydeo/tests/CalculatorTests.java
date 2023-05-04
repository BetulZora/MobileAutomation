package com.cydeo.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTests {

    @Test
    public void calculatorAddTest() throws MalformedURLException, InterruptedException {

        // Need Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel3");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");

        // set URL for the appium server
        URL url = new URL("http://localhost:4723/wd/hub");


        // launch appiumDriver
        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url,caps);
        //System.out.println(driver.getTitle()); //doesn't work on Native apps
        System.out.println(driver.getDeviceTime());

        Assertions.assertEquals("android", driver.getPlatformName());

        Thread.sleep(5000);

        //locate AC element on calculator using accessibility id = clear

        MobileElement acElement = driver.findElement(MobileBy.AccessibilityId("clear"));

        System.out.println("Text of elem: " +acElement.getText());

        Assertions.assertTrue(acElement.isDisplayed());

        // close the app
        driver.closeApp();

    }

}
