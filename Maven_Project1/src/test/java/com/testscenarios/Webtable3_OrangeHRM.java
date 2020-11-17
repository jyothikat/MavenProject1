package com.testscenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable3_OrangeHRM {

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
		Thread.sleep(6000);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		Thread.sleep(6000);
//	 
		int r = driver.findElements(By.xpath("//table[@id = 'resultTable']/tbody/tr")).size();
		System.out.println("The number of rows in the table are " + r);

		int c = driver.findElements(By.xpath("//table[@id = 'resultTable']/thead/tr/th")).size();
		System.out.println("The number of columns in the table are " + c);

		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				System.out.print(
						driver.findElement(By.xpath("//table[@id = 'resultTable']/tbody/tr[" + i + "]/td[" + j + "]"))
								.getText() + "      " + "      ");
			}
			System.out.println();
		}

	}
}
