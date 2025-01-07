package com.therohitsahu.Selenium_Task;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task_1_7Jan_File_Upload {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify file upload functionality")
    @Test
    public void test_fileUpload() throws InterruptedException {
        // Navigate to the file upload page
        driver.get("https://the-internet.herokuapp.com/upload");

        // Locate the file
        WebElement uploadFile = driver.findElement(By.id("file-upload"));

        //Get the current working directory
        String workingDir = System.getProperty("user.dir");
        System.out.println("Current working directory: " + workingDir);

        String filePath = workingDir + "/src/test/java/com/therohitsahu/Selenium_Task/Rohit.txt";
        uploadFile.sendKeys(filePath);

        // Upload button click
        driver.findElement(By.id("file-submit")).click();

        //Verify the upload file
        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        String expectedFile = "Rohit.txt";
        if (uploadedFile.getText().equals(expectedFile)) {
            System.out.println("File uploaded successfully and verified!");
        } else {
            System.out.println("File upload verification failed!");
        }


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


