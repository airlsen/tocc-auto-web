package com.auto.cases.configmanagement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.auto.base.BaseParpare;
import com.auto.business.configmanagement.Industrycodebusiness;
import com.config.GetTestProperties;
import com.util.RobotScreenShot;
/**Success
 * 配置管理--数据字典管理--行业代码管理--功能测试---------------------
 * @author John
 */
public class Configmanagement_Industrycode_test extends BaseParpare{	
	//业务对象
	public static Industrycodebusiness config =null;
	//日志对象
	private static Logger log = Logger.getLogger(Configmanagement_Industrycode_test.class.getName());
	//构造函数传递weburl登录地址
	public Configmanagement_Industrycode_test(){
		
	    this.webUrl=GetTestProperties.getTestUrl("configurl");
	}
	
	/**
	 * 测试添加功能
	 */
    @Test(dataProvider="testData",enabled=true)
    public void add(Map<String, String> data) throws Exception{
		
    	config=new Industrycodebusiness(webdriver,targetPath(this.getClass().getName()));	
		//断言
		try {
			assertEquals(data.get("预期结果"),config.add(data.get("代码值"),data.get("添加名称"),data.get("编码标准"),data.get("变更通知"),data.get("备注"),data.get("代码类别"),data.get("代码类别名"),data.get("父代码值"),data.get("flag"),data.get("预期结果")));
		}catch (NoSuchElementException e){
			log.info("执行该条案例报错！");
			log.error("wofe review purchase fail ", e);
			RobotScreenShot.snapShot(this.getClass().getName());
		
		}	
    }
    
    /**
	 * 测试查询功能
	 */
    @Test(dataProvider="testData",enabled=true)
    public void query(Map<String, String> data) throws Exception{
    	config=new Industrycodebusiness(webdriver,targetPath(this.getClass().getName()));	
		//查询
    	config.querys(data.get("名称"));
		//验证标题
    	try{
		assertTrue(config.SearchResults(data.get("名称"),config.yaml.getElements("名称列表")));
    	}catch(Exception e){
    		log.error("expected [true] but found [false]", e);
    		
    	}
		
	}
  

	 
	/**
	 * 测试删除功能
	 * @param index
	 * @throws Exception
	 */
    @Test(dataProvider="testData",enabled=true)
    public void delete(Map<String, String> data) throws Exception{
		
    	config=new Industrycodebusiness(webdriver,targetPath(this.getClass().getName()));	
		assertEquals("确认要删除吗？",config.deletes(data.get("line")));
		 
		 }
  
  



}
