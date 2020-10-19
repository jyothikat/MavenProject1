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
	
	
	
	
	
	

}
