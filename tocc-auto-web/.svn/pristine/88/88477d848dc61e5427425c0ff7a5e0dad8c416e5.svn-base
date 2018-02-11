package com.auto.cases.datamanagement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.auto.base.BaseParpare;
import com.auto.business.datamanagement.Videosurveillancebusiness;
import com.config.GetTestProperties;
import com.util.RobotScreenShot;
/**Success
 * 数据管理--外场设备--视频监控设备管理--功能测试---------------------
 * @author John
 */
public class Datamanagement_Videosurveillance_test extends BaseParpare{	
	//业务对象
	public static Videosurveillancebusiness drill=null;
	//日志对象
	private static Logger log = Logger.getLogger(Datamanagement_Videosurveillance_test.class.getName());

	//构造函数传递weburl登录地址
	public Datamanagement_Videosurveillance_test(){
	this.webUrl=GetTestProperties.getTestUrl("managerurl");
	}
	
	/**
	 * 测试添加功能
	 */
    @Test(dataProvider="testData",enabled=true)
    public void add(Map<String, String> data) throws Exception{
		
    	drill=new Videosurveillancebusiness(webdriver,targetPath(this.getClass().getName()));	
		//断言
		try {
			assertEquals(data.get("预期结果"),drill.add(data.get("名称"),data.get("地址"),data.get("经度"),data.get("纬度"),data.get("flag"),data.get("预期结果")));
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
    	drill=new Videosurveillancebusiness(webdriver,targetPath(this.getClass().getName()));	
		//查询
    	drill.querys(data.get("地点名称"), data.get("位置类型"));
		//验证标题
    	try{
		assertTrue(drill.SearchResults(data.get("地点名称"),drill.yaml.getElements("名称列表")));
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
		
    	drill=new Videosurveillancebusiness(webdriver,targetPath(this.getClass().getName()));	
		assertEquals("确认删除视频及监控设备信息吗？",drill.deletes(data.get("删除行")));
		 
		 }
  
  

	



}
