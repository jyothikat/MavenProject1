package com.testscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames1_Toyota {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.toyota.co.uk/order-a-brochure");
		driver.manage().window().maximize();
		Thread.sleep(6000);

		driver.findElement(By.linkText("Yes, I agree")).click();
		Thread.sleep(6000);
		
//		List <WebElement> framecount = driver.findElements(By.tagName("iframe"));
//		System.out.println("The total number of frames in the page are "+framecount.size());
		
		int iframecount = driver.findElements(By.tagName("iframe")).size();
		System.out.println("The total number of frames in the page are "+iframecount);

//	 	driver.switchTo().frame(1);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"iFrame\"]/article/div/iframe")));
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[text()='Download']")).click();
		Thread.sleep(6000);

	}
}
