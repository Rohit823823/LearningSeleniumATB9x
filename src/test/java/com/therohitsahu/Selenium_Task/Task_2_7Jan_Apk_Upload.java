package com.therohitsahu.Selenium_Task;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task_2_7Jan_Apk_Upload {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Automate APK upload and verify App ID generation")
    @Test
    public void test_browserStackAutomation() throws InterruptedException {

        // Navigate to BrowserStack App Automate Dashboard
        driver.get("https://www.browserstack.com/users/sign_in");

        WebElement emailField = driver.findElement(By.id("user_email_login"));
        emailField.sendKeys("rs457928@gmail.com");

        WebElement passwordField = driver.findElement(By.id("user_password"));
        passwordField.sendKeys("Sahubali@132");

        WebElement loginButton = driver.findElement(By.name("commit"));
        loginButton.click();

       Thread.sleep(5000);

        driver.get("https://app-automate.browserstack.com/dashboard/v2/getting-started");



        WebElement uploadApp = driver.findElement(By.xpath("//span[text()='UPLOAD APP']"));


        String filePath = "/src/test/java/com/therohitsahu/Selenium_Task/example.apk";
        uploadApp.sendKeys(filePath);

        Thread.sleep(5000);

        WebElement appId = driver.findElement(By.xpath("//div[contains(text(), 'App ID')]"));
        if (appId.isDisplayed()) {
            System.out.println("App ID generated successfully: " + appId.getText());
        } else {
            System.out.println("Failed to generate App ID!");
        }







    }
    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(3000); // Brief wait before closing the browser
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
