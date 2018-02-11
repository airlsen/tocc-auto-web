package com.auto.business.infodelivery;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 *信息发布--模板管理-业务
 * @author John
 *
 */
public class Templatebusiness extends Globalbusiness {
	
	public static String TipInformation;
	private static Logger log = Logger.getLogger(Releasebusiness.class.getName());
	/**
	 * 初始化对�?
	 * @throws Exception 
	 */
	public Templatebusiness(WebDriver driver,String function)  {
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
	public String add(String name,String type,String content,String state,String substance,String flag,String expected)
			throws Exception{
		log.info("------------------------信息发布--模板管理--添加功能");
		log.info("预期结果:"+expected);
		//模板管理
		outFrame();
		click(yaml.getElement("模板管理"));
		inFrame("APP-XXFB-MB");
		//click添加		
		click(yaml.getElement("添加"));
		Thread.sleep(2000);
		outFrame();
		inFrame("addEmgMsgTemplate");
		//input模板名称
		sendKeys(yaml.getElement("模板名称"),name);
		//input信息类别
		click(yaml.getElement("信息类别"));
		click(yaml.getElement("选择",type));
		log.info("信息类别"+type);
		//input内容类别
		click(yaml.getElement("内容类别"));
		click(yaml.getElement("选择",content));
		//input状态
		click(yaml.getElement("状态"));
		click(yaml.getElement("选择",state));
		//模板内容
		sendKeys(yaml.getElement("模板内容"),substance);
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
	public void querys(String name,String content,String state) throws Exception    {
		log.info("------------------------信息发布--模板管理--查询功能");
		//回到默认iframe
		outFrame();
		click(yaml.getElement("模板管理"));
		//跳转到iframe
		inFrame("APP-XXFB-MB");
		//input模板名称
		sendKeys(yaml.getElement("模板名称选择"),name);
		//input模板内容
		sendKeys(yaml.getElement("模板内容选择"),content);
		//select信息状
		if(state !=""){
			click(yaml.getElement("状态选择"));
			click(yaml.getElement("选择",state));		
		}
		//点击查询
		click(yaml.getElement("查询"));
		Thread.sleep(1500);
	}
	
	/**
	 * -----删除业务
	 * @return
	 * @throws Exception
	 */
	public String deletes(String index) throws Exception{
		log.info("------------------------信息发布--模板管理--删除功能");		
		//点击删除
		outFrame();
		click(yaml.getElement("模板管理"));
		//跳转默认iframe
		inFrame("APP-XXFB-MB");
		click(yaml.getElements("删除").get(Integer.parseInt(index.trim())));
		 //获取提示信息
		 TipInformation=getText(yaml.getElement("弹出信息"));    
		 //click是
		 click(yaml.getElement("是"));	
		 return TipInformation;
		 
	}
}
	
	


