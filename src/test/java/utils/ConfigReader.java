package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties;
	
	public static void loadProperty(String property_filepath) {
		try {
			properties = new Properties();
			FileInputStream fileInputStream = new FileInputStream(property_filepath);
			properties.load(fileInputStream);
		} catch (FileNotFoundException n) {
			n.printStackTrace();
		} catch (IOException r) {
			r.printStackTrace();
		}
	}
	public static String readProperty(String target){
		return properties.get(target).toString();
	}
}
