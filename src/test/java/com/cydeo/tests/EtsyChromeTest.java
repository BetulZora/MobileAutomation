package com.cydeo.tests;

import com.cydeo.utils.ConfigurationReader;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class EtsyChromeTest extends WebTestBase{

    @Test
    public void etsySearchTest() throws InterruptedException {

        driver.get("https://www.etsy.com");
        Thread.sleep(3000);
        WebElement searchField = driver.findElement(By.name("search_query"));
        searchField.sendKeys("Wooden Spoon"+ Keys.ENTER);
        Thread.sleep(3000);
        //print number of search results
        WebElement numResults =driver.findElement(By.cssSelector("span[class='wt-display-inline']>span"));
        System.out.println("numResults.getText() = " + numResults.getText());

    }

    @Test
    public void openYouTube() throws InterruptedException {
        driver.get("https://www.youtube.com");
        Thread.sleep(3000);
        WebElement explore = driver.findElement(By.cssSelector("span[class='typography-title-1 chip-text']"));
        explore.click();
        Thread.sleep(10000);

    }

    @Test
    public void loginTest() throws InterruptedException {
        String email = ConfigurationReader.getProperty("email");
        String password = ConfigurationReader.getProperty("password");
        driver.get("https://www.etsy.com");
        WebElement loginIcon = driver.findElement(By.cssSelector("a[class='wt-btn wt-btn--small wt-btn--transparent wt-btn--icon wt-btn--transparent-flush-right']"));
        loginIcon.click();
        WebElement emailBox = driver.findElement(By.id("join_neu_email_field"));
        emailBox.sendKeys(email+Keys.ENTER);
        Thread.sleep(1000);
        WebElement passwordBox = driver.findElement(By.id("join_neu_password_field"));
        passwordBox.sendKeys(password+Keys.ENTER);
        Thread.sleep(5000);



    }



}
