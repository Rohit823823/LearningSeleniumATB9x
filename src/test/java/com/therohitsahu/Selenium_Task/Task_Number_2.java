package com.therohitsahu.Selenium_Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.annotations.Test;
import org.testng.Assert;



public class Task_Number_2 {

    @Test
    public void test_idrive360_login() throws Exception {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.idrive360.com/enterprise/login");

        // Wait for the element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement email_id_inputbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));

        email_id_inputbox.sendKeys("augtest_040823@idrive.com");

        // Locate and enter the password
        WebElement passwordInputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        passwordInputBox.sendKeys("123456");

        // Locate and click the login button
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginButton.click();

        // Wait for the free trial message
        WebElement freeTrialMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Your free trial has expired')]")));

        // Verify if the free trial message is displayed
        Assert.assertTrue(freeTrialMessage.isDisplayed(), "Free trial message is NOT visible.");
        System.out.println("Free trial message is visible: " + freeTrialMessage.getText());

        driver.quit(); // Close the browser
    }
}
