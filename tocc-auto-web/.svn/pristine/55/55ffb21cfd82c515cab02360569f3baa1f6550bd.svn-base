package com.config;

import org.apache.log4j.Logger;
import org.ho.yaml.Yaml;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 该类为引入 driver对象，通过yaml解析生成元素element对象
 * @author John
 */
public class YamlAnalytical {
	//日志对象
	public static Logger logger = Logger.getLogger(YamlAnalytical.class.getName());
    public  final WebDriver driver;
    private String yamlFile;
 
    //构造方法，传递参数    
    public YamlAnalytical(WebDriver driver) {
        this.driver = driver; 
        PageFactory.initElements(driver, this);      
    }
 

    public static void main(String[] args) throws Exception{
		YamlAnalytical d = new YamlAnalytical(DriverManage.getDriver());
		d.getYaml("Configmanagement/Industrycode");
		System.out.println(ml);	
		System.out.println(d.getElement("名称"));
		

    }
    
    private static HashMap<String, HashMap<String, String>> ml;  
    //private  static HashMap<String, HashMap<String, String>> extendLocator;   
    /** 
     *解析yaml文件方法 
     * @param fileName
     */
    @SuppressWarnings("unchecked")
    public void getYaml(String fileName)  {
    	this.yamlFile="locator/" + fileName + ".yaml";
        File f = new File("locator/" + fileName + ".yaml");
        try {
        	//getAbsolutePath()获取绝对路劲
        	//解析后的格式为  {baidu_input={value=kw, type=id}}
        	ml = Yaml.loadType(new FileInputStream(f.getAbsolutePath()), HashMap.class);
        	logger.info("解析Yaml文件："+ "[" +f.getAbsolutePath()+ "]" );
            //ml.putAll(extendLocator);
        } catch (FileNotFoundException e) {
        	logger.error("解析Yaml文件不存在："+ "[" +f.getAbsolutePath()+ "]" );
        }catch (Exception e) {
        	logger.error("解析Yaml文件失败,Yaml文件内部格式错误！！："+ "[" +f.getAbsolutePath()+ "]" );

        }
    }
         
    /**
     * 把ml变量里的"value"转换成By对象
     * @param type
     * @param value
     * @return
     */
    private By getBy(String type, String value) {
        By by = null;
        if (type.equals("id")) {
            by = By.id(value);
        }
        if (type.equals("name")) {
            by = By.name(value);
        }
        if (type.equals("xpath")) {
            by = By.xpath(value);
        }
        if (type.equals("className")) {
            by = By.className(value);
        }
        if (type.equals("linkText")) {
            by = By.linkText(value);
        }
        if (type.equals("css")) {
            by= By.cssSelector(value);
        }
        return by;
    }
    
    
    public void setLocatorVariableValue(String variable, String value){
        Set<String> keys = ml.keySet();
        for(String key:keys){
             String v = ml.get(key).get("value").replaceAll("%"+variable+"%", value);
             ml.get(key).put("value",v);
        }
    }
 
    
    /**
     * 在这里面的参数用%s来表示，于是在脚本中，我们调用getElement与getElementNoWait方法时需要我们把value
     * 给传进去，我们再来处理下这部分，增加一个方法
     * @param locatorString
     * @param ss
     * @return
     */
    private String getLocatorString(String locatorString, String ss) {
        //for (String s : ss) {
        	//参数是%s，用%s生成
            locatorString = locatorString.replaceFirst("%s", ss);
        //}
        return locatorString;
    }
 
   
 
    
    /**
     * 等待页面元素
     * @param by
     * @return
     */
    private WebElement watiForElement(final By by) {
        WebElement element = null;
        int waitTime = GetTestProperties.waittime();
        try {
            element = new WebDriverWait(driver, waitTime)
                    .until(new ExpectedCondition<WebElement>() {
                        public WebElement apply(WebDriver d) {
                            return d.findElement(by);
                        }
                    });
        } catch (Exception e) {
        	logger.info("对象："+ "[" +by.toString()+ "]" +" is not exist until " + waitTime);
        }
        return element;
    }
 
