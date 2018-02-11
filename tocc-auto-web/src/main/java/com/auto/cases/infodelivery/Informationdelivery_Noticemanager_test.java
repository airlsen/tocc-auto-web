package com.auto.cases.infodelivery;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.auto.base.BaseParpare;
import com.auto.business.infodelivery.NoticemanagerBusiness;
import com.config.GetTestProperties;
import com.util.RobotScreenShot;
/**Success
 * 信息发布--公告发布管理--功能测试---------------------
 * @author John
 */
public class Informationdelivery_Noticemanager_test extends BaseParpare{	

	//业务对象
	public static NoticemanagerBusiness Monitor=null;
	//日志对象
	private static Logger log = Logger.getLogger(Informationdelivery_Noticemanager_test.class.getName());

	//构造函数传递weburl登录地址
	public Informationdelivery_Noticemanager_test(){		
		this.webUrl=GetTestProperties.getTestUrl("noticeurl");
	}		
	
	/**
	 * 测试添加功能
	 */
    @Test(dataProvider="testData")
    public void add(Map<String, String> data) throws Exception{
		
    	Monitor=new NoticemanagerBusiness(webdriver,targetPath(this.getClass().getName()));	
		//断言
		try {
			assertEquals(data.get("预期结果"), Monitor.add(data.get("标题"),data.get("信息内容"),data.get("flag"),data.get("预期结果")));
		}catch (NoSuchElementException e){
			log.info("执行该条案例报错！");
			log.error("wofe review purchase fail ", e);
			RobotScreenShot.snapShot(this.getClass().getName());	
		}	
    }
  
	/**
	 * 测试查询功能
	 */
    @Test(dataProvider="testData")
    public void query(Map<String, String> data) throws Exception{
		Monitor=new NoticemanagerBusiness(webdriver,targetPath(this.getClass().getName()));	
		//查询

			Monitor.querys(data.get("标题"), data.get("状态"));
		//验证标题
		assertTrue(Monitor.SearchResults(data.get("标题"),Monitor.yaml.getElements("标题列表")));
		
	}
	 
	/**
	 * 测试删除功能
	 * @param index
	 * @throws Exception
	 */
    @Test(dataProvider="testData")
    public void delete(Map<String, String> data) throws Exception{
		
		Monitor=new NoticemanagerBusiness(webdriver,targetPath(this.getClass().getName()));	
		assertEquals("确认要删除吗？",Monitor.deletes(data.get("删除行")));
		 
		 }

}




