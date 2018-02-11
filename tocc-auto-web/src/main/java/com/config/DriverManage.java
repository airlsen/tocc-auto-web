package com.config;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.auto.business.login.SystemLoginbusiness;
import com.util.CommonMethord;

/**
 * 启动浏览器类
 * @author John
 *
 */
public class DriverManage {
	private static   WebDriver driver=null;
	private static Logger log = Logger.getLogger(DriverManage.class.getName());
	//构造方法
	private  DriverManage(){};
	
    //启动浏览器
		public  static  WebDriver getDriver(){
        //手动加载日志文件
		//CommonMethord.getRealath()获取工程目录绝对路径
		
		PropertyConfigurator.configure(CommonMethord.getPath()+ "/conf/log4j.properties");
		
		DesiredCapabilities caps=null;
		switch (Integer.parseInt(GetTestProperties.getBrowserType())) {
		case 1:			
			System.setProperty("webdriver.firefox.bin","d:\\Program Files\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver();
			log.info("runDriver is ff......");
			break;

		case 2:
			System.setProperty("webdriver.ie.driver",CommonMethord.getPath() + "/res/IEDriverServer_32.exe");				
			caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);   
			//IE默认开启保护模式，要么手动关闭，要么使用这句
			caps.setCapability("ignoreProtectedModeSettings", true); 
			caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, "-private");		
	        caps.setCapability("ignoreZoomSetting", true);
			//new IE对象
	        driver = new InternetExplorerDriver(caps);
			log.info("runDriver is ie......");
			break;

		case 3:				
			System.setProperty("webdriver.chrome.driver",CommonMethord.getPath() + "/res/chromedriver.exe");		
			driver = new ChromeDriver();
			log.info("runDriver is chrome......");
			break;
		}

	
		return driver;
		
	}
		
		
		public static void main(String[] args){
			
			System.out.println(DriverManage.getDriver());
			
		}
	

}
