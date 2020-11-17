package com.testscenarios;

import org.testng.annotations.Test;
import com.objectrepository.Locators;
import com.utilities.CommonFunctions;
import com.utilities.StaticVariables;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import org.openqa.selenium.By;

public class Webtable_Justrechargeit extends StaticVariables {

	CommonFunctions cfn = new CommonFunctions();
	Locators obj = new Locators();

	@Test
	public void webtable() throws IOException, InterruptedException {

		FileInputStream path = new FileInputStream(".\\TestData\\testdata.properties");
		Properties prop = new Properties();
		prop.load(path);

		driver.get(prop.getProperty("Justchargeit"));
		driver.manage().window().maximize();
		cfn.implicitWait(10);

		cfn.clickByAnyLocator(obj.RSIGNIN_LINK);
		Thread.sleep(6000);
		cfn.sendKeysByAnyLocator(obj.REMAIL_INPUT, prop.getProperty("REMAIL"));
		cfn.sendKeysByAnyLocator(obj.RPASSWORD_INPUT, prop.getProperty("RPASSWORD"));
		Thread.sleep(6000);

		// Manually enter the captcha in the console
		// System will take the entered input from the console using scanner
		System.out.println("Please enter the captcha value");
		Scanner s = new Scanner(System.in);
		int captchanumber = s.nextInt();
		s.close();
		// convert integer to string
		String captchastring = Integer.toString(captchanumber);
		// enter captcha
		driver.findElement(By.id("txtCaptcha")).sendKeys(captchastring);
		Thread.sleep(5000);

		cfn.clickByAnyLocator(obj.RSECURESIGNIN_BUTTON);
		Thread.sleep(6000);
		cfn.clickByAnyLocator(obj.RMOBILEDELETE_BUTTON);
		Thread.sleep(6000);
		driver.switchTo().alert().accept();
		Thread.sleep(6000);

	}

	@AfterMethod
	public void afterMethod() throws IOException {
		cfn.takescreenshotWithTimestamp("Justchargeit");
	}

	@Parameters("browsername")

	@BeforeClass
	public void setup(@Optional("chrome") String browsername) {

		if (browsername.equalsIgnoreCase("chrome")) {
			cfn.chromeBrowserLaunch();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			cfn.firefoxBrowserLaunch();
		} else if (browsername.equalsIgnoreCase("ie")) {
			cfn.ieBrowserLaunch();
		} else {
			System.out.println("Please enter the browser name within Chrome, Firefox and IE");
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
