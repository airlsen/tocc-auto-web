package com.page;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.config.DriverManage;

public class NewTest1 {
  @Test
  public void f() {

      WebDriver driver1=DriverManage.getDriver();
      System.out.println("333333333333333"+driver1.manage().getCookieNamed("JSESSIONID"));
      
      driver1.get("http://119.4.240.104/tocc/rest/view/main/topLeft/APP-SJGL");

      
      Cookie cookie=new Cookie("JSESSIONID","869956F7AD98AA32F6ED2AF091FF316D","/tocc",null);
      driver1.manage().addCookie(cookie);
      System.out.println("4444444444444"+driver1.manage().getCookies());
      driver1.get("http://119.4.240.104/tocc/rest/view/main/topLeft/APP-SJGL");
      
  }
}
