package com.auto.cases.infodelivery;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.auto.base.BaseParpare;
import com.auto.business.infodelivery.Templatebusiness;
import com.config.GetTestProperties;
import com.util.RobotScreenShot;

/**failed
 * 信息发布--模板管理--功能测试---------------------
 * @author John
 *
 */
public class Informationdelivery_Templatemanager_test extends BaseParpare {	
	//添加业务对象
	public static Templatebusiness Monitor;
	//日志对象
	private static Logger log = Logger.getLogger("Templatecase");

	//构造函数传递weburl登录地址
	public Informationdelivery_Templatemanager_test(){		
		this.webUrl=GetTestProperties.getTestUrl("noticeurl");
	}
	/**
	 * 测试添加功能
	 * @param title
	 * @param content
	 * @param flag
	 * @param expected
	 * @throws Exception
	 */
    @Test(dataProvider="testData")
    public void add(Map<String, String> data) throws Exception{  
		try{		
			Monitor=new Templatebusiness(webdriver,targetPath(this.getClass().getName()));			
			//断言
			assertEquals(data.get("预期结果"), Monitor.add(data.get("模板名称"),data.get("信息内别"),data.get("内容类别"),data.get("状态"),data.get("模板内容"),data.get("flag"),data.get("预期结果")));
			
			}catch (NoSuchElementException e){
				   log.error("wofe review purchase fail ", e);
				   RobotScreenShot.snapShot(this.getClass().getName());
			 }	  
  }
	/**
	 * 测试查询功能
	 * @param title
	 * @param state
	 * @throws Exception
	 */
    @Test(dataProvider="testData")
    public void query(Map<String, String> data) throws Exception{ 
		Monitor=new Templatebusiness(webdriver,targetPath(this.getClass().getName()));	
		//查询
		Monitor.querys(data.get("模板名称"), data.get("信息内别"),data.get("状态"));
		//验证标题
		assertTrue(Monitor.SearchResults(data.get("模板名称"),Monitor.yaml.getElements("模板名称列表")));
		//验证状态
		//assertTrue(Monitor.SearchResults(state,Monitor.yaml.getElements("状�?列表")));
		
	}
		 
	/**
	 * 测试删除功能
	 * @param index
	 * @throws Exception
	 */
    @Test(dataProvider="testData")
    public void delete(Map<String, String> data) throws Exception{		
		Monitor=new Templatebusiness(webdriver,targetPath(this.getClass().getName()));	
		assertEquals("确认要删除吗？",Monitor.deletes(data.get("删除行")));
		 
		 }
  


}
