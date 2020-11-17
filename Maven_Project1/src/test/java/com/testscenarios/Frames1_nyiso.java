package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames1_nyiso {
	
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  
	  driver.get("http://mis.nyiso.com/public/");
	  driver.manage().window().maximize();
	  Thread.sleep(6000);
	  //count total no. of frames
	  int total_frames = driver.findElements(By.tagName("frame")).size();
	  System.out.println("The total number of frames in the page are "+total_frames);
	  
	  //switch to frame 1
	  driver.switchTo().frame("MENU");
	  Thread.sleep(6000);
	  driver.findElement(By.xpath("//*[@name='P-24Alist']")).click();
	  Thread.sleep(8000);
	  //switch to default page
	  driver.switchTo().defaultContent();
	  Thread.sleep(6000);
	  //switch to frame2
	  driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BODY']")));
	  Thread.sleep(6000);
	  String content = driver.findElement(By.xpath("/html/body/table/tbody/tr[8]/td[2]/span")).getText();
	  System.out.println(content);
	  
	  driver.quit();
	  
//	  WebElement content2  = driver.findElement(By.xpath("/html/body/table/tbody/tr[278]/td[2]"));
//	  Thread.sleep(6000);
//	  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", content2);
//	  Thread.sleep(6000);
//	  String stringcontent=content2.getText();
//	  System.out.println(stringcontent);
  }
}