    /**
     * watiForElement这个方法，返回的WebElement对象包括隐藏的，如果是隐藏的，那么在操作的时候，自然而然会报错
     * 所以，我们得把隐藏的去掉，只显示displayed的元素对象，增加一个方法
     * @param element
     * @return
     */
    private boolean waitElementToBeDisplayed(final WebElement element) {
        boolean wait = false;
        if (element == null)
            return wait;
        try {
            wait = new WebDriverWait(driver, GetTestProperties.waittime())
                    .until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver d) {
                            return element.isDisplayed();
                        }
                    });
        } catch (Exception e) {
            logger.info("对象："+ "[" +element.toString()+ "]" +" is not displayed");
        }
        return wait;
    }
    
    
 
    /**
     * 既然有等待元素对象显示的，那么反之就有等待元素对象消失的方法。
     * @param element
     * @return
     */
    public boolean waitElementToBeNonDisplayed(final WebElement element) {
        boolean wait = false;
        if (element == null)
            return wait;
        try {
            wait = new WebDriverWait(driver, GetTestProperties.waittime())
                    .until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver d) {
                            return !element.isDisplayed();
                        }
                    });
        } catch (Exception e) {
            logger.info("Locator ["+ "[" +element.toString()+ "] is also displayed");
        }
        return wait;
    }
 
    
    /**
     * 现在的问题是getElement与getElementNoWait的方法体很接近，于是我们来重构下这部分的代码，先增加一个方法，存放相同的方法体
     * @param key(key名字)
     * @param replace(替换字段)
     * @param wait(等待时间)
     * @return
     */
    private WebElement getLocator(String key, String replace, boolean wait) {
        WebElement element = null;
        if (ml.containsKey(key)) {	
        	//只获取key的ml  比如{baidu_button={value=%s, type=id}}
            HashMap<String, String> m = ml.get(key);
            //获取其中type值
            String type = m.get("type");
          //获取其中value值
            String value = m.get("value");
            
            if (replace != null){
            	//不为空时，用replace替换value
                value = this.getLocatorString(value, replace);
                }
            
            //生成by对象(by.id("kw"))
            By by = this.getBy(type, value);                       
            if (wait) {
            	//等待element是否存在
                element = this.watiForElement(by);
                boolean flag = this.waitElementToBeDisplayed(element);
                if (!flag)
                    element = null;
             
            } else {
                try {
                    element = driver.findElement(by);
                } catch (Exception e) {
                    element = null;
                }
            }
        } else        
        logger.info("Locator [" +key+ " is not exist in " + yamlFile);
        return element;
    }
    
    
    
    //生成elements

    private List<WebElement> getLocators(String key, String replace) {
    	List<WebElement> elements = null;
    	if (ml.containsKey(key)) {
    		//只获取key的ml  比如{baidu_button={value=%s, type=id}}
            HashMap<String, String> m = ml.get(key);
          //获取其中typeֵ
            String type = m.get("type");
          //获取其中value值ֵ
            String value = m.get("value");
            if (replace != null){
            	//不为空时，用replace替换value
                value = this.getLocatorString(value, replace);
                }
            //生成by对象(by.id("kw"))
            By by = this.getBy(type, value);
            
            try {
                elements = driver.findElements(by);
            } catch (Exception e) {
                elements = null;
                logger.info("["+elements + "]   is null");
            }
    	}else

    	logger.info("Locator [" + key + " ]is not exist in " + yamlFile);
		return elements;
    	
    }
 
    //等待不需替换
    public WebElement getElement(String key) {
        return this.getLocator(key, null, true);
    }
    //不需等待不需替换
    public WebElement getElementNoWait(String key) {
        return this.getLocator(key, null, false);
    }
    //等待且需替换
    public WebElement getElement(String key, String string) {
        return this.getLocator(key, string, true);
    }
   //不等待且需替换
    public WebElement getElementNoWait(String key, String replace) {
        return this.getLocator(key, replace, false);
    }
    
    public List<WebElement> getElements(String key) {
        return this.getLocators(key, null);
    }
    
    
}