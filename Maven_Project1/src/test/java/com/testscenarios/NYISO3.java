package com.testscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NYISO3 {
	
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  
	  driver.get("http://mis.nyiso.com/public/");
	  driver.manage().window().maximize();
	  Thread.sleep(6000);
	  
//	  List <WebElement> framecount = driver.findElements(By.tagName("frame"));
//	  System.out.println("The number of frames in the page are "+framecount.size());
	  
	  int framecount2 = driver.findElements(By.tagName("frame")).size();
	  System.out.println("The number of frames in the page are "+framecount2);
	  
	  
	  driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MENU']")));
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//a[@name='P-24Alist']")).click();
	  Thread.sleep(2000);
	  
	  driver.switchTo().defaultContent();
	  
	  driver.switchTo().frame("BODY");
	  Thread.sleep(2000);
	  System.out.println(driver.findElement(By.xpath("/html/body/table/tbody/tr[8]/td[2]/span")).getText());
	  
  }
  
}
