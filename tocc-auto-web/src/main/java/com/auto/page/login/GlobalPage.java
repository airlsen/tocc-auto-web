﻿package com.auto.page.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.util.SeleniumUtil;


public class GlobalPage extends SeleniumUtil{
	public WebDriver driver=null;
	private static Logger log = Logger.getLogger(GlobalPage.class.getName());
	
	/**
	 * 初始化对象
	 * @throws Exception 
	 */
	public GlobalPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	/**
	 * get弹出框提示信息
	 * @param text
	 * @return
	 */
	public  String GetInformation(String text){
		//获取提示信息
		String Information=getText(By.xpath("//div[contains(text(),'"+text+"')]"));
		//日志
		log.info("实际结果(弹出提示框)："+Information);
		return Information;
		
	}
	
	/**
	 * click确定
	 */
	public  void keyboard(){
		//日志
		log.info("确定");
		//回车键
		Keyboard(By.xpath("//*[@class='l-btn-text'][text()='确定']"), Keys.ENTER);
	}
	
	
		
		


}