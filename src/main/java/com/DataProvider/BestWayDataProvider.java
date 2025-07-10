package com.DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilites.RealExcel;

public class BestWayDataProvider {
	
@Test(dataProvider = "orangeHrmLogin",dataProviderClass = RealExcel.class)
	public void orangeHrmLoginPage(String username,String password) throws InterruptedException {
	 WebDriver driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
     driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
     driver.findElement(By.name("username")).sendKeys(username);
     driver.findElement(By.name("password")).sendKeys(password);
     driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
     Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-name")).isDisplayed());
     Thread.sleep(5000);
     driver.close();
	}
}
