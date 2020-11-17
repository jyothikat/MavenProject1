package com.testscenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown1_Sample2 extends StaticVariables {

	
	CommonFunctions cfn = new CommonFunctions();
	Locators obj = new Locators();

	@Test
	public void f() throws InterruptedException, IOException {

		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.linkText("Create New Account")).click();
		Thread.sleep(3000);

		// WebElement month_dropdown=driver.findElement(By.id("month"));

		cfn.selectByVisibleText(By.id("month"), "Feb");

//	  Select month_ss = new Select (month_dropdown);
//	  
//	  System.out.println(month_ss.isMultiple());
//	  
//	  month_ss.selectByVisibleText("Nov");
//	  
//	  //Print and validate the selected month
//	  WebElement selectedmonth = month_ss.getFirstSelectedOption();
//	  System.out.println("The selected month is "+selectedmonth.getText());
//	  Assert.assertEquals(selectedmonth.getText(), "Nov", "The selected month is not November, please raise a bug");
//	  Assert.assertTrue(selectedmonth.getText().equals("Nov"), "The selected month is not November");
//	  
//	  //Print the drop down size and validate the size
//	  List <WebElement> monthlist = month_ss.getOptions();
//	  System.out.println("The month dropdown list is "+monthlist.size());
//	  Assert.assertEquals(monthlist.size(), 13);
//	  
//	  //Print the drop down values using for loop
//	  for (int i=0; i<monthlist.size(); i++) {
//		  System.out.println(monthlist.get(i).getText());
//	  }

		// Print the drop down values using enhanced for loop
//	  for (WebElement webElement : monthlist) {
//		  System.out.println(webElement.getText());
//		
	}

}
