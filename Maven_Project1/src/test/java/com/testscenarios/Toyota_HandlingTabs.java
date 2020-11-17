package com.testscenarios;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Toyota_HandlingTabs {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.toyota.co.uk/");
		driver.manage().window().maximize();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//a[@id='tgbgdpr-overlay-agree']")).click();
		System.out.println("Parent window title is " + driver.getTitle());

		driver.findElement(By.xpath("//li[@data-bt-value='hybrid_innovation']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//span[@class='icon-label'][contains(.,'Quick Finance Calculator')])[4]"))
				.click();
		Thread.sleep(2000);

		String parent = driver.getWindowHandle();
		System.out.println("Parent window id is "+parent);

		Set<String> allwindowIds = driver.getWindowHandles();
		System.out.println(allwindowIds);
		
		for (String allwindows : allwindowIds) {

			if (!parent.equals(allwindows)) {
				
				driver.switchTo().window(allwindows);
				System.out.println("The child window title is " + driver.getTitle());
				WebElement choosecar = driver.findElement(By.id("codeweaversModels"));
				Select choosecar_dd = new Select(choosecar);
				choosecar_dd.selectByValue("RAV4");
				Thread.sleep(2000);
				driver.close();
			}

		}

		driver.switchTo().window(parent);
		System.out.println("The parent title is " + driver.getTitle());
	}
}
