package com.auto.cases.drilltraining;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.auto.base.BaseParpare;
import com.auto.business.drilltraining.Trainingcoursebusiness;
import com.config.GetTestProperties;
import com.util.RobotScreenShot;
/**Success
 * 演练培训--培训管理--培训课程--功能测试---------------------
 * @author John
 */
public class Drilltraining_Trainingcourse_test extends BaseParpare{	
	//业务对象
	public static Trainingcoursebusiness drill=null;
	//日志对象
	private static Logger log = Logger.getLogger(Drilltraining_Trainingcourse_test.class.getName());

	//构造函数传递weburl登录地址
	public Drilltraining_Trainingcourse_test(){		
		this.webUrl=GetTestProperties.getTestUrl("drillurl");
			}
	
	/**
	 * 测试添加功能
	 */
    @Test(dataProvider="testData",enabled=true)
    public void add(Map<String, String> data) throws Exception{
		
    	drill=new Trainingcoursebusiness(webdriver,targetPath(this.getClass().getName()));	
		//断言
		try {
			assertEquals(data.get("预期结果"), drill.add(data.get("课程名称"),data.get("授课老师"),data.get("课时"),data.get("课程描述"),data.get("flag"),data.get("预期结果")));
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
    	drill=new Trainingcoursebusiness(webdriver,targetPath(this.getClass().getName()));	
		//查询
    	drill.querys(data.get("课程名称"), data.get("授课老师"),data.get("授课类型"));
		//验证标题
    	try{
		assertTrue(drill.SearchResults(data.get("课程名称"),drill.yaml.getElements("名称列表")));
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
		
    	drill=new Trainingcoursebusiness(webdriver,targetPath(this.getClass().getName()));	
		assertEquals("确认要删除培训课程系长吗？",drill.deletes(data.get("删除行")));
		 
		 }
  

}
