package com.auto.business.login;

import org.openqa.selenium.WebDriver;

import com.auto.page.login.SystemLoginPage;
import com.config.GetTestProperties;
import com.util.Getscanne;
import com.util.WebWait;

public class GlobalBusiness extends SystemLoginPage{
		
	public GlobalBusiness(WebDriver driver) {
		super(driver);
	}

	/**
	 * 登录功能
	 */
	public void login(){
		//重置
		ClickReset();
		//input用户名
		InputName(GetTestProperties.getname());
		//input密码
		InputPassword(GetTestProperties.getpassword());
		//input验证码
		InputVerification(Getscanne.getcode());
		//click登录
		ClickLogin();
		WebWait.pause(2000);

	}
	
	

	

}
