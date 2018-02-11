package com.auto.business.infodelivery;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 *信息发布--公告发布管理-业务
 * @author John
 *
 */
public class NoticemanagerBusiness extends Globalbusiness {
	
	public static String TipInformation;
	private static Logger log = Logger.getLogger(NoticemanagerBusiness.class.getName());
	/**
	 * 初始化对象
	 * @throws Exception 
	 */
	public NoticemanagerBusiness(WebDriver driver,String function)  {
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
	public String add(String title,String content ,String flag,String expected)
			throws Exception{
		log.info("------------------------信息发布--公告发布管理--添加功能");
		log.info("预期结果"+expected);
		//公告发布管理
		outFrame();
		click(yaml.getElement("公告发布管理"));
		inFrame("APP-XXFB-GGFB");
		//click添加		
		click(yaml.getElement("添加"));
		Thread.sleep(2000);
		outFrame();
		inFrame("addEmgInfoNotice");
		//input标题
		sendKeys(yaml.getElement("标题"),title);
		//input信息内容
		sendKeys(yaml.getElement("信息内容"),content);
		//click保存草稿
		click(yaml.getElement("保存草稿"));

		return addResult(flag);
		
	}
	/**
	 * -----查询业务
	 * @param title
	 * @param state
	 * @throws Exception
	 */
	public void querys(String title,String state) throws Exception    {
		log.info("------------------------信息发布--公告发布管理--查询功能");
		//回到默认iframe
		outFrame();
		click(yaml.getElement("公告发布管理"));
		//跳转到iframe
		inFrame("APP-XXFB-GGFB");
		//input标题
		sendKeys(yaml.getElement("标题"),title);
		//select信息状态
		if(state !=""){
			click(yaml.getElement("状态"));
			click(yaml.getElement("状态选择",state));		
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
		log.info("------------------------信息发布--公告发布管理--删除功能");		
		//任意选择列点击删除
		outFrame();
		click(yaml.getElement("公告发布管理"));
		//跳转默认iframe
		inFrame("APP-XXFB-GGFB");
		click(yaml.getElements("删除").get(Integer.parseInt(index.trim())));
		 //获取提示信息
		 TipInformation=getText(yaml.getElement("弹出信息"));    
		 //click是
		 click(yaml.getElement("是"));	
		 return TipInformation;
		 
	}
}
	
	


