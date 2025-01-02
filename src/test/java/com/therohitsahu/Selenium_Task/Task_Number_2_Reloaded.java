package com.therohitsahu.Selenium_Task;

import io.qameta.allure.Description;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_Number_2_Reloaded {

    @Description("Verify that Free trial expire message in idrve.com")
    @Test
    public void text_verify_expire_message () {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.idrive360.com/enterprise/login");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 1. Verify the email-id and enter it
        // <input
        // _ngcontent-kdw-c4=""
        // autofocus=""
        // class="id-form-ctrl ng-pristine ng-valid ng-touched"
        // id="username"
        // name="username"
        // type="email"
        // > -----> Tag Closed

        //WebElement username_input_id = driver.findElement(By.xpath("//input[@id='username']"));
        //WebElement username_input_id = driver.findElement(By.cssSelector("input[id='username']"));
        WebElement username_input_id = driver.findElement(By.id("username"));
        username_input_id.sendKeys("augtest_040823@idrive.com");

        // 2. Verify the password and enter it
        //<input
        // _ngcontent-kdw-c4=""
        // class="id-form-ctrl ng-untouched ng-pristine ng-valid"
        // id="password"
        // maxlength="20"
        // name="password"
        // tabindex="0"
        // type="password"
        // >  -----> Closed HTML Tag
        WebElement password_input_id = driver.findElement(By.xpath("//input[@id='password']"));
        //WebElement password_input_id = driver.findElement(By.cssSelector("input[id='password']"));
        password_input_id.sendKeys("123456");


        // 3. Click on the Remember me checkbox
        //<span
        // _ngcontent-kdw-c4=""
        // class="id-checkmark"
        // tabindex="-1"
        // >  ----> Tag closed
        WebElement checkbox_tick = driver.findElement(By.xpath("//span[@class='id-checkmark']"));
        //WebElement checkbox_tick = driver.findElement(By.cssSelector("span[class='id-checkmark']"));
        checkbox_tick.click();

        // 4. Click on the signin button
        //<button
        // _ngcontent-kdw-c4=""
        // class="id-btn id-info-btn-frm"
        // id="frm-btn"
        // type="submit"
        // >  ----> Tag Closed
        WebElement signin_button_click = driver.findElement(By.xpath("//button[@id='frm-btn']"));
        //WebElement signin_button_click = driver.findElement(By.cssSelector("button[id='frm-btn']"));
        signin_button_click.click();

        try {
            Thread.sleep(50000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        // 5. Verify the expiry message is displayed or not
        //<h5
        // _ngcontent-wdb-c10=""
        // class="id-card-title"
        // >   ---> Tag closed
        //WebElement free_trial_message = driver.findElement(By.xpath("//h5[@class='id-card-title']"));
        //WebElement free_trial_message = driver.findElement(By.cssSelector("h5[class='id-card-tittle']"));
        WebElement free_trial_message = driver.findElement(By.className("id-card-title"));
        Assert.assertEquals(free_trial_message.getText(),"Your free trial has expired");

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        driver.quit();









        }
    }


