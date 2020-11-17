package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop_Sample1 {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		
		WebElement dragElement1 = driver.findElement(By.xpath("//a[contains(text(),'BANK')]"));
		WebElement dropElement1 = driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
//		action.dragAndDrop(dragElement1, dropElement1).build().perform();
//		Thread.sleep(2000);
//		action.clickAndHold(dragElement1).moveToElement(dropElement1).release().build().perform();
		
		WebElement dragElement2 = driver.findElement(By.xpath("(//a[@class='button button-orange'][contains(.,'5000')])[2]"));
		WebElement dropElement2 = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/ol[1]/li[1]"));
//		action.dragAndDrop(dragElement2, dropElement2).build().perform();
//		Thread.sleep(2000);
		
		WebElement dragElement3 = driver.findElement(By.xpath("//a[contains(text(),'SALES')]"));
		WebElement dropElement3 = driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
//		action.dragAndDrop(dragElement3, dropElement3).build().perform();
//		Thread.sleep(3000);
		
		WebElement dragElement4 = driver.findElement(By.xpath("(//a[@class='button button-orange'][contains(.,'5000')])[4]"));
		WebElement dropElement4 = driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));
//		action.dragAndDrop(dragElement4, dropElement4).build().perform();
//		Thread.sleep(3000);
			
		action.dragAndDrop(dragElement1, dropElement1).dragAndDrop(dragElement2, dropElement2).dragAndDrop(dragElement3, dropElement3).dragAndDrop(dragElement4, dropElement4).build().perform();
		Thread.sleep(4000);
	}
}
