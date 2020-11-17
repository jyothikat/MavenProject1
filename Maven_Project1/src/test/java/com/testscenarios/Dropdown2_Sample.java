package com.testscenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown2_Sample {

	WebDriver driver;

	@Test
	public void testcase1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement oldstyle = driver.findElement(By.id("oldSelectMenu"));
		Select oldstyle_dd = new Select(oldstyle);
		
		List<WebElement> oldstyle_list = oldstyle_dd.getOptions();
		System.out.println("The oldstyle drop down list has " + oldstyle_list.size());
		Assert.assertEquals(oldstyle_list.size(), 11);
		
		System.out.println("The drop down options are:");
		for (int i = 0; i < oldstyle_list.size(); i++) {
			System.out.println(oldstyle_list.get(i).getText());
		}

		oldstyle_dd.selectByIndex(4); // Purple
		Thread.sleep(5000);
		oldstyle_dd.selectByVisibleText("Magenta");
		Thread.sleep(4000);
		oldstyle_dd.selectByValue("6"); // White
		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void testcase2() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement multiselect = driver.findElement(By.id("cars"));
		Select multiselect_dd = new Select(multiselect);

		List<WebElement> optionscount = multiselect_dd.getOptions();
		System.out.println("The number of options in the dropdown are " + optionscount.size());

		System.out.println("The available options are: ");
		for (int i = 0; i < optionscount.size(); i++) {
			System.out.println(optionscount.get(i).getText());
		}

		if (multiselect_dd.isMultiple()) {
			multiselect_dd.selectByIndex(2);
			Thread.sleep(3000);
			multiselect_dd.selectByValue("saab");
			Thread.sleep(4000);
			multiselect_dd.selectByVisibleText("Audi");
			Thread.sleep(4000);

			List<WebElement> selectedoptions = multiselect_dd.getAllSelectedOptions();
			System.out.println("The selected options are " + selectedoptions.size());
			for (int i = 0; i < selectedoptions.size(); i++) {
				System.out.println(selectedoptions.get(i).getText());
			}

		}
	}

}
