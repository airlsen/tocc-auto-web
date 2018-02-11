
package com.auto.data.login;

import com.util.CommonMethord;

public class Test {


public static void testGetClassName() {  
    // 方法1：通过SecurityManager的保护方法getClassContext()  
    String clazzName = new SecurityManager() {  
        public String getClassName() {  
            return getClassContext()[1].getName();  
        }  
    }.getClassName();  
    System.out.println(clazzName); 
    
    
    // 方法2：通过Throwable的方法getStackTrace()  
    String clazzName2 = new Throwable().getStackTrace()[1].getClassName();  
    System.out.println(clazzName2);  
   
    
    // 方法3：通过分析匿名类名称()  
    String clazzName3 = new Object() {  
        public String getClassName() {  
            //String clazzName = this.getClass().getName(); 
            String method = Thread.currentThread() .getStackTrace()[1].getMethodName(); 
            return method;
        }  
    }.getClassName();  
    System.out.println(clazzName3);  
    //方法4：通过Thread的方法getStackTrace()  
    String clazzName4 = Thread.currentThread().getStackTrace()[2].getClassName();  
    System.out.println(clazzName4);  
}


public static String getClassName() {  
    //String clazzName = this.getClass().getName(); 
    String method = Thread.currentThread() .getStackTrace()[1].getMethodName(); 
    return method;
}

public static void main(String[] args){
	Test.testGetClassName();
	System.out.println(CommonMethord.getPath().replaceAll("\\\\", "/")+"/testdata/"+DataType.Login+"/"+getClassName()+".xls");

}




}