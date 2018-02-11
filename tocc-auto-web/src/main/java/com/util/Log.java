package com.util;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/**
 * 日志类
 * @author John
 *
 */
public class Log {
	
	private static Logger logger;
	private static String filepath="conf/log4j.properties";
	private static boolean flag=false;
	
	private static synchronized void getPropertyFile(){
		
		logger=Logger.getLogger("TestProject");
		PropertyConfigurator.configure(new File(filepath).getAbsolutePath());
		flag=true;
	}
	
	private static void getFlag(){
		
		if(flag==false)
			Log.getPropertyFile();
		
	}
	
	public static void logInfo(String message){
		Log.getFlag();
		logger.info(message);
		
	}
	
	public static void logError(String message){
		Log.getFlag();
		logger.error(message);
		
	}
	
	public static void logWarn(String message){
		Log.getFlag();
		logger.warn(message);
		
	}
	
	
	
	/**
	 * 调用方式--示例
	 * @param arg
	 */
	public static void main(String[] arg){
		
		Log.logInfo("nihao ");

		
		
		
		}
	
	
	
	
	
	
		
		
		

	
	
	}
	


