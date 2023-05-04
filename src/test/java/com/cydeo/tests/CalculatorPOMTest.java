package com.cydeo.tests;

import com.cydeo.pages.CalculatorPage;
import com.cydeo.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class CalculatorPOMTest {
    CalculatorPage calculator = new CalculatorPage();

    @Test
    public void multiplyTest(){

        int a = 1;
        int b = 3;

        calculator.clickSingleDigit(a);
        //calculator.clickSingleDigit(2);
        calculator.multiplySign.click();
        calculator.clickSingleDigit(b);
        calculator.equalSign.click();

        String answer = calculator.resultScreen.getText();

        System.out.println("answer = " + answer);

        assertEquals(a*b , Integer.parseInt(answer));
    }
    @AfterEach
    public void cleanUp() throws InterruptedException {

        Thread.sleep(2000);
        Driver.getDriver().closeApp();

    }
}
