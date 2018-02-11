package com.config;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;





/**解析xml文件，需要知道xml文件路径，然后根据其路径加载xml文件后，生成一个
 * Document的对象，于是我们先定义两个变量String filePath，Document document
 * 然后再定义一个load方法，这个方法用来加载xml文件，从而产生document对象
 * @author John
 *
 */

public class ParseXml {
	
	private String filepath;
	private Document document;
	
	/**
	 * 构造器用来new parseXml对象时，传一个filepath的参数进来，从而初始化filepath的值
	 * 调用load方法，从而在ParseXml对象产生时，就会生成一个Document对象
	 * @param filePath
	 */
	public ParseXml(String filePath){
		this.filepath=filePath;
		this.load(this.filepath);
		
	}
	
	/**
	 * 用来加载xml文件，并且产生一个document的对象
	 * @param filePath
	 */
	private void load(String filePath){
		File file=new File(filePath);
		if(file.exists()){
			SAXReader saxReader=new SAXReader();
			try{
				document=saxReader.read(file);
			}catch(DocumentException e){
				System.out.println("文件加载异常："+filePath);
				
			}
			
		}else{
			System.out.println("文件不存在："+filePath);
		}
	}
	
	
	/**
	 * @param elementPath elementPath是一个xpath路径，比如"/config/friver"
	 * @return 返回的是一个节点Element对象
	 */
	private Element getElementObject(String elementPath){
		return (Element)
				document.selectSingleNode(elementPath);
		
	}
	
	/**
	 * 用xpath来判断一个节点对象是否存在
	 * @param elementPath
	 * @return
	 */
	public boolean isExist(String elementPath){
		boolean flag=false;
		Element element=this.getElementObject(elementPath);
		if(element !=null)
			flag=true;
		return flag;
		
		
	}
	
	/**
	 * 用xpath来取得一个节点对象的值
	 * @param elementPath
	 * @return
	 */
	public String getElementText(String elementPath){
		
		Element element=this.getElementObject(elementPath);
		if(element != null){
			return element.getText().trim();
		
		}else{
			return null;
		}
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<Element> getElementObjects(String elementPath){
		return document.selectNodes(elementPath);
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String,String> getChildrenInfoByElement(Element element){
		Map<String,String> map=new HashMap<String,String>();
		List<Element>children=element.elements();
		for(Element e :children){
			map.put(e.getName(), e.getText());
		}
		return map;

	}
	
	
	

	public static void main(String[] args){
		ParseXml px=new ParseXml("conf/config.xml");
		
		//ParseXml px=new ParseXml("C:/Users/John/workspace/Tocc-auto-test/conf/config.xml");
		//config.xml的路径
		String browser=px.getElementText("/conf/browser");
		
		System.out.println(browser);
		
		String waitTiem=px.getElementText("/conf/waitTime");
		System.out.println(waitTiem);
		
		
		
	}
	
	

}
