package com.therohitsahu.Selenium_Task;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Task_Number_1 {

    @Description("Verify the url is displayed as expected after loginto katlon")
    @Test

    public void Test_url_verification() throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/#appointment");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        // <a
        // id="btn-make-appointment"
        // href="./profile.php#login"
        // class="btn btn-dark btn-lg"
        // >
        // Make Appointment
        // </a>

        WebElement Button_click = driver.findElement(By.id("btn-make-appointment"));
        Button_click.click();

        //<input
        // type="text"
        // class="form-control"
        // id="txt-username"
        // name="username"
        // placeholder="Username"
        // value=""
        // autocomplete="off"
        // >   ---> Tag Closed

        WebElement user_name = driver.findElement(By.id("txt-username"));
        user_name.sendKeys("John Doe");

        //<input
        // type="password"
        // class="form-control"
        // id="txt-password"
        // name="password"
        // placeholder="Password"
        // value=""
        // autocomplete="off"
        // >   ----> tag closed

        WebElement Login_password = driver.findElement(By.id("txt-password"));
        Login_password.sendKeys("ThisIsNotAPassword");

        Thread.sleep(3000);

        //<button
        // id="btn-login"
        // type="submit"
        // class="btn btn-default"
        // >  -----> Tag Closed

        WebElement Button_login_click = driver.findElement(By.id("btn-login"));
        Button_login_click.click();

        Thread.sleep(10000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");

        if (driver.getCurrentUrl().contains("#appointment")) {
            System.out.println("Text is displayed as expected");
            Assert.assertTrue(true);
        }
        else {
            System.out.println("Text is not displayed as expected");
        }


        driver.close();
        driver.quit();






    }
}
