package com.auto.base;

import java.util.Map;

import org.testng.annotations.Test;

import com.config.GetTestProperties;



public class Configmanagement_Systemcode_test  extends BaseParpare{
	
	
	public Configmanagement_Systemcode_test(){
		this.webUrl=GetTestProperties.getTestUrl("managerurl");
		}
	
	
	
  @Test(dataProvider="testData")
  public void add(Map<String,String> data) {


	
  } 
  
  @Test(dataProvider="testData")
  public void query(Map<String,String> data) {
}
  @Test(dataProvider="testData")
  public void delete(Map<String,String> data) {
  }
}
  
