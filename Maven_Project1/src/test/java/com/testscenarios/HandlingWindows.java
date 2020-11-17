package com.testscenarios;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindows {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		driver.get("http://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println("The title of the main window: "+driver.getTitle());
		
		driver.findElement(By.xpath("//a[text()='Open New Seperate Windows']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		
		Set <String> allWindows = driver.getWindowHandles();
		System.out.println("The no. of windows are: "+allWindows.size());
		System.out.println(allWindows);
		
		
		for (String child : allWindows) {
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				Thread.sleep(2000);
				System.out.println("The title of child window: "+driver.getTitle());
				driver.findElement(By.xpath("//a[text() = 'Downloads']")).click();
				Thread.sleep(2000);
				driver.close();
			}
			
		}
		
		driver.quit();

	}
}
