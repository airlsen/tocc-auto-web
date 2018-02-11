package com.auto.business.datamanagement;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.auto.business.infodelivery.Globalbusiness;

/**
 *数据管理--外场设备--视频监控设备管理--业务
 * @author John
 *
 */
public class Videosurveillancebusiness extends Globalbusiness {
	
	public static String TipInformation;
	private static Logger log = Logger.getLogger(Videosurveillancebusiness.class.getName());
	/**
	 * 初始化对象
	 * @throws Exception 
	 */
	public Videosurveillancebusiness(WebDriver driver,String function)  {
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
	public String add(String placeName,String address,String longitude ,String latitude,String flag,String expected)
			throws Exception{
		log.info("------------------------数据管理--视频监控设备管理--添加功能");
		log.info("预期结果：   "+expected);
		//演练场景管理
		outFrame();
		click(yaml.getElement("视频监控设备管理"));
		inFrame("APP-SJGL-WCSB-SPGL");
		//click添加		
		click(yaml.getElement("添加"));
		outFrame();
		inFrame("addResCameraPlace");
		//input名称
		sendKeys(yaml.getElement("名称"),placeName);
		//input地址
		sendKeys(yaml.getElement("地址"),address);
		//input类型
		click(yaml.getElement("类型"));
		click(redomElement("类型选择"));
		//input行政区域
		//click(yaml.getElement("行政区域"));
		//click(redomElement("行政区域选择"));
		//input状态
		click(yaml.getElement("状态"));
		click(redomElement("状态选择"));
		//input经度
		sendKeys(yaml.getElement("经度"),longitude);
		//input维度
		sendKeys(yaml.getElement("纬度"),latitude);
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
	public void querys(String placeName,String type) throws Exception{
		log.info("------------------------数据管理--视频监控设备管理--查询功能");
		//回到默认iframe
		outFrame();
		click(yaml.getElement("视频监控设备管理"));
		//跳转到iframe
		inFrame("APP-SJGL-WCSB-SPGL");
		//input标题
		sendKeys(yaml.getElement("地点名称"),placeName);
		//select信息状态
		if(type !=""){
			click(yaml.getElement("位置类型"));
			click(yaml.getElement("位置类型选择",type));		
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
		log.info("------------------------数据管理--视频监控设备管理--删除功能");	
		//任意选择列点击删除
		outFrame();
		click(yaml.getElement("视频监控设备管理"));
		//跳转默认iframe
		inFrame("APP-SJGL-WCSB-SPGL");
		click(yaml.getElements("删除").get(Integer.parseInt(index.trim())));
		 //获取提示信息
		 TipInformation=getText(yaml.getElement("弹出信息"));    
		 //click是
		 click(yaml.getElement("是"));
		 outFrame();
		 click(yaml.getElement("确定"));
		 return TipInformation;
		 
	}
}
	
	


