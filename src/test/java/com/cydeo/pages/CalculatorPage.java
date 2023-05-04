package com.cydeo.pages;

import com.cydeo.utils.Driver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {
    public CalculatorPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this );
    }


    @AndroidFindBy (accessibility = "plus")
    public MobileElement plusSign;
    @AndroidFindBy (accessibility = "divide")
    public MobileElement divideSign;
    @AndroidFindBy (accessibility = "multiply")
    public MobileElement multiplySign;
    @AndroidFindBy (accessibility = "equals")
    public MobileElement equalSign;

    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.TextView")
    public MobileElement resultScreen;

    @AndroidFindBy (id = "com.google.android.calculator:id/result_preview")
    public MobileElement resultPreview;



    /* use the clickSingleDigit Method instead -- > it is cleaner code to do so
    @AndroidFindBy (id = "com.google.android.calculator:id/digit_0")
    public MobileElement num0;
    @AndroidFindBy (id = "com.google.android.calculator:id/digit_1")
    public MobileElement num1;
    @AndroidFindBy (id = "com.google.android.calculator:id/digit_2")
    public MobileElement num2;
    @AndroidFindBy (id = "com.google.android.calculator:id/digit_3")
    public MobileElement num3;
    @AndroidFindBy (id = "com.google.android.calculator:id/digit_4")
    public MobileElement num4;
    @AndroidFindBy (id = "com.google.android.calculator:id/digit_5")
    public MobileElement num5;
    @AndroidFindBy (id = "com.google.android.calculator:id/digit_6")
    public MobileElement num6;
    @AndroidFindBy (id = "com.google.android.calculator:id/digit_7")
    public MobileElement num7;
    @AndroidFindBy (id = "com.google.android.calculator:id/digit_8")
    public MobileElement num8;
    @AndroidFindBy (id = "com.google.android.calculator:id/digit_9")
    public MobileElement num9;
*/

    public void clickSingleDigit(int digit){

        String IDlocator = "com.google.android.calculator:id/digit_"+digit;

        MobileElement number = Driver.getDriver().findElement(MobileBy.id(IDlocator));
        number.click();


    }









}
