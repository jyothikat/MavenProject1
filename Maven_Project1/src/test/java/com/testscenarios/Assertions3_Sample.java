package com.testscenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Assertions3_Sample {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		driver.get("https://forms.toyota.co.uk/brochure");
		driver.manage().window().maximize();
		Thread.sleep(6000);

		driver.findElement(By.linkText("Yes, I agree")).click();
		Thread.sleep(6000);

		driver.findElement(By.xpath("//div[text()='Postal']")).click();
		Thread.sleep(6000);

		WebElement submit = driver.findElement(By.id("submit-br"));
		assertTrue(submit.isEnabled(), "The submit button is not enabled, please check with the developer");
		submit.click();
		Thread.sleep(4000);
		System.out.println("The submit button is enabled");
		
		String atitletext1 = driver.findElement(By.xpath("//*[text()='Please select your title']")).getAttribute("innerHTML");
		System.out.println(atitletext1);
		
		String atitletext = driver.findElement(By.xpath("//*[text()='Please select your title']")).getText();
		String etitletext = "Please select your title";
		Assert.assertEquals(atitletext, etitletext,
				"The validation message for title is not as expected. Please raise a bug");

		String afirstnametext = driver.findElement(By.xpath("//*[text()='Please enter your first name']")).getText();
		String efirstnametext = "Please enter your first name";
		Assert.assertEquals(afirstnametext, efirstnametext,
				"The validation message for firstname is not as expected. Please raise a bug");

		String asurnametext = driver.findElement(By.xpath("//*[text()='Please enter your surname']")).getText();
		String esurnametext = "Please enter your surname";
		Assert.assertEquals(asurnametext, esurnametext,
				"The validation message for surname is not as expected. Please raise a bug");

		String aemailtext = driver
				.findElement(By.xpath(
						"//*[text()='In order to send you your brochure by email please fill in your email address']"))
				.getText();
		String eemailtext = "In order to send you your brochure by email please fill in your email address";
		Assert.assertEquals(aemailtext, eemailtext,
				"The validation message for email is not as expected. Please raise a bug");

		String ahousenumbertext = driver.findElement(By.xpath("//*[text()='Please enter your house name or number']"))
				.getText();
		String ehousenumbertext = "Please enter your house name or number";
		Assert.assertEquals(ahousenumbertext, ehousenumbertext,
				"The validation message for house number is not as expected. Please raise a bug");

		String apostcodetext = driver.findElement(By.xpath("//*[text()='Please enter your postcode']")).getText();
		String epostcodetext = "Please enter your postcode";
		Assert.assertEquals(apostcodetext, epostcodetext,
				"The validation message for postal code is not as expected. Please raise a bug");
	}

	@BeforeClass
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
