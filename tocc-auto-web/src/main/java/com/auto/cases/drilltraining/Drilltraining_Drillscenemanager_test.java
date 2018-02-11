package com.auto.cases.drilltraining;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.auto.base.BaseParpare;
import com.auto.business.drilltraining.Drillscenebusiness;
import com.config.GetTestProperties;
import com.util.RobotScreenShot;
/**Success
 * 演练培训--演练管理--演练场景管理--功能测试---------------------
 * @author John
 */
public class Drilltraining_Drillscenemanager_test extends BaseParpare{	
	//业务对象
	public static Drillscenebusiness drill=null;
	//日志对象
	private static Logger log = Logger.getLogger(Drilltraining_Drillscenemanager_test.class.getName());

	//构造函数传递weburl登录地址
		public Drilltraining_Drillscenemanager_test(){
		this.webUrl=GetTestProperties.getTestUrl("drillurl");
		}
	/**
	 * 测试添加功能
	 */
    @Test(dataProvider="testData",enabled=true)
    public void add(Map<String, String> data) throws Exception{
		
    	drill=new Drillscenebusiness(webdriver,targetPath(this.getClass().getName()));	
		//断言
		try {
			assertEquals(data.get("预期结果"), drill.add(data.get("演练场景名称"),data.get("场景描述"),data.get("flag"),data.get("预期结果")));
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
    	drill=new Drillscenebusiness(webdriver,targetPath(this.getClass().getName()));	
		//查询
    	drill.querys(data.get("名称"), data.get("专题"),data.get("使用程度"));
		//验证标题
    	try{
		assertTrue(drill.SearchResults(data.get("名称"),drill.yaml.getElements("名称列表")));
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
		
    	drill=new Drillscenebusiness(webdriver,targetPath(this.getClass().getName()));	
		assertEquals("确认要删除吗？",drill.deletes(data.get("删除行")));
		 
		 }
  
  

	



}
