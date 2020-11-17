package com.testscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable4 {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("file:///C:/Users/manda/Desktop/My%20Webpage/webtable.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		int r = driver.findElements(By.xpath("//html//body/table/tbody/tr")).size();
		System.out.println("The no. of rows are: " + r);
		
		int c = driver.findElements(By.xpath("//html//body/table/tbody/tr/th")).size();
		System.out.println("The no. of columns are: "+c);
		
		WebElement ele1 = driver.findElement(By.xpath("//html/body/table/tbody/tr[3]/td[3]"));
		System.out.println("The cell value is: "+ele1.getText());
		
		for (int i=2; i<=r; i++) {
			for (int j=1; j<=c; j++) {
				System.out.print(driver.findElement(By.xpath("//html/body/table/tbody/tr["+i+"]/td["+j+"]")).getText()+" "+" ");
			}
			System.out.println();
		}
		
	}
}
