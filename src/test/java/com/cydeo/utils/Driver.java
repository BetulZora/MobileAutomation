package com.cydeo.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Driver {

    private static AppiumDriver<MobileElement> driver;
    private static URL url;

    private Driver(){}

    public static AppiumDriver<MobileElement> getDriver(){

        String platform = ConfigurationReader.getProperty("platform");
        if(Objects.isNull(driver)){
            DesiredCapabilities caps;
            switch (platform){
                case "android":
                    caps = new DesiredCapabilities();
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
                    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
                    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3");
                    caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");

                    try{
                        url = new URL("http://localhost:4723/wd/hub");

                    } catch(MalformedURLException e){
                        e.printStackTrace();
                    }
                    driver = new AndroidDriver<MobileElement>(url,caps);
                    break;
                case "android-remote":
                    caps = new DesiredCapabilities();
                    //set credentials
                    caps.setCapability("browswerstack.user", "testuser_1phU8f");
                    caps.setCapability("browserstack.key", "qxU7LUK78o8BK1ki799f");

                    //set url of the aut (application under test)
                    caps.setCapability("app", "bs://e0ce6dfd61f8f7d9fd9c4fb11c74b65fd1d79f1");

                    //set device and os version for testing
                    caps.setCapability("device", "OnePlus 8");
                    caps.setCapability("os_version", "10.0");
                    caps.setCapability("realMobile", "true");

                    //set other BrowserStack features
                    caps.setCapability("project", "My test appium automation");
                    caps.setCapability("build", "Java Android");
                    caps.setCapability("name", "Regression");

                    //Initialize the remote WedDriver using BrowserStack remote URL
                    // and desired capabilities

                    try{
                        url = new URL("http://hub.browserstack.com/wd/hub");

                    } catch(MalformedURLException e){
                        e.printStackTrace();
                    }
                    driver = new AndroidDriver<MobileElement>(url,caps);
                    break;
            }

        }
        return driver;


    }

    public static void  closeDriver(){
        if(Objects.nonNull(driver)){
            driver.closeApp();
            driver=null;
        }
    }


}
