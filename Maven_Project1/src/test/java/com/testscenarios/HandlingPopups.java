package com.testscenarios;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingPopups {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		
		Thread.sleep(3000);

		String parent = driver.getWindowHandle();
		System.out.println(parent);

		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		System.out.println("The no. of windows are : " + allWindows.size());

		for (String child : allWindows) {

			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				System.out.println("Child window title is "+driver.getTitle());
				driver.close();
			}
		}
		
		driver.switchTo().window(parent);
		Thread.sleep(2000);
		driver.findElement(By.name("keyword")).sendKeys("Testing");
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		Thread.sleep(3000);
	}
}
