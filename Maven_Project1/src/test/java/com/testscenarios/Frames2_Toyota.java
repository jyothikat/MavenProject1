package com.testscenarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;


public class Frames2_Toyota extends StaticVariables {
	
CommonFunctions cfn = new CommonFunctions();
Locators obj = new Locators();
	
	@Test
  public void f() throws InterruptedException, IOException {
		
		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);
		
		cfn.chromeBrowserLaunch();
			
		driver.get(prop.getProperty("Toyota"));
		driver.manage().window().maximize();
		Thread.sleep(6000);
		
		driver.findElement(By.linkText("Yes, I agree")).click();
		Thread.sleep(6000);
		
		//count number of iframes using tag "iframe"
//		 int total_frames = driver.findElements(By.tagName("iframe")).size();
//		 System.out.println("The total number of frames in the page are "+total_frames);
		
//		List <WebElement> totalframes = driver.findElements(By.tagName("iframe"));
//		System.out.println("The total number of iframes in the page are "+totalframes.size());
		
		//count no. of iframes using javascriptexecutor
//		JavascriptExecutor exe = (JavascriptExecutor) driver;
//		 Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
//		 System.out.println("Number of iframes on the page are " + numberOfFrames);
		
		cfn.loopAllFramesAndReturnCountofElement(obj.DOWNLOAD_BUTTON);
		Thread.sleep(6000);
		cfn.clickByAnyLocator(obj.DOWNLOAD_BUTTON);
		System.out.println("Download button selected succesfully");
		 
//		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"iFrame\"]/article/div/iframe")));
//		Thread.sleep(6000);
//		driver.findElement(By.xpath("//div[contains(text(),'Download')]")).click();
//		System.out.println("Download option selected successfully");

			  
  }
}
