package com.util;

import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * selenium来操作cookie到底有什么用呢？主要有两点：
1.测试web程序经常需要清楚浏览器缓存，以消除不同版本的影响，selenium就可以自动执行了，每次测试新版本前先清楚缓存文件
2.用来完成自动登陆的功能，无需再编写登录的公共方法了
 * @author John
 */
public class CookieUtil {
	/** 使用Log4j，第一步就是获取日志记录器，这个记录器将负责控制日志信息 */
	public static Logger logger = Logger.getLogger(CookieUtil.class.getName());

	public WebDriver driver = null;


	/**
	 * 传参以及初始化  
	 */
	public CookieUtil (WebDriver driver){
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * 添加cookie
	 */
	public void addCookie(String name,String value){
		//ddomain表示的是cookie所在的域，默认为请求的地址，这里我们为 10.54.40.40，
		//强烈注意：在注入cookie时候，需要先删除才能注入成功，不然会失败的
		deleteCookie("JSESSIONID");
		Cookie cookie = new Cookie(name,value,"119.4.240.104","/tocc",null);
		driver.manage().addCookie(cookie);
		logger.info("注入cookie值:  [ "+name+": "+value+" ]"+"获取的实际cookie值：[ "+getCookies()+"]" );
	
	}
	/**
	 * 删除cookie
	 * @param name
	 */
	public void deleteCookie(String name){  		
	    //删除名称为value的cookie
	    driver.manage().deleteCookieNamed(name);
	    logger.info("删除cookie名称为：  "+name );
		    }
	
	/**
	 * 删除所有cookie
	 */
	public void deleteAllCookie(String name){  		
	    //删除名称为value的cookie
		driver.manage().deleteAllCookies();
		
	}
		    
	
	/**
	 * 获取所有cookie
	 * @param name
	 */
	public Set<Cookie> getCookies(){  		
		//删除名称为value的cookie
	    
	    return driver.manage().getCookies();
	}
	
	
	
	public Cookie getCookie(String name){
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie cookie : cookies) {
		    if(name.equals(cookie.getName())) {
		        driver.manage().getCookieNamed(name);		       
		    }
		    else{
		    	logger.info("cookie值不存在！！");
	        }
		}
		return driver.manage().getCookieNamed(name);
	}
	
	/**
	 * 获取cookie值,生成一个string对象
	 */
	public String getCookievalue(String name){
		String moduleName=null;
		String Character=null;
		
		Character= getCookie(name).toString();
		if(Character.equals(null)){
			logger.error("该cookie值不存在！！[" +getCookie(name).toString() +"]");	
		}
		else{
			logger.info(" 获取cookie值：[ "+ getCookie(name).toString() +"]");	
		 moduleName = Character.substring(Character.indexOf("=")+1, Character.indexOf(";"));
			
		}
		return moduleName;
		
	}
	
  
	
	
	
		}


