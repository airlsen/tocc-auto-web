package com.page;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.auto.business.login.GlobalBusiness;
import com.config.DriverManage;
import com.util.CookieUtil;

public class NewTest {

	//登录对象
	public GlobalBusiness login=null;
  @Test
  public void f() throws InterruptedException {
		 WebDriver driver=DriverManage.getDriver();
		CookieUtil cookie=new CookieUtil(driver);
		driver.get("http://119.4.240.104/tocc/login_dev.jsp?lastURL=");
		 login=new GlobalBusiness(driver);		
		 //登录
		 login.login();	
	      //driver.manage().addCookie(cookie);
		 System.out.println("000000000000"+driver.manage().getCookies());
	      System.out.println("11111111111111"+driver.manage().getCookieNamed("JSESSIONID"));
	      
	      Cookie cookie3=driver.manage().getCookieNamed("JSESSIONID");

	      System.out.println("2222222222222"+driver.manage().getCookies());


	        Thread.sleep(3000);
	        WebDriver driver1=DriverManage.getDriver();
	        System.out.println("333333333333333"+driver1.manage().getCookieNamed("JSESSIONID"));
	        
	        driver1.get("http://119.4.240.104/tocc/rest/view/main/topLeft/APP-SJGL");
	        driver1.manage().addCookie(cookie3);
	        System.out.println("4444444444444"+driver1.manage().getCookies());
	        driver1.get("http://119.4.240.104/tocc/rest/view/main/topLeft/APP-SJGL");
	        
	        Object a=(Object)driver1.manage().getCookies();
	        System.out.println("888888888888888"+a);

	        System.out.println("999999999999999"+cookie.getCookievalue("JSESSIONID"));
	        
	        
	        }
  }

