package com.util;

/**
 * 随机数生成类
 * @author John
 */
public class RandomUtil {
	
	/**
	 * 返回一个0-count(包含count)的随机数
	 * @param count
	 * @return
	 */
	public int getRandom(int count){
		
		return (int) Math.round(Math.random() * (count));
		
	}
	
	private String string="0123456789abcdefghijklmnopqrstuvwxyz";
	
	/**
	 * 从0123456789abcdefghijklmnopqrstuvwxyz随机选择
	 * 生成长度为length的字符串
	 * @param length
	 * @return
	 */
	public String getRandomString(int length){
		StringBuffer sb=new StringBuffer();
		@SuppressWarnings("unused")
		int len=string.length();
		for(int i=0;i<length;i++){
			sb.append(string.charAt(this.getRandom(length-1)));
		}
		return sb.toString();			
			
		}
	
	public static void main(String[] args){
		RandomUtil ru=new RandomUtil();
		for(int i=0;i<20;i++){
			System.out.println(ru.getRandom(6));
			
		}
		
		
	}
		
	}
	


