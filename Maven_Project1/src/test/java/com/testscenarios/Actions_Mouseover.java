package com.testscenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions_Mouseover {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);

		Actions actions = new Actions(driver);

		WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement usermgmt = driver.findElement(By.id("menu_admin_UserManagement"));
		WebElement users = driver.findElement(By.id("menu_admin_viewSystemUsers"));

		// Move to different elements using multiple lines of code
//		actions.moveToElement(admin).build().perform();
//		Thread.sleep(6000);
//		actions.moveToElement(usermgmt).build().perform();
//		Thread.sleep(6000);
//		actions.moveToElement(users).click().build().perform();
//		Thread.sleep(6000);

		// Move to different elements using single line of code
		actions.moveToElement(admin).moveToElement(usermgmt).moveToElement(users).click(users).build().perform();
		Thread.sleep(3000);
		driver.quit();
		
	}

	@Test
	public void mouseover() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://retail.onlinesbi.com/retail/login.htm");
		driver.manage().window().maximize();
		Thread.sleep(6000);
		
		WebElement ele = driver.findElement(By.xpath("//a[@title='SBI Home Loan ']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		Thread.sleep(5000);
		System.out.println("Mouse over text is "+ele.getAttribute("title"));
		driver.quit();
		
	}

}
