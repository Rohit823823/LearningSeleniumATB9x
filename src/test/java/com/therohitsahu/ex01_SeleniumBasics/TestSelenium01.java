package com.therohitsahu.ex01_SeleniumBasics;

import io.qameta.allure.Description;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSelenium01 {
    @Description("Open the app.VWO.com and get the title")
    @Test
    public void test_Selenium01() {

        // Open a URL
        // Print the Tittle
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());

    }
}
