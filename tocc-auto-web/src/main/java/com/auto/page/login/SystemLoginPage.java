package com.auto.page.login;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.HighlightElement;



public class SystemLoginPage extends GlobalPage{
	public WebDriver driver=null;
	private static Logger log = Logger.getLogger("SystemLoginPage");
	/**
	 * 初始化对象
	 * @throws Exception 
	 */	
	public SystemLoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 登录名
	 */
	@FindBy(id="userId")
	@CacheLookup
	private WebElement LoginName;	
	
	/**
	 * 登录密码
	 */
	@FindBy(id="password")
	@CacheLookup
	private WebElement LoginPassword;	
		
	/**
	 * 验证码
	 */
	@FindBy(id="validateCode")
	@CacheLookup
	private WebElement Verification;
		
	/**
	 * 登录按钮
	 */
	@FindBy(id="submit")
	@CacheLookup
	private WebElement Submit;	
	
	/**
	 * 重置
	 */
	@FindBy(id="reset")
	@CacheLookup
	private WebElement Reset;
	
	/**
	 * 重置
	 */
	@FindBy(xpath=".//*[@id='ErrorMsg']/div[2]")
	@CacheLookup
	private WebElement LoginResult;
	
	
	//************************************************** 对应对象方法*******************************	

	/**
	 * input登录名
	 */
	public void InputName(String value) {
		//日志
		log.info("登录名："+value);
		sendKeys(LoginName, value);
	}
	
	/**
	 * input登录密码
	 */
	public  void InputPassword(String value) {
		//日志
		log.info("登录密码："+value);
		sendKeys(LoginPassword, value);
	}
	
	/**
	 * input验证码
	 */
	public void InputVerification(String value) {
		//日志
		log.info("验证码："+value);
		click(Verification);
		sendKeys(Verification, value);
	}
	
	/**
	 * click登录
	 */
	public void ClickLogin() {
		//日志
		log.info("点击登录");
		HighlightElement.highlightElement(driver, Submit);
		click(Submit);		
	}
	/**
	 * click重置
	 */
	public void ClickReset() {
		//日志
		log.info("重置信息");
		HighlightElement.highlightElement(driver, Reset);
		click(Reset);
	}
	
	/**
	 * click获取登录结果
	 * @return 
	 */
	public  String GetLoginResult() {
		//日志
		log.info("实际结果："+LoginResult.getText().trim());
		return LoginResult.getText().trim();
	}
}

	
