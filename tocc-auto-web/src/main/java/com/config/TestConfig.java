﻿package com.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;



public class TestConfig {
	private static Logger log = Logger.getLogger(TestConfig.class.getName());
	private Properties propertie;
	private FileInputStream inputfile;
	
    //构造函数，读取配置文件
	// 读取配置文件
	public TestConfig(String filepath) {
		try {
			//获取配置文件路径
			filepath = System.getProperty("user.dir") + filepath;

		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		propertie = new Properties();
		try {
			inputfile = new FileInputStream(filepath);
			propertie.load(inputfile);
			inputfile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**  
	    * 更新properties文件的键值对  
	    * 如果该主键已经存在，更新该主键的值；  
	    * 如果该主键不存在，则插件一对键值。  
	    * @param keyname 键名  
	    * @param keyvalue 键值  
	    */  
	public void writeProperties(String keyname,String keyvalue) {   
        try {   
        	//属性文件的路径   
             String filepath="/conf/cookie.properties";        
             //加载文件
            filepath = System.getProperty("user.dir") + filepath;
            propertie = new Properties();
            propertie.load(new FileInputStream(filepath));   
            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。   
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。   
            OutputStream fos = new FileOutputStream(filepath);              
            propertie.setProperty(keyname, keyvalue);                 
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流   
            propertie.store(fos, "Update '" + keyname + "' value");     
            log.info("更新properties文件值: [ "+keyname+":"+keyvalue+" ]操作完成！");
        } catch (IOException e) {   
        	e.printStackTrace();
        	log.info("属性文件名更新错误！     ");
 
        }   
    }   
	
	
	
	

	// 得到对应key的值
	public String getValue(String key) {
		if (propertie.containsKey(key)) {
			String value = propertie.getProperty(key);
			return value;
		} else
			log.info("配置文件propertie中： "+key+" 值不存在！！！");
			return "";
	}
	
	
	
	/**
	 * 获取cookies值
	 * @return
	 */
	public  String getCookie(){
		String cookie = getValue("JSESSIONID");
		return cookie;
	}
	
	
	//测试
	public static void main(String[] args) {   
		
		TestConfig a=new TestConfig("/conf/cookie.properties");
        a.writeProperties("JSESSIONID", "327@qq.com217777777777777777");          

    }  
}
