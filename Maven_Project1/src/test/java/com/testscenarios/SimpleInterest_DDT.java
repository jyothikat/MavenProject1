package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class SimpleInterest_DDT extends StaticVariables {

	CommonFunctions cfn = new CommonFunctions();
	Locators obj = new Locators();

	@Parameters("browserName")
	@BeforeClass
	public void setUp(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			cfn.chromeBrowserLaunch();
		} else if (browserName.equalsIgnoreCase("Firefox")) {

			cfn.firefoxBrowserLaunch();
		} else if (browserName.equalsIgnoreCase("Edge")) {

			cfn.edgeBrowserLaunch();
		} else if (browserName.equalsIgnoreCase("IE")) {

			cfn.ieBrowserLaunch();
		} else {

			System.out.println("Please enter the browser name within Chrome, Firefox, Edge and IE");
		}
	}

	@Test
	public void f() throws InterruptedException, IOException {
		
		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);

		driver.get(prop.getProperty("MoneyControl"));
		driver.manage().window().maximize();
		Thread.sleep(5000);

		cfn.excelPath(".\\TestData\\Testdata.xlsx");

		int rowcount = cfn.getRowCount("SimpleInterest");
		System.out.println("The no. of rows in the excel are: " + rowcount);

		for (int i = 1; i <= rowcount; i++) {

			int principal = (int) cfn.getNumericData("SimpleInterest", i, 0);
			int interest = (int) cfn.getNumericData("SimpleInterest", i, 1);
			int period = (int) cfn.getNumericData("SimpleInterest", i, 2);
			String frequency = cfn.getStringData("SimpleInterest", i, 3);
			double maturityvalue = cfn.getNumericData("SimpleInterest", i, 4);
			System.out.println("The expected maturity value is: " + maturityvalue);

			driver.findElement(obj.PRINCIPAL_INPUT).sendKeys(String.valueOf(principal));
			driver.findElement(obj.INTEREST_INPUT).sendKeys(String.valueOf(interest));
			driver.findElement(obj.TENURE_INPUT).sendKeys(String.valueOf(period));

			WebElement tenurePeriod = driver.findElement(obj.TENUREPERIOD_DROPDOWN);
			Select tenurePeriod_dd = new Select(tenurePeriod);
			tenurePeriod_dd.selectByVisibleText(prop.getProperty("Duration"));

			WebElement freq = driver.findElement(obj.FREQUENCY_DROPDOWN);
			Select freq_dd = new Select(freq);
			freq_dd.selectByVisibleText(frequency);
			
			cfn.clickByAnyLocator(obj.CALCULATE_BUTTON);
			Thread.sleep(2000);

			String actualmaturity_value = driver.findElement(By.id("resp_matval")).getText();
			System.out.println("The actual maturity value is: " + actualmaturity_value);

			cfn.clickByAnyLocator(obj.CLEAR_BUTTON);
			Thread.sleep(2000);

			if ((Double.parseDouble(actualmaturity_value)) == maturityvalue) {
				System.out.println("Test passed");
				cfn.setcellData("SimpleInterest", i, 5, "Pass", ".\\TestData\\Testdata.xlsx");

			} else {
				System.out.println("Test failed");
				cfn.setcellData("SimpleInterest", i, 5, "Fail", ".\\TestData\\Testdata.xlsx");
			}
		}
		System.out.println("Updated test results successfully");
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

	@AfterMethod
	public void afterMethod() throws IOException {

		cfn.takescreenshotWithTimestamp("SimpleInterest");
	}

}
