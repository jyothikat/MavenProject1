package com.testscenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions4 {
	
	
	
	
  @Test
  public void testcase1() {
	  
	  System.out.println("Started testcase1 execution");
	  Assert.assertTrue(true); //passed
	  Assert.assertEquals("Welcome", "Welcome"); //passed
	  Assert.assertFalse(false); //passed
	  Assert.assertEquals("selenium", "selenium"); //passed
	  System.out.println("Testcase1 is completed"); 
  }
 
  @Test
public void testcase2() {
	  
	  System.out.println("Started testcase2 execution");
	  Assert.assertTrue(true); //passed
	  Assert.assertEquals("Welcome", "welcome"); //failed
	  Assert.assertFalse(false); //passed
	  Assert.assertEquals("selenium", "selenium"); //passed
	  System.out.println("Testcase2 is completed"); 
  }
  
  @Test
  public void testcase3() {
	  
	  System.out.println("Started testcase3 execution");
	  Assert.assertTrue(true); //passed
	  Assert.assertEquals("welcome", "welcome"); //passed
	  Assert.assertFalse(false); //passed
	  Assert.assertEquals("selenium", "Selenium"); //failed
	  System.out.println("Testcase3 is completed"); //passed
	  
  }
  
  @Test
  public void softassert_1() {
	  
	  SoftAssert sa1 = new SoftAssert();
	  System.out.println("Started testcase4 execution");
	  sa1.assertTrue(true); //passed
	  sa1.assertEquals("Welcome", "welcome"); //failed
	  sa1.assertFalse(false); //passed
	  sa1.assertEquals("selenium", "selenium"); //passed
	  System.out.println("Testcase4 is completed"); 
	  sa1.assertAll();
	  
  }
  
  @Test
  public void softassert_2() {
	  
	  SoftAssert sa2 = new SoftAssert();
	  
	  System.out.println("Started testcase5 execution");
	  sa2.assertTrue(true); //passed
	  sa2.assertEquals("Welcome", "Welcome"); //passed
	  sa2.assertFalse(false); //passed
	  sa2.assertEquals("selenium", "selenium"); //passed
	  System.out.println("Testcase5 is completed"); 
	  sa2.assertAll();
	  
  }
}
