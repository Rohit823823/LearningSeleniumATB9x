package com.therohitsahu.ex09_ActionClass;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestSelenium27_Action_Class_MakeMyTrip {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify actions")
    @Test
    public void test_actions() throws InterruptedException {
        String URL = "https://www.makemytrip.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        // Wait for the popup to come and click the x icon
        //span[@data-cy='closeModal']
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .xpath("//span[@data-cy='closeModal']")));

        driver
                .findElement(By
                        .xpath("//span[@data-cy='closeModal']"))
                .click();

        WebElement fromCity= driver.findElement(By.id("fromCity"));


       Actions actions=new Actions(driver);
        actions.moveToElement(fromCity).click().sendKeys("bbi").build().perform();




        Thread.sleep(10000);
        actions.moveToElement(fromCity).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).build().perform();








    }

    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
