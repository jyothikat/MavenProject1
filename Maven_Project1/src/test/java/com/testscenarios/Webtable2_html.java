package com.testscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable2_html {
	
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  
	  driver.get("file:///C:/Users/manda/Desktop/My%20Webpage/webtable.html");
	  driver.manage().window().maximize();
	  Thread.sleep(6000);
	  
	  //No. of rows in the table
//	  List <WebElement> nrows = driver.findElements(By.xpath("//html/body/table/tbody/tr"));
//	  System.out.println("The number of rows in the table are "+nrows.size());
	  
	  int r = driver.findElements(By.xpath("//html/body/table/tbody/tr")).size();
	  System.out.println("The number of rows in the table are "+r);
	  
	  //No.of columns in the table
	  int c = driver.findElements(By.xpath("//html/body/table/tbody/tr/th")).size();
	  System.out.println("The number of columns in the table are "+c);
	
	  WebElement data = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
	  System.out.println("The article code of product4 is "+data.getText());
	  
	  //Read all data from the table
	  for (int i=2; i<=r; i++) {
		  for (int j=1; j<=c; j++) {
			  System.out.print(driver.findElement(By.xpath("//html/body/table/tbody/tr["+i+"]/td["+j+"]")).getText()+" "+" ");
			  
		  }
		  System.out.println();
	  }
	  
	   }
}
