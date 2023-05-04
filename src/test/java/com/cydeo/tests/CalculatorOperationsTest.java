package com.cydeo.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorOperationsTest {

    AppiumDriver<MobileElement> driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        // Need Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel3");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");

        // set URL for the appium server
        URL url = new URL("http://localhost:4723/wd/hub");


        // launch appiumDriver
        driver = new AndroidDriver<MobileElement>(url,caps);

    }

    /**
     * 4 + 5 = 9
     */
    @Test
    public void addTest() throws InterruptedException {

        // step 1: locate 4, plus, 5, equals, result
        MobileElement num5 = driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_5"));
        MobileElement num4 = driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_4"));
        //MobileElement num1 = driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_1"));
        //MobileElement num0 = driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_0"));
        //MobileElement resultScreen = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.TextView"));
        MobileElement resultPreview = driver.findElement(MobileBy.id("com.google.android.calculator:id/result_preview"));
        MobileElement plusSign = driver.findElement(MobileBy.AccessibilityId("plus"));
        MobileElement equalSign = driver.findElement(MobileBy.AccessibilityId("equals"));

        //num1.click();
        //num0.click();

        num4.click();
        plusSign.click();
        num5.click();
        //equalSign.click();

        String answer = resultPreview.getText();

        System.out.println("answer = " + answer);
        equalSign.click();


        //make sure this element is being located after you click the equalSign
        MobileElement resultScreen = driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final"));
        String answer2 = resultScreen.getText();
        System.out.println("answer2 = " + answer2);

        Thread.sleep(5000);

        assertEquals(4+5+"", answer);
        assertEquals(4+5+"", answer2);


    }

    @AfterEach
    public void cleanUp() throws InterruptedException {

        Thread.sleep(5000);
        driver.closeApp();

    }

}
