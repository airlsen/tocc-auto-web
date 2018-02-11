package com.config;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


/**
 * 
 * @author jianping.gao
 *
 */
public class RemoteWebDriverManage {

	/**
	 * slf4j logback
	 */
	private static Logger logger = Logger.getLogger(RemoteWebDriverManage.class.getName());

	public final String DEFAULT_DRIVER = "firefox";
	public final String FIRFOX_DRIVER = "firefox";
	public final String CHROME_DRIVER = "chrome";
	public final String IE_DRIVER = "ie";
	public final String IPHONE_DRIVER = "iphone";
	public final String ANDROID_DRIVER = "android";

	public final String FIRFOX_DRIVER_PATH = "selenium.browser.firefox";
	public final String CHROME_DRIVER_PATH = "selenium.browser.chrome.driver";
	public final String IE_DRIVER_PATH = "selenium.browser.ie.driver.32";

	private int timeout = 60;
	private static String classpath = "";

	/**
	 * 
	 * @param config
	 */
	public RemoteWebDriverManage() {

	}

	/**
	 * instance browser
	 * 
	 * @param browserType
	 * @param browserPath
	 * @return
	 */
	public WebDriver newInstanceOf(String browser ,String remoteIp ,String platform) {
		WebDriver webDriver;
		webDriver = firefoxBrowserInstance(platform,remoteIp);
		webDriver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		webDriver.manage().timeouts()
				.pageLoadTimeout(timeout, TimeUnit.SECONDS);
		webDriver.manage().timeouts()
				.setScriptTimeout(timeout, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		return webDriver;
	}

	

	/**
	 * Firefox browser instance
	 * 
	 * @param browserPath
	 * @return
	 */
	private WebDriver firefoxBrowserInstance(String platform ,String remoteIp) {
			WebDriver driver = null;
		try {
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setBrowserName("firefox" ); 
			//capability.setPlatform(Platform.WINDOWS);  
			driver =new RemoteWebDriver(new URL(remoteIp+"/wd/hub"),capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 
		logger.info("远程启动启动Firefox浏览器   [{}]");
		return driver;
	}


	

}
