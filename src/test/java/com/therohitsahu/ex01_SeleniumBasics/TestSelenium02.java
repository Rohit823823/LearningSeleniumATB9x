package com.therohitsahu.ex01_SeleniumBasics;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium02 {
    @Description("Open the the testingacademy.com and get the title")
    @Test
    public void test_Selenium02() {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://www.sdet.live.com");
        System.out.println(driver.getTitle());
    }
}
