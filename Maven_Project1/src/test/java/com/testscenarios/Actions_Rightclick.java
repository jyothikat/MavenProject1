package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions_Rightclick {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		Actions actions = new Actions(driver);
		WebElement rclick = driver.findElement(By.xpath("//span[text()='right click me']"));
		WebElement copy = driver.findElement(By.xpath("//span[text()='Copy']"));
		actions.contextClick(rclick).click(copy).build().perform();

		Thread.sleep(4000);
		String str = driver.switchTo().alert().getText();
		System.out.println("Alert text is: " + str);
		driver.switchTo().alert().accept();
		driver.quit();
	}
	
	@Test
	public void rightclick() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://retail.onlinesbi.com/retail/login.htm");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		WebElement ele = driver.findElement(By.xpath("(//a[text()='CONTINUE TO LOGIN'])[1]"));
		Actions action = new Actions(driver);
		action.contextClick(ele).build().perform();
		Thread.sleep(4000);
		System.out.println("Alert text is: "+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.quit();
	}
}
