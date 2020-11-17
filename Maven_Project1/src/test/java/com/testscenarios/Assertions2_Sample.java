package com.testscenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions2_Sample {
	
  @Test
  public void testcase1() {
	  
	  System.out.println("Test case1 started");
	  Assert.assertEquals(12, 13, "The dropdown count doesn't match. Please check with the developer");
	  System.out.println("Test case1 completed");
	  
  }
  
  @Test
  public void testcase2() {
	  
	  System.out.println("Test case2 started");
	  Assert.assertEquals("Hello", "Hello", "Words doesn't match. Please raise a bug");
	  System.out.println("Test case2 completed");
	  
	   }
  
  @Test
  public void testcase3() {
	  
	  String str1 = "Jyothi";
	  
	  System.out.println("Test case3 started");
	  Assert.assertTrue(str1.startsWith("Jyo"), "Names are not matching. Please raise a bug");
	  System.out.println("Test case3 completed");
	  
	   }
  
  @Test
  public void testcase4() {
	  
	  System.out.println("Test case4 started");
	  Assert.assertTrue(false, "The element is not displayed. Please raise a bug");
	  System.out.println("Test case4 completed");
	  
	   }
}
