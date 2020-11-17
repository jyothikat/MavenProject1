package com.testscenarios;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSample2 {
	
	
  @Test (dataProvider = "dataprovider")
  public void login(String username, String password) {
	  
	  System.out.println("Username is --> " +username+ " & Password is --> " +password);    
	  
  }
  
  @DataProvider (name = "dataprovider")
  public Object[][] getData() {
	  
	  Object[][] obj = new Object[4][2];
	  
	  //1st row
	  obj [0][0] = "test1@gmail.com";
	  obj [0][1] = "test@1";
	  
	  //2nd row
	  obj [1][0] = "test2@gmail.com";
	  obj [1][1] = "test@2";
	  
	  //3rd row row
	  obj [2][0] = "test3@gmail.com";
	  obj [2][1] = "test@3";
	  
	  //1st row
	  obj [3][0] = "test4@gmail.com";
	  obj [3][1] = "test@4";
	  
	  return obj;
	  
  }
  
}
