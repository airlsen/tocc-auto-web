package com.util;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.config.DriverManage;
/**
 * 截图功能
 * @author John
 *
 */
public class Screenshot {
	WebDriver driver;
	
	
	public Screenshot(WebDriver driver){
		this.driver=driver;
		
	}
	
	
	private void takeScreenshot (String Screenpath) {

		try {
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile,new File(Screenpath));

		} catch (Exception e) {
			System.out.println("截图失败：Can't save screenshot"+Screenpath);
	
		}
	}
	
	public void takeScreenshot(){
		String screenName=String.valueOf(new Date().getTime()+".jpg");
		File dir=new File("test-output/snapshot");
		if(!dir.exists())
			dir.mkdirs();
		String screenPath=dir.getAbsolutePath()+ "/" + screenName;
		this.takeScreenshot(screenPath);
	
	}
	
	/**
	 * 调用方式--示例
	 * @param arg
	 */
	public static void main(String[] arg){
		Screenshot screen=new Screenshot(DriverManage.getDriver());
		screen.takeScreenshot();
		
		
		
		}

}

