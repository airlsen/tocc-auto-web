package com.util;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class RemoteDriverDemo {

	public static void main(String[] args) {
		try {
			WebDriver driver = new RemoteWebDriver(new URL("http://your_server_ip:4444/wd/hub"),DesiredCapabilities.chrome());
			driver.manage().window().maximize();
			driver.get("https://www.baidu.com");
			Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('这会在服务端执行')");
		Thread.sleep(2000);
		driver.quit();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
