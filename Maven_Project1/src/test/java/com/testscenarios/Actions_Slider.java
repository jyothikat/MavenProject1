package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions_Slider {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://jqueryui.com/slider/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.switchTo().frame(0);
		Thread.sleep(2000);

		Actions action = new Actions(driver);

		WebElement slider = driver.findElement(By.id("slider"));
//		action.moveToElement(slider).dragAndDropBy(slider, 300, 0).build().perform();
//		Thread.sleep(3000);
//		driver.quit();

		action.dragAndDropBy(slider, 300, 0).build().perform();
		Thread.sleep(3000);
		driver.quit();

	}
	
	@Test
	public void testcase2() throws InterruptedException {
	
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Slider.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/a"));
		act.dragAndDropBy(slider, 300, 0).build().perform();
		Thread.sleep(3000);
		driver.quit();
	}
	

}
