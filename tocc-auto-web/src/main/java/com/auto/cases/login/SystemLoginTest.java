package com.auto.cases.login;


import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auto.business.login.SystemLoginbusiness;
import com.auto.data.login.SystemLoginData;
import com.config.DriverManage;
import com.util.RobotScreenShot;
/**Success
 * @author asen
 */
public class SystemLoginTest {
	public static WebDriver webdriver=DriverManage.getDriver();
	 public static SystemLoginbusiness login;
	 private static Logger log = Logger.getLogger(SystemLoginTest.class.getName());
	 
	 
	/**Sucess
	 * 系统登录功能测试
	 */
	@Test(dataProvider = "SystemLogin", dataProviderClass = SystemLoginData.class,enabled = true)
	public void login(String username,String password, String flag,String expected) 
			throws Exception {
		try{		
		login=new SystemLoginbusiness(webdriver);
		log.info("预期结果："+expected);
		//断言
		assertEquals(expected, login.login(username, password,flag));
		}catch (NoSuchElementException e){
			   log.error("wofe review purchase fail ", e);
			   RobotScreenShot.snapShot(this.getClass().getName());
			   throw new Exception("wofe add purchase fail>> " + e.getMessage(), e);
		 }	
		
			}	
	
	 @BeforeClass
	    public void beforeClass() {
	    }
	 

	    @AfterClass
	    public void afterClass() {
	    	//退出浏览器
	    	//login.quit();
	    }
	    

	
	



}
