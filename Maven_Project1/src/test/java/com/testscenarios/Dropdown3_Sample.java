package com.testscenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown3_Sample {

	WebDriver driver;

	@BeforeClass

	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

//	@Test
	public void testcase1() {

		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement oldstyle = driver.findElement(By.id("oldSelectMenu"));
		Select oldstyle_dd = new Select(oldstyle);

		// Count number of drop down values
		List<WebElement> oldstylelist = oldstyle_dd.getOptions();
		System.out.println("The number of values in the drop down list are " + oldstylelist.size());

		Assert.assertEquals(oldstylelist.size(), 11);

		System.out.println("The drop down values are:");

		// Print the drop down values
		for (int i = 0; i < oldstylelist.size(); i++) {

			System.out.println(oldstylelist.get(i).getText());
		}

		// Select any option from the drop down
		oldstyle_dd.selectByVisibleText("Magenta");

		WebElement selectedoption = oldstyle_dd.getFirstSelectedOption();
		String str1 = selectedoption.getText();
		Assert.assertTrue(str1.contains("Magent"), "The selected option is not Magenta");
		System.out.println("The selected option is " + str1);

	}

//	@Test
	public void testcase2() throws InterruptedException {

		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement multiselect = driver.findElement(By.id("cars"));
		Select multiselect_dd = new Select(multiselect);

		// Print the number of options in the drop down
		List<WebElement> options = multiselect_dd.getOptions();
		System.out.println("The number of values in the drop down are " + options.size());
		Assert.assertEquals(options.size(), 4);

		System.out.println("The drop down values are:");

		// Print the values from the drop down
		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
		}

		// Select multiple options
		multiselect_dd.selectByValue("audi");
		multiselect_dd.selectByVisibleText("Saab");
		multiselect_dd.selectByIndex(2);
		Thread.sleep(3000);

		// Count the number of options selected
		List<WebElement> selectedoptions = multiselect_dd.getAllSelectedOptions();
		System.out.println("The number of selected options are " + selectedoptions.size());
		Assert.assertEquals(selectedoptions.size(), 3);

		System.out.println("The selected options are:");

		// Print the selected options
		for (int i = 0; i < selectedoptions.size(); i++) {
			System.out.println(selectedoptions.get(i).getText());
		}

	}


	

}
