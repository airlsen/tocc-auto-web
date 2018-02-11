package com.auto.business.drilltraining;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.auto.business.infodelivery.Globalbusiness;

/**
 *演练培训--演练场景管理-业务
 * @author John
 *
 */
public class Drillscenebusiness extends Globalbusiness {
	
	public static String TipInformation;
	private static Logger log = Logger.getLogger(Drillscenebusiness.class.getName());
	/**
	 * 初始化对象
	 * @throws Exception 
	 */
	public Drillscenebusiness(WebDriver driver,String function)  {
		super(driver,function);
		PageFactory.initElements(driver, this);
	}	

	/**
	 * -----添加业务
	 * @param title
	 * @param content
	 * @param flag
	 * @param expected
	 * @return
	 * @throws Exception
	 */
	public String add(String sightName,String discription ,String flag,String expected)
			throws Exception{
		log.info("------------------------演练培训--演练场景管理--添加功能");
		log.info("预期结果：   "+expected);
		//演练场景管理
		outFrame();
		click(yaml.getElement("演练场景管理"));
		inFrame("APP-YLPX-YLGL-YLCJ");
		//click添加		
		click(yaml.getElement("添加"));
		pause(1);
		outFrame();
		inFrame("addEmgDrillSight");
		//input演练场景名称
		sendKeys(yaml.getElement("演练场景名称"),sightName);
		//所属专题
		click(yaml.getElement("所属专题"));
		click(redomElement("所属专题选择"));
		//使用程度
		click(yaml.getElement("使用程度"));
		click(redomElement("使用程度选择"));
		//input场景描述
		sendKeys(yaml.getElement("场景描述"),discription);
		//click保存草稿
		click(yaml.getElement("保存"));

		return addResult(flag);
		
	}
	/**
	 * -----查询业务
	 * @param title
	 * @param state
	 * @throws Exception
	 */
	public void querys(String sightName,String sighttype,String userTime) throws Exception    {
		log.info("------------------------演练培训--演练场景管理--查询功能");
		//回到默认iframe
		outFrame();
		click(yaml.getElement("演练场景管理"));
		//跳转到iframe
		inFrame("APP-YLPX-YLGL-YLCJ");
		//input标题
		sendKeys(yaml.getElement("名称"),sightName);
		//select信息状态
		if(sighttype !=""){
			click(yaml.getElement("专题"));
			click(yaml.getElement("专题选择",sighttype));		
		}
		if(userTime !=""){
			click(yaml.getElement("使用程度"));
			click(yaml.getElement("使用程度选择",userTime));		
		}
		//点击查询
		click(yaml.getElement("查询"));
		pause(1);
	}
	
	/**
	 * -----删除业务
	 * @return
	 * @throws Exception
	 */
	public String deletes(String index) throws Exception{
		log.info("------------------------演练培训--演练场景管理--删除功能");		
		//任意选择列点击删除
		outFrame();
		click(yaml.getElement("演练场景管理"));
		//跳转默认iframe
		inFrame("APP-YLPX-YLGL-YLCJ");
		click(yaml.getElements("删除").get(Integer.parseInt(index.trim())));
		 //获取提示信息
		 TipInformation=getText(yaml.getElement("弹出信息"));    
		 //click是
		 click(yaml.getElement("是"));	
		 return TipInformation;
		 
	}
}
	
	


