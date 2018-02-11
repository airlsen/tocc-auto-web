package com.auto.business.configmanagement;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.auto.business.infodelivery.Globalbusiness;

/**
 *配置管理--行业代码管理-业务
 * @author John
 *
 */
public class Industrycodebusiness extends Globalbusiness {
	
	public static String TipInformation;
	private static Logger log = Logger.getLogger(Industrycodebusiness.class.getName());
	/**
	 * 初始化对象
	 * @throws Exception 
	 */
	public Industrycodebusiness(WebDriver driver,String function)  {
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
	public String add(String codeValue,String codeName,String standard,String field,String remark,String codetype,
			String codetypeName,String parentCode,String flag,String expected)throws Exception{
		log.info("------------------------配置管理--行业代码管理--添加功能");
		log.info("预期结果：   "+expected);
		//系统代码管理
		outFrame();
		click(yaml.getElement("行业代码管理"));
		inFrame("APP-PZGL-SJZD-HYDM");
		//click添加		
		click(yaml.getElement("添加"));
		outFrame();
		inFrame("addEmgDict");
		//input代码值
		sendKeys(yaml.getElement("代码值"),codeValue);
		//名称
		sendKeys(yaml.getElement("添加名称"),codeName);;
		//编码标准
		sendKeys(yaml.getElement("编码标准"),standard);
		//input变更通知
		sendKeys(yaml.getElement("变更通知"),field);
		//click备注
		sendKeys(yaml.getElement("备注"),remark);
		//input代码类别
		sendKeys(yaml.getElement("代码类别"),codetype);
		//input代码类别名
		sendKeys(yaml.getElement("代码类别名"),codetypeName);
		//input父代码值
		sendKeys(yaml.getElement("父代码值"),parentCode);
		//click保存
		click(yaml.getElement("保存"));

		return addResult(flag);
		
	}
	/**
	 * -----查询业务
	 * @param title
	 * @param state
	 * @throws Exception
	 */
	public void querys(String codeName) throws Exception    {
		log.info("------------------------配置管理--行业代码管理--查询功能");
		//回到默认iframe
		outFrame();
		click(yaml.getElement("行业代码管理"));
		//跳转到iframe
		inFrame("APP-PZGL-SJZD-HYDM");
		//input名称
		sendKeys(yaml.getElement("名称"),codeName);
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
		log.info("------------------------配置管理--行业代码管理--删除功能");		
		//任意选择列点击删除
		outFrame();
		click(yaml.getElement("行业代码管理"));
		//跳转默认iframe
		inFrame("APP-PZGL-SJZD-HYDM");
		click(yaml.getElements("删除").get(Integer.parseInt(index.trim())));
		 //获取提示信息
		 TipInformation=getText(yaml.getElement("弹出信息"));    
		 //click是
		 click(yaml.getElement("是"));	
		 outFrame();
		 pause(1);
		 //click确定
		click(yaml.getElement("确定"));
		 return TipInformation;
		 
	}
}
	
	


