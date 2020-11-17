package com.testscenarios;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OnlineSBI_Handlingwindows {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://retail.onlinesbi.com/retail/login.htm");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='continue_btn'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Register here/Activate")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		System.out.println("The title is: "+driver.getTitle());

		String parent = driver.getWindowHandle();
		
		Set<String> allWindowIds = driver.getWindowHandles();
		System.out.println("The no. of windows are "+allWindowIds.size());

		for (String allwindows : allWindowIds) {

			if (!parent.equals(allwindows)) {
				driver.switchTo().window(allwindows);
				System.out.println("The title of child window: "+driver.getTitle());
				WebElement newuser = driver.findElement(By.xpath("//select[@title='NewUserReg']"));
				Select newuser_dd = new Select(newuser);
				newuser_dd.selectByVisibleText("Activation Of Username");
				Thread.sleep(2000);
				driver.close();
			}

		}

		driver.switchTo().window(parent);
		Thread.sleep(3000);
		System.out.println("The title of parent window: "+driver.getTitle());
		driver.findElement(By.name("userName")).sendKeys("jyokatragadda@gmail.com");
		Thread.sleep(3000);
		driver.quit();
	}
}
