package com.auto.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.config.DriverManage;
import com.config.GetTestProperties;
import com.config.TestConfig;
import com.util.ExcelDataProvider;
import com.util.SeleniumUtil;
import com.util.CookieUtil;
/**
 * @author John
 */
public class BaseParpare {
	//日志对象
	static Logger logger = Logger.getLogger(BaseParpare.class.getName());
	//seleniumUtil对象
	protected SeleniumUtil seleniumUtil = null;
	//cookie对象
	protected CookieUtil CookieUtil = null;
	//driver对象
	public WebDriver webdriver=null;
	//配置文件对象
	TestConfig tc=null;
	// 添加成员变量来获取beforeClass传入的context参数
	protected ITestContext testContext = null;
	public String webUrl="";
	protected int timeOut = 0;
	protected String sleepTime = "0";
	protected String waitMillisecondsForAlert = "0";

	@BeforeSuite
	/**启动浏览器并打开测试页面*/
	public void startTest(ITestContext context) {
		//webdriver对象
		webdriver=DriverManage.getDriver();
		//seleniumUtil对象
		seleniumUtil = new SeleniumUtil(webdriver);
		//登陆浏览器类型
		String browserName=GetTestProperties.getBrowserType();
		//timeout
		timeOut=GetTestProperties.gettimeOut();
		//sleep
		sleepTime=GetTestProperties.getsleepTime();
		//配置文件
		tc = new TestConfig("/conf/cookie.properties");

		try {
			//先打开首页
			seleniumUtil.launchBrowser(browserName,GetTestProperties.getTestUrl("loginurl"),timeOut);
			//通过键入cookie，使用之前的cookie来打开浏览器，不需要从新登陆
			 CookieUtil cook= new CookieUtil(webdriver);
			 cook.addCookie("JSESSIONID", tc.getCookie());	
			//启动浏览器launchBrowser方法可以自己看看，主要是打开浏览器，输入测试地址，并最大化窗口
			seleniumUtil.launchBrowser(browserName,webUrl,timeOut);
			cook.getCookies();
		} catch (Exception e) {
			logger.error("浏览器不能正常工作，请检查是不是被手动关闭或者其他原因",e);
		}
		////设置一个testng上下文属性，将driver存起来，之后可以使用context随时取到，主要是提供arrow 获取driver对象使用的，因为arrow截图方法需要一个driver对象
		//testContext.setAttribute("SELENIUM_DRIVER", seleniumUtil.driver);
		
		 //login=new GlobalBusiness(webdriver);		
		 //登录
		 //login.login();	
		
		 
		 
		
	
	}

	@AfterSuite
	/**结束测试关闭浏览器*/
	public void endTest() {
		if (seleniumUtil.driver != null) {
			//退出
			seleniumUtil.quit();
		} else {
			logger.error("浏览器driver没有获得对象,退出操作失败");
			Assert.fail("浏览器driver没有获得对象,退出操作失败");
		}
	}

	

	/**
	 * 测试数据提供者 - 方法
	 * */
	@DataProvider(name = "testData")
	public Iterator<Object[]> dataFortestMethod(Method method) throws IOException {
		String moduleName = null; // 模块的名字
		String modulereplace=null;//用例编号
		String className = this.getClass().getName();//这里的className是：com.demo.test.testcases.login.LoginPage_001_LoginSuccessFunction_Test
		int dotIndexNum = className.lastIndexOf("."); // 取得第一个.的index		

		if (dotIndexNum > 0) {
			moduleName = className.substring(dotIndexNum+1, className.lastIndexOf("_")); 
			modulereplace=moduleName.replaceAll("_", "/")+"/"+method.getName();
		}
		
		//将模块名称和用例的编号传给 ExcelDataProvider ，然后进行读取excel数据
		return new ExcelDataProvider(modulereplace, method.getName());
	
	}
	
	/**
	 * 通过类名获取到加载yaml的路径名
	 * @param className
	 * @return
	 */
	public  String targetPath(String className){
		String pathName=null;
		String yamlPath=null;//用例编号
		int dotIndexNum = className.lastIndexOf("."); // 取得第一个.的index
		try{
		if(dotIndexNum > 0){
			pathName = className.substring(dotIndexNum+1, className.lastIndexOf("_")); 
			yamlPath=pathName.replaceAll("_", "/");		
		}
		}catch(Exception e){
			logger.info("测试类文件名格式不正确，请修改！！"+ "[" +className+ "]" );
		}
		return yamlPath;
	}
	
	
	
	
	
	

	
	
	
}
