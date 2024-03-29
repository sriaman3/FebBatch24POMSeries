package org.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

public class OptionsManager {
	
	private static Properties prop;
	private static ChromeOptions co;
	private static EdgeOptions eo;
	
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	public static ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim()))
		co.addArguments("--headless");
		
		if(Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			co.addArguments("--incognito");
		
		return co;
	}
	
	public static EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim()))
		eo.addArguments("--headless");
		
		if(Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			eo.addArguments("--inprivate");
		
		return eo;
	}

}
