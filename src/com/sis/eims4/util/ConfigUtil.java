package com.sis.eims4.util;

import java.io.InputStream;
import java.util.Properties;
/**
 *読み取り属性ファイル
 * @author tester
 *
 */
public class ConfigUtil {
	private static Properties pro = new Properties();
	/**
	 *ロード属性ファイル
	 */
	static{
		InputStream is = ConfigUtil.class.getClassLoader().getResourceAsStream("app.properties");
		try{
			pro.load(is);
		}catch(Exception e){
			e.printStackTrace();
		}

	}


	/**
	 *属性ファイルのキーによって獲得相応の値
	 * @param key         キー
	 * @return value      値
	 */
	public static String getValue(String key){
		return pro.getProperty(key);
	}
}
