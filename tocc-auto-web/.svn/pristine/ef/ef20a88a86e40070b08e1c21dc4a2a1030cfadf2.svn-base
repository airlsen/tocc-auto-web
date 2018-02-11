package com.auto.business.infodelivery;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.config.YamlAnalytical;
import com.util.RandomUtil;
import com.util.SeleniumUtil;
/**
 * 信息发布--global业务
 * @author John
 *
 */
public class Globalbusiness extends SeleniumUtil{	

	//yaml解析对象
	public  YamlAnalytical yaml;
	
	public  String TipInformation=null;
	private  Logger logger = Logger.getLogger(Globalbusiness.class.getName());
	//构造函数
	public Globalbusiness(WebDriver driver,String function) {
		super(driver);
		this.yaml = new YamlAnalytical(driver);
		yaml.getYaml(function);
		PageFactory.initElements(driver, this);

	}

	/** 添加-结果函数
	 * @param flag
	 * @return
	 * @throws Exception 
	 * @throws  
	 * @throws  
	 * @throws Exception 
	 */
	public  String addResult(String flag) throws Exception      {
		if(flag.equals("2")){			
			//获取红色提示
			TipInformation=getText(yaml.getElement("红色提示"));
			outFrame();
			//click(x)
			click(yaml.getElement("退出"));			
		}
		else if(flag.equals("1")){
			//跳转iframe(APP-XXFB-GGFB)注意：需要跳转两�?
			outFrame();
			//跳转默认iframe
			outFrame();
			Thread.sleep(1500);
			//获取提示信息
		    TipInformation=getText(yaml.getElement("弹出信息"));    
		    //click确定
		    click(yaml.getElement("确定"));	
		}
		logger.info("实际结果： " +TipInformation);
		return TipInformation;
		}
	
	
	 
		
	/**得到查询结果列表函数
	 * @param element
	 * @return
	 */
	public static List<String> getProducts(List<WebElement> elements) {
		 
		 List<String> products = new ArrayList<String>();
		 List<WebElement> productList=elements;
		 //获取element的所有gettext，生成一个list
		 for(int i=0;i<=productList.size()-1;i++){
			 
			 products.add(productList.get(i).getText());
		 }
		 System.out.println(products);
			return products;
	 }
	
	
	/** 查询结果判断，查询的每一个结果如果包含条件，返回true
	 * @param search
	 * @return
	 */
	public  boolean SearchResults(String search,List<WebElement> element){
		
		for (String temp :getProducts(element)) {						
			if (temp.contains(search)) {
				 return true;
				}
		}		
		return false;
			
		}
	
	/**
	 * 通过js修改属性名字
	 * @param palce
	 * @param attribute
	 * @param value
	 * @return
	 */
	public String attribute(String palce,String attribute,String value){
		
	    //利用js代码修改属性名字
        ((JavascriptExecutor)driver).executeScript("document.getElementById(\""+palce+"\")."+attribute+"=\""+value+"\"");
     
        //利用js代码取出属性名字
        String keyword = (String) ((JavascriptExecutor)driver).executeScript("var input = document.getElementById(\""+palce+"\")."+attribute+";return input");
        return keyword;
		
	}
	
	
	public WebElement redomElement(String key){
		int redom=0;
		//获取当前页的第一列内容的集合，进行查找遍历
		List<WebElement> eles = yaml.getElements(key);
		try{
		RandomUtil re=new RandomUtil();
	    redom=re.getRandom(eles.size()-1);		
	}catch(Exception e){
		logger.info("该elements对象点击失败！！！"+e);
	}
		return yaml.getElements(key).get(redom);
	}
		
	

/**
 * 判断新添加|新修改 的单位是否存在
 * @param text
 */
	public void check(String key,String text) {
		try {
			//查找标志 默认未找到
			@SuppressWarnings("unused")
			boolean flag = false;
			//获取当前页的第一列内容的集合，进行查找遍历
			//List<WebElement> eles = mesureManagePage.getItems();
			List<WebElement> eles = yaml.getElements(key);
			for (WebElement e : eles) {
				//判断是否找到text
				if (text.equals(e.getText())) {
					flag = true;
					e.click();
					logger.info("新添加的单位:{}是否存在：存在并点击"+text);
					break;
				}
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.fail("删除失败"+text);
			e.printStackTrace();
	}
}
	
	
}
