package com.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParaMeterXml {

    @Parameters({"email", "password"})
    @Test
    public void logInDemoWebShop(String email, String password) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demowebshop.tricentis.com/login");

        driver.findElement(By.id("Email")).sendKeys(email); 
        driver.findElement(By.id("Password")).sendKeys(password); 
        driver.findElement(By.cssSelector(".button-1.login-button")).click();
    }
}
