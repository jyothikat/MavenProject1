package com.testscenarios;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rediff_Register {
	
	WebDriver driver;
	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.rediff.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
		driver.findElement(By.linkText("Create Account")).click();
		Thread.sleep(6000);

		driver.findElement(By.xpath("//input[starts-with(@name, 'name')]")).sendKeys("Jyothi K");
			
		driver.findElement(By.xpath("//input[contains(@name, 'login')]")).sendKeys("jyothi00989");

		driver.findElement(By.xpath("//input[@value='Check availability']")).click();
		
		Thread.sleep(6000);

		String message = driver
				.findElement(By.xpath(
						"/html[1]/body[1]/center[1]/form[1]/div[1]/table[2]/tbody[1]/tr[5]/td[3]/div[1]/font[1]/b[1]"))
				.getText();

		if (message.equalsIgnoreCase("Yippie! The ID you've chosen is available.")) {

			driver.findElement(By.xpath("//input[starts-with(@name, 'pass')]")).sendKeys("Testing@1");
			driver.findElement(By.xpath("//input[starts-with(@name, 'confirm')]")).sendKeys("Testing@1");
			driver.findElement(By.xpath("//*[starts-with(@name, 'alte')]")).sendKeys("mipgtestuser@gmail.com");
			driver.findElement(By.xpath("//*[starts-with(@name, 'mobno')]")).sendKeys("1112223333");
			Thread.sleep(6000);

			WebElement day_element = driver.findElement(By.xpath("//select[starts-with(@name, 'DOB_Day')]"));
			Select day = new Select(day_element);
			day.selectByVisibleText("18");

			WebElement month_element = driver.findElement(By.xpath("//select[starts-with(@name, 'DOB_Month')]"));
			Select month = new Select(month_element);
			month.selectByValue("11");

			WebElement year_element = driver.findElement(By.xpath("//select[starts-with(@name, 'DOB_Year')]"));
			Select year = new Select(year_element);
			year.selectByIndex(19);

			driver.findElement(By.xpath("(//*[starts-with(@name, 'gender')])[2]")).click();
			Thread.sleep(6000);

			WebElement element = driver.findElement(By.id("country"));
			Select country = new Select(element);
			country.selectByValue("222");

			Thread.sleep(10000);

			// Manually enter the captcha in the console
			// System will take the entered input from the console using scanner
			System.out.println("Please enter the captcha value");
			Thread.sleep(6000);
			Scanner s = new Scanner(System.in);
			String captchastring = s.next();
			s.close();

			// enter captcha
			driver.findElement(By.xpath("//input[@class='captcha']")).sendKeys(captchastring);
			Thread.sleep(5000);

			driver.findElement(By.id("Register")).click();
		}

		else {
			System.out.println("The user name is already taken. Please pick a different userid");
		}
	}
}
