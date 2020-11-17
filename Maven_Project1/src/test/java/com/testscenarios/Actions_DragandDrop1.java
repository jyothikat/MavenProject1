package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.utilities.CommonFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions_DragandDrop1 {

	WebDriver driver;
	CommonFunctions cfn = new CommonFunctions();

	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-1.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);

		Actions act = new Actions(driver);
		WebElement dragElement1 = driver.findElement(By.id("box1"));
		WebElement dragElement2 = driver.findElement(By.id("box4"));
		WebElement dropElement1 = driver.findElement(By.id("dropBox"));

		act.dragAndDrop(dragElement1, dropElement1).dragAndDrop(dragElement2, dropElement1).build().perform();
		Thread.sleep(3000);
		driver.quit();
		
	}
}
