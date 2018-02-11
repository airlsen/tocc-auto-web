package com.util;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class WebWait {
	
	public static Logger logger = Logger.getLogger(SeleniumUtil.class.getName());	
	public static WebElement wait =null;

	/**
	  *  显示等待一
	  *  @param by
	  */
	public static WebElement WaitForElement(WebDriver driver,By by)
    {
		if(wait==null){
		wait=new WebDriverWait(driver, 15).until(
    	    ExpectedConditions.presenceOfElementLocated(by));
		}
		return wait;
    
        
    };
    
    /**
     * 显示等待二
     * @param element
     */
    public static void waitForElementToLoad(WebDriver driver,final WebElement element){
    @SuppressWarnings("unused")
	WebElement e = (new WebDriverWait(driver, 100))
			 .until(new ExpectedCondition< WebElement>(){   	    
    	        public WebElement apply( WebDriver d) {
    	            return element;
    	        }
    	    }
    	);
    }
    
    
    public static void WaitForElementOne(WebDriver driver,final By by){
    WebDriverWait wait = new WebDriverWait(driver, 60);
    @SuppressWarnings("unused")
	WebElement e= wait.until(new  ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver d) {
                return d.findElement(by);
            }
        });
    }

  
   
   /**
    * 隐示等待
    * @param by
    * @param time
    * @return
    */
    public boolean isByElementDisplayed(WebDriver driver,WebElement element, int time) {
        boolean status = false;
        if (element.isDisplayed() == false) {
        	driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        } else {
            status = true;
        }
        return status;
    }
    
    
    
    /**
     * Pause
     * 
     * @param time
     *            in millisecond
     */
    public static void pause(int time) {
        if (time <= 0) {
            return;
        }
        try {
            Thread.sleep(time);
          //  logger.info("Pause " + time + " ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
    
    /**
     * @author : chenjingli
     * @decription element display
     * @return
      */
     public boolean elementIsDisplay(WebDriver driver,final WebElement webElement){
     	boolean flag = false;
     	try{
     		WebDriverWait wait = new WebDriverWait(driver,10);
     		wait.until(new ExpectedCondition<WebElement>(){  
     			public WebElement apply(WebDriver d) {  
     				return webElement;  
     			}}).isDisplayed();  
     		flag =true;
     		return flag;
     	}catch(Exception e){
     		fail("期望的元素未出现"+webElement);
     		return flag;
     	}
     }
     
     
     
     /**
 	 * 在给定的时间内去查找元素，如果没找到则超时，抛出异常
 	 * */
 	public static WebElement WaitForElement (WebDriver driver,int timeOut, final WebElement element) {
 		logger.info("开始查找元素[" + element + "]");
 		boolean wait = false;
 		try {
 			wait =new WebDriverWait(driver, timeOut).until(new ExpectedCondition<Boolean>() {

 				public Boolean apply(WebDriver driver) {
 					return element.isDisplayed();
 				}
 			});
 		} catch (TimeoutException e) {
 			logger.error("超时!! " + timeOut + " 秒之后还没找到元素 [" + element + "]");
 			Assert.fail("超时!! " + timeOut + " 秒之后还没找到元素 [" + element + "]");
 		}
 		if(!wait){
 			return null;
 			
 		}else{
 	 		logger.info("找到了元素 [" + element + "]");
 			return element;
 			
 		}

 	}

    
}



