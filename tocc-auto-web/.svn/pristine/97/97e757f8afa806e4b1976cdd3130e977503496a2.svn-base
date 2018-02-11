package com.auto.data.login;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;
import com.config.ReadExcel;
import com.util.CommonMethord;
/**
 * 读取数据父类
 * @author John
 *
 */
public class SystemLoginData {
	
	 @DataProvider(name="SystemLogin")
	 public static String[][] SystemLogin(Method method){
		  String  method1 = Thread.currentThread() .getStackTrace()[1].getMethodName(); 
		 //excel读取数据，返回数组//正则表达式中用 \\\\表示\
		  ReadExcel readexcel=new ReadExcel();
		 return readexcel.readExcel(CommonMethord.getPath().replaceAll("\\\\", "/") + 
				 "/testdata/"+ DataType.Login  + "/"+ method1 + ".xls",method.getName());
		 
		 
		}

	

}

