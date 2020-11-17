package com.objectrepository;

import org.openqa.selenium.By;

public class Locators {
	
	//public final By PAGENAME_ELEMENTNAME_ELEMENTTYPE= By.id("Attribute value");
	
	public final By SEARCH_INPUT=By.xpath("//input[@name='q']");
	public final By GOOGLESEARCH_BUTTON=By.name("btnK");
	public final By SIGNUP_LINK = By.linkText("Sign Up");
	public final By FIRSTNAME_INPUT = By.name("fName");
	public final By LASTNAME_INPUT = By.name("lName");
	public final By	MOBILENUMBER_INPUT = By.name("mobNo");
	public final By GENDER_RADIO = By.xpath("(//input[@name='gender'])[2]");
	public final By ADDRESSLINE1_INPUT = By.name("address1");
	public final By ADDRESSLINE2_INPUT = By.name("address2");
	public final By CITY_INPUT = By.name("cityS");
	public final By COUNTRY_DROPDOWN = By.name("countryS");
	public final By STATE_DROPDOWN = By.name("stateS");
	public final By ZIPCODE_INPUT = By.name("zipCode");
	public final By PHOTOIDPROOF_DROPDOWN = By.name("proofS");
	public final By PHOTOIDCARDNUMBER_INPUT = By.id("proofid");
	public final By USERNAME_INPUT = By.name("emailId");
	public final By PASSWORD_INPUT = By.name("password");
	public final By CONFIRMPASSWORD_INPUT = By.name("repassword");
	public final By CONTINUE_BUTTON = By.id("regi_continue");
	
	public final By SIGNIN_LINK = By.xpath("(//a[contains(@title,'Sign In')])[1]");
	public final By EMAIL_INPUT = By.xpath("//input[contains(@name, 'txtUserName')]");
	public final By PASSWORD2_INPUT = By.xpath("//input[contains(@name, 'txtPasswd')]");
	public final By SECURESIGNIN_BUTTON = By.xpath("//input[contains(@name, 'imgbtnSignin')]");
	
	public final By FB_EMAIL_INPUT = By.xpath("//input[contains(@id,'email')]");
	public final By FB_PASSWORD_INPUT = By.xpath("//input[contains(@id,'pass')]");
	public final By FB_LOGIN_BUTTON = By.name("login");
	
	public final By REGISTER = By.linkText("REGISTER AS PARTNER");
	public final By BUSINESSNAME_INPUT = By.id("form-field-name");
	
	public final By ZONAL_LINK = By.xpath("//*[@name= 'P-24Alist']");
	public final By CAPTURETEXT = By.xpath("/html/body/table/tbody/tr[8]/td[2]/span");
	
	public final By DOWNLOAD_BUTTON = By.xpath("//div[contains(text(),'Download')]");
	
	public final By RSIGNIN_LINK = By.linkText("Sign in");
	public final By REMAIL_INPUT = By.name("txtUserName");
	public final By RPASSWORD_INPUT = By.name("txtPasswd");
	public final By RSECURESIGNIN_BUTTON = By.name("imgbtnSignin");
	public final By RMOBILEDELETE_BUTTON = By.xpath("//table[@id='listingtable']/tbody/tr[6]/td[7]/a[2]");
	
	public final By TTDMONTH_DROPDOWN = By.xpath("//select[@title='Change the month']");
	public final By TTDYEAR_DROPDOWN = By.xpath("//select[@title='Change the year']");
	public final By TTDDATE_TABLE = By.xpath("//div[@class='datepick-month']/table/tbody/tr[3]/td[6]");
	
	public final By FLIGHTS_LINK = By.xpath("//span[text()= 'Flights']");
	public final By LEAVINGFROM_BUTTON = By.xpath("//button[@aria-label='Leaving from']");
	public final By ORIGIN_INPUT = By.xpath("//input[@id='location-field-leg1-origin']");
	public final By ORIGIN1_INPUT = By.xpath("//li[@class='uitk-typeahead-result-item has-subtext'][1]");
	public final By GOINGTO_BUTTON = By.xpath("//button[@aria-label='Going to']");
	public final By DESTINATION_INPUT = By.xpath("//input[@id='location-field-leg1-destination']");
	public final By DESTINATION1_INPUT = By.xpath("(//button[@data-stid = 'location-field-leg1-destination-result-item-button'])[1]");
	public final By TRAVEL_DATE = By.xpath("//button[contains(@id,'d1-btn')]");
	public final By DEPART_DATE = By.xpath("(//table[@class='uitk-new-date-picker-weeks'])[1]/tbody/tr[3]/td[4]");
	public final By RETURN_DATE = By.xpath("(//table[@class='uitk-new-date-picker-weeks'])[2]/tbody/tr[4]/td[6]");
	public final By DONE_BUTTON = By.xpath("//span[text() = 'Done']");
	public final By SEARCH_BUTTON = By.xpath("//button[text()='Search']");
	public final By TEXTVALIDATION = By.xpath("(//div[@class='uitk-flex'])[1]");
	
	public final By MONTH_DROPDOWN = By.id("month");
	
	public final By PRINCIPAL_INPUT = By.id("principal");
	public final By INTEREST_INPUT = By.id("interest");
	public final By TENURE_INPUT = By.id("tenure");
	public final By TENUREPERIOD_DROPDOWN = By.id("tenurePeriod");
	public final By FREQUENCY_DROPDOWN = By.id("frequency");
	public final By CALCULATE_BUTTON = By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]");
	public final By CLEAR_BUTTON = By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]/img");
	
	
	
	
	
	
	
	
	

}
