package com.auto.business.login;


import java.io.UnsupportedEncodingException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.util.CookieUtil;
import com.util.Getscanne;
import com.auto.page.login.SystemLoginPage;
import com.config.GetTestProperties;


public class SystemLoginbusiness extends SystemLoginPage {
	//driver对象
	//private   WebDriver driver=null;
	private CookieUtil cook=null;
	
	public static String TipInformation;
	private static Logger log = Logger.getLogger("SystemLoginbusiness");
	/**
	 * 初始化对象
	 * @throws Exception 
	 */
	public SystemLoginbusiness(WebDriver driver)  {	
		super(driver);
		this.cook=new CookieUtil(driver);
		
		
	}		
	/**
	 * 登录功能,并且保存cookie值
	 * @param username
	 * @param password
	 * @return 
	 * @throws UnsupportedEncodingException 
	 */	
	public String login(String username,String password,String flag )  { 
		
		log.info("测试---------登录功能--------------------");
		//open打开网址
		launchBrowser(GetTestProperties.getBrowserType(),GetTestProperties.getTestUrl("loginurl"),GetTestProperties.gettimeOut());
		//重置信息
		
		//input用户名
		InputName(username);
		//input密码
		InputPassword(password);
		if (username.equals("xzaqc") && password.equals("123456")){
			 //input验证码
			 InputVerification(Getscanne.getcode());
			 //click登录
			 ClickLogin();
			 if(flag.equals("f")){
				 TipInformation=GetLoginResult();
				 				 
			 }else{
				 //等待3秒
				 pause(3);
				//登录成功才能获取cookie值，为以后打开浏览器做准备，就不用再次输入用户名及密码
				 GetTestProperties.writeValue("JSESSIONID", cook.getCookievalue("JSESSIONID"));
				 TipInformation="登录成功!";				 
			 }			 
		 }	
		else{
			 //click登录
			 ClickLogin();
			 //get提示信息
			 TipInformation=GetLoginResult();
		 }	 
		return TipInformation;
	}
	
	
	
	
}

