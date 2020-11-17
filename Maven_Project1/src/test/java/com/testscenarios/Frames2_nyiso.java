package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;

public class Frames2_nyiso extends StaticVariables {

	Locators obj = new Locators();
	CommonFunctions cfn = new CommonFunctions();

	@Test
	public void nyiso() throws IOException, InterruptedException {
		
		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);
		
		driver.get(prop.getProperty("NYISO"));
		driver.manage().window().maximize();
		Thread.sleep(6000);
		
		cfn.loopAllFramesAndReturnCountofElement(obj.ZONAL_LINK);
		
		cfn.clickByAnyLocator(obj.ZONAL_LINK);
		
				
		Thread.sleep(8000);
		
		System.out.println("************************************************************");
		
		cfn.loopAllFramesAndReturnCountofElement(obj.CAPTURETEXT);
		
		System.out.println(driver.findElement(By.xpath("/html/body/table/tbody/tr[8]/td[2]/span")).getText());
		
	}

	@AfterMethod
	public void afterMethod() throws IOException {
		cfn.takescreenshotWithTimestamp("nyiso");

	}

	@Parameters({ "browsername" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browsername) {

		if (browsername.equalsIgnoreCase("chrome")) {
			cfn.chromeBrowserLaunch();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			cfn.firefoxBrowserLaunch();
		} else if (browsername.equalsIgnoreCase("ie")) {
			cfn.ieBrowserLaunch();
		} else {
			System.out.println("Please enter the browsername between Chrome, Firefox and IE");
		}

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
