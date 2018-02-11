package com.auto.base;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;




public class asd {
	private static Logger logger = Logger.getLogger(asd.class.getName());

	
	public static String switchtoString(WebElement element){
		String Character=null;
		String moduleName=null;
		try{
		if(element != null){
			 Character=element.toString();			
		}
		moduleName = Character.substring(Character.lastIndexOf(">")+1, Character.lastIndexOf("]"));	
		}catch(Exception e){
			
		}
		return moduleName;
	}
	
	public  String targetPath(String className){
		String pathName=null;
		String yamlPath=null;//用例编号
		int dotIndexNum = className.lastIndexOf("."); // 取得第一个.的index
		try{
		if(dotIndexNum > 0){
			pathName = className.substring(dotIndexNum+1, className.lastIndexOf("_")); 
			yamlPath=pathName.replaceAll("_", "/")+"/";		
		}
		}catch(Exception e){
			logger.info("测试类文件名格式不正确，请修改！！"+ "[" +className+ "]" );
		}
		return yamlPath;
	}
	
	public void a(){
		logger.info("1111111111111111111");
	}

	
	public static void main(String[] args){
		asd b=new asd();
		b.a();

	}

}
