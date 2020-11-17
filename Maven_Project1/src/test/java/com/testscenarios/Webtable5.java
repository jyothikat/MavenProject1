package com.testscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable5 {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		List <WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println("The no. of rows are "+rows.size());
		
		List <WebElement> cells = driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
		System.out.println("The no. of columns are "+cells.size());
		
		String str = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[12]/td[4]")).getText();
		System.out.println("The current price of L & T is Rs "+str);
		
		
		System.out.println("************************************");
		
		for (int i=1; i<=10; i++) {
			for (int j=1; j<=cells.size(); j++) {
				System.out.print(driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td["+j+"]")).getText()+" || ");
			}
			System.out.println();
		}
		
		
//		for (WebElement webElement : rows) {
//			System.out.println(webElement.getText());
//			
//		}
			
	}
}
