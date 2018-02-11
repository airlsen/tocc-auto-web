package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
/**
 * 高亮函数
 * @author Asen
 *
 */
public class HighlightElement {
	public static void highlightElement(WebDriver driver, WebElement element) {
		 
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("element = arguments[0];" +
             "original_style = element.getAttribute('style');" +
                 "element.setAttribute('style', original_style + \";" +
             "background: red; border: 2px solid red;\");" +
             "setTimeout(function(){element.setAttribute('style', original_style);}, 1000);", element);
}

	public static void main(String[] args){
		WebDriver oDriver = new InternetExplorerDriver();
		oDriver.get("http://www.baidu.com");
		WebElement oEdit = oDriver.findElement(By.name("wd"));
		WebElement oButton = oDriver.findElement(By.id("su"));
		highlightElement(oDriver, oButton);
		highlightElement(oDriver, oEdit);
		
	}
}
